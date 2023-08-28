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
import br.com.unipar.forcavendasapp.model.Cliente;
import br.com.unipar.forcavendasapp.model.Endereco;

public class ClienteDAO implements GenericDAO<Cliente>{

    private SQLiteOpenHelper openHelper;

    private SQLiteDatabase bd;

    private String[] colunas = {"CODIGO", "NOME", "CPF", "DTNASC", "CODENDERECO"};

    private String tableName = "CLIENTE";

    private Context context;

    private static ClienteDAO instancia;

    public static ClienteDAO getInstancia(Context context){
        if(instancia == null){
            return instancia = new ClienteDAO(context);
        } else {
            return instancia;
        }
    }

    private ClienteDAO(Context context) {
        this.context = context;
        openHelper = new SQLiteDataHelper(this.context, "UNIPAR", null, 1);
        bd = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(Cliente object) {
        try{
            ContentValues valores = new ContentValues();
            valores.put("CODIGO", object.getCodigo());
            valores.put("CPF", object.getCpf());
            valores.put("CODENDERECO", object.getCodEndereco());
            valores.put("DTNASC", object.getDtNasc());
            valores.put("NOME", object.getNome());

            return bd.insert(tableName, null, valores);
        }catch (SQLException ex){
            Log.e("Erro", "ClienteDAO.insert: "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public long update(Cliente object) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("CPF", object.getCpf());
            valores.put("CODENDERECO", object.getCodEndereco());
            valores.put("DTNASC", object.getDtNasc());
            valores.put("NOME", object.getNome());

            String[]identificador = {String.valueOf(object.getCodigo())};

            return bd.update(tableName, valores, "CODIGO = ?", identificador);

        }catch (SQLException ex){
            Log.e("Erro", "ClienteDAO.update: "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public long delete(Cliente object) {
        try{
            String[]identificador = {String.valueOf(object.getCodigo())};

            return bd.delete(tableName, "CODIGO = ?", identificador);
        }catch (SQLException ex){
            Log.e("Erro", "ClienteDAO.delete: "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public ArrayList<Cliente> getAll() {
        ArrayList<Cliente> lista = new ArrayList<>();

        try {
            Cursor cursor = bd.query(tableName, colunas, null, null, null, null, "CODIGO asc");

            if (cursor.moveToFirst()){
                do{
                    Cliente cliente = new Cliente();
                    cliente.setCodigo(cursor.getInt(0));
                    cliente.setNome(cursor.getString(1));
                    cliente.setCpf(cursor.getString(2));
                    cliente.setDtNasc(cursor.getString(3));
                    cliente.setCodEndereco(cursor.getInt(4));
                    lista.add(cliente);
                }while (cursor.moveToNext());
            }
        }catch (SQLException ex) {
            Log.e("Erro", "ClienteDAO.getAll: "+ex.getMessage());
        }
        return lista;
    }

    @Override
    public Cliente getById(int id) {
        try {
            String[]identificador = {String.valueOf(id)};
            Cursor cursor = bd.query(tableName, colunas, "CODIGO = ?", identificador, null, null, "CODIGO asc");

            if (cursor.moveToFirst()){
                Cliente cliente = new Cliente();
                cliente.setCodigo(cursor.getInt(0));
                cliente.setNome(cursor.getString(1));
                cliente.setCpf(cursor.getString(2));
                cliente.setDtNasc(cursor.getString(3));
                cliente.setCodEndereco(cursor.getInt(4));

                return cliente;
            }
        }catch (SQLException ex) {
            Log.e("Erro", "ClienteDAO.getById: "+ex.getMessage());
        }
        return null;
    }

}
