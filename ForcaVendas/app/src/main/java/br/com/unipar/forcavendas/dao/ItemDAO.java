package br.com.unipar.forcavendas.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import br.com.unipar.forcavendas.helper.SQLiteDataHelper;
import br.com.unipar.forcavendas.model.Item;

public class ItemDAO implements GenericDAO<Item>{

    private SQLiteOpenHelper openHelper;

    private SQLiteDatabase bd;

    private String[] colunas = {"CODIGO", "DESCRICAO", "VLRUNIT", "UNMEDIDA"};

    private String tableName = "ITEM";

    private Context context;

    private static ItemDAO instancia;

    public static ItemDAO getInstancia(Context context){
        if(instancia == null){
            return instancia = new ItemDAO(context);
        } else {
            return instancia;
        }
    }

    private ItemDAO(Context context) {
        this.context = context;
        openHelper = new SQLiteDataHelper(this.context, "UNIPAR", null, 1);
        bd = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(Item object) {
        try{
            ContentValues valores = new ContentValues();
            valores.put("CODIGO", object.getCodigo());
            valores.put("DESCRICAO", object.getDescricao());
            valores.put("UNMEDIDA", object.getUnMedida());
            valores.put("VLRUNIT", object.getVlrUnit());

            return bd.insert(tableName, null, valores);
        }catch (SQLException ex){
            Log.e("Erro", "ItemDAO.insert: "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public long update(Item object) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("DESCRICAO", object.getDescricao());;
            valores.put("UNMEDIDA", object.getUnMedida());
            valores.put("VLRUNIT", object.getVlrUnit());

            String[]identificador = {String.valueOf(object.getCodigo())};

            return bd.update(tableName, valores, "CODIGO = ?", identificador);

        }catch (SQLException ex){
            Log.e("Erro", "ItemDAO.update: "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public long delete(Item object) {
        try{
            String[]identificador = {String.valueOf(object.getCodigo())};

            return bd.delete(tableName, "CODIGO = ?", identificador);
        }catch (SQLException ex){
            Log.e("Erro", "ItemDAO.delete: "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public ArrayList<Item> getAll() {
        ArrayList<Item> lista = new ArrayList<>();

        try {
            Cursor cursor = bd.query(tableName, colunas, null, null, null, null, "CODIGO asc");

            if (cursor.moveToFirst()){
                do{
                    Item item = new Item();
                    item.setCodigo(cursor.getInt(0));
                    item.setDescricao(cursor.getString(1));
                    item.setVlrUnit(cursor.getDouble(2));
                    item.setUnMedida(cursor.getString(3));
                    lista.add(item);
                }while (cursor.moveToNext());
            }
        }catch (SQLException ex) {
            Log.e("Erro", "ItemDAO.getAll: "+ex.getMessage());
        }
        return lista;
    }

    @Override
    public Item getById(int id) {
        try {
            String[]identificador = {String.valueOf(id)};
            Cursor cursor = bd.query(tableName, colunas, "CODIGO = ?", identificador, null, null, "CODIGO asc");

            if (cursor.moveToFirst()){
                Item item = new Item();
                item.setCodigo(cursor.getInt(0));
                item.setDescricao(cursor.getString(1));
                item.setVlrUnit(cursor.getDouble(2));
                item.setUnMedida(cursor.getString(3));

                return item;
            }
        }catch (SQLException ex) {
            Log.e("Erro", "ItemDAO.getById: "+ex.getMessage());
        }
        return null;
    }
}
