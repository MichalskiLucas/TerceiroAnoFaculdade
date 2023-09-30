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
import br.com.unipar.forcavendas.model.ItemPedidoVenda;
import br.com.unipar.forcavendas.model.PedidoVenda;

public class ItemPedidoVendaDAO implements GenericDAO<ItemPedidoVenda> {
    private SQLiteOpenHelper openHelper;

    private SQLiteDatabase bd;

    private String[] colunas = {"CODIGO", "CODIGOPEDIDO", "CODIGOITEM", "QTITEM", "VlUNITITEM"};

    private String tableName = "ITEMPEDIDOVENDA";

    private Context context;

    private ItemPedidoVendaDAO(Context context) {
        this.context = context;
        openHelper = new SQLiteDataHelper(this.context, "UNIPAR", null, 1);
        bd = openHelper.getWritableDatabase();
    }
    private static ItemPedidoVendaDAO instancia;

    public static ItemPedidoVendaDAO getInstancia(Context context){
        if(instancia == null){
            return instancia = new ItemPedidoVendaDAO(context);
        } else {
            return instancia;
        }
    }

    @Override
    public long insert(ItemPedidoVenda object) {
        try{
            ContentValues valores = new ContentValues();
            valores.put("CODIGO", object.getCodigo());
            valores.put("CODIGOPEDIDO", object.getCodigoPedido());
            valores.put("CODIGOITEM", object.getCodigoItem());
            valores.put("QTITEM", object.getQtItem());
            valores.put("VlUNITITEM", object.getVlUnitItem());

            return bd.insert(tableName, null, valores);
        }catch (SQLException ex){
            Log.e("Erro", "ItemPedidoVendaDAO.insert: "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public long update(ItemPedidoVenda object) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("CODIGOPEDIDO", object.getCodigoPedido());;
            valores.put("CODIGOITEM", object.getCodigoItem());
            valores.put("QTITEM", object.getQtItem());
            valores.put("VLUNITITEM", object.getVlUnitItem());

            String[]identificador = {String.valueOf(object.getCodigo())};

            return bd.update(tableName, valores, "CODIGO = ?", identificador);

        }catch (SQLException ex){
            Log.e("Erro", "ItemPedidoVendaDAO.update: "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public long delete(ItemPedidoVenda object) {
        try{
            String[]identificador = {String.valueOf(object.getCodigo())};

            return bd.delete(tableName, "CODIGO = ?", identificador);
        }catch (SQLException ex){
            Log.e("Erro", "ItemPedidoVendaDAO.delete: "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public ArrayList<ItemPedidoVenda> getAll() {
        ArrayList<ItemPedidoVenda> lista = new ArrayList<>();

        try {
            Cursor cursor = bd.query(tableName, colunas, null, null, null, null, "CODIGO asc");

            if (cursor.moveToFirst()){
                do{
                    ItemPedidoVenda itemPedidoVenda = new ItemPedidoVenda();
                    itemPedidoVenda.setCodigo(cursor.getInt(0));
                    itemPedidoVenda.setCodigoPedido(cursor.getInt(1));
                    itemPedidoVenda.setCodigoItem(cursor.getInt(2));
                    itemPedidoVenda.setQtItem(cursor.getInt(3));
                    itemPedidoVenda.setVlUnitItem(cursor.getDouble(4));
                    lista.add(itemPedidoVenda);
                }while (cursor.moveToNext());
            }
        }catch (SQLException ex) {
            Log.e("Erro", "ItemPedidoVendaDAO.getAll: "+ex.getMessage());
        }
        return lista;
    }

    @Override
    public ItemPedidoVenda getById(int id) {
        try {
            String[]identificador = {String.valueOf(id)};
            Cursor cursor = bd.query(tableName, colunas, "CODIGO = ?", identificador, null, null, "CODIGO asc");

            if (cursor.moveToFirst()){
                ItemPedidoVenda itemPedidoVenda = new ItemPedidoVenda();
                itemPedidoVenda.setCodigo(cursor.getInt(0));
                itemPedidoVenda.setCodigoPedido(cursor.getInt(1));
                itemPedidoVenda.setCodigoItem(cursor.getInt(2));
                itemPedidoVenda.setQtItem(cursor.getInt(3));
                itemPedidoVenda.setVlUnitItem(cursor.getDouble(4));

                return itemPedidoVenda;
            }
        }catch (SQLException ex) {
            Log.e("Erro", "ItemPedidoVendaDAO.getById: "+ex.getMessage());
        }
        return null;
    }
}
