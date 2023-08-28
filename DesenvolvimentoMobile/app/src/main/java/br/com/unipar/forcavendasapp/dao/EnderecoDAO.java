package br.com.unipar.forcavendasapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import br.com.unipar.forcavendasapp.helper.SQLiteDataHelper;
import br.com.unipar.forcavendasapp.model.Endereco;
import br.com.unipar.forcavendasapp.model.Item;

public class EnderecoDAO implements GenericDAO<Endereco>{

    private SQLiteOpenHelper openHelper;

    private SQLiteDatabase bd;

    private String[] colunas = {"CODIGO", "LOGRADOURO", "NUMERO", "BAIRRO", "CIDADE", "UF"};

    private String tableName = "ENDERECO";

    private Context context;

    private static EnderecoDAO instancia;

    public static EnderecoDAO getInstancia(Context context){
        if(instancia == null){
            return instancia = new EnderecoDAO(context);
        } else {
            return instancia;
        }
    }

    private EnderecoDAO(Context context) {
        this.context = context;
        openHelper = new SQLiteDataHelper(this.context, "UNIPAR", null, 1);
        bd = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(Endereco object) {
        try{
            ContentValues valores = new ContentValues();
            valores.put("CODIGO", object.getCodigo());
            valores.put("LOGRADOURO", object.getLogradouro());
            valores.put("NUMERO", object.getNumero());
            valores.put("BAIRRO", object.getBairro());
            valores.put("CIDADE", object.getCidade());
            valores.put("UF", object.getUf());

            return bd.insert(tableName, null, valores);
        }catch (SQLException ex){
            Log.e("Erro", "EnderecoDAO.insert: "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public long update(Endereco object) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("LOGRADOURO", object.getLogradouro());
            valores.put("NUMERO", object.getNumero());
            valores.put("BAIRRO", object.getBairro());
            valores.put("CIDADE", object.getCidade());
            valores.put("UF", object.getUf());

            String[]identificador = {String.valueOf(object.getCodigo())};

            return bd.update(tableName, valores, "CODIGO = ?", identificador);

        }catch (SQLException ex){
            Log.e("Erro", "EnderecoDAO.update: "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public long delete(Endereco object) {
        try{
            String[]identificador = {String.valueOf(object.getCodigo())};

            return bd.delete(tableName, "CODIGO = ?", identificador);
        }catch (SQLException ex){
            Log.e("Erro", "EnderecoDAO.delete: "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public ArrayList<Endereco> getAll() {
        ArrayList<Endereco> lista = new ArrayList<>();

        try {
            Cursor cursor = bd.query(tableName, colunas, null, null, null, null, "CODIGO asc");

            if (cursor.moveToFirst()){
                do{
                    Endereco endereco = new Endereco();
                    endereco.setCodigo(cursor.getInt(0));
                    endereco.setLogradouro(cursor.getString(1));
                    endereco.setNumero(cursor.getString(2));
                    endereco.setBairro(cursor.getString(3));
                    endereco.setCidade(cursor.getString(4));
                    endereco.setUf(cursor.getString(5));
                    lista.add(endereco);
                }while (cursor.moveToNext());
            }
        }catch (SQLException ex) {
            Log.e("Erro", "EnderecoDAO.getAll: "+ex.getMessage());
        }
        return lista;
    }

    @Override
    public Endereco getById(int id) {
        try {
            String[]identificador = {String.valueOf(id)};
            Cursor cursor = bd.query(tableName, colunas, "CODIGO = ?", identificador, null, null, "CODIGO asc");

            if (cursor.moveToFirst()){
                Endereco endereco = new Endereco();
                endereco.setCodigo(cursor.getInt(0));
                endereco.setLogradouro(cursor.getString(1));
                endereco.setNumero(cursor.getString(2));
                endereco.setBairro(cursor.getString(3));
                endereco.setCidade(cursor.getString(4));
                endereco.setUf(cursor.getString(5));

                return endereco;
            }
        }catch (SQLException ex) {
            Log.e("Erro", "EnderecoDAO.getById: "+ex.getMessage());
        }
        return null;
    }
}
