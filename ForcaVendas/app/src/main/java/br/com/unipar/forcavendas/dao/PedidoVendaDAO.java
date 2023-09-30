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
import br.com.unipar.forcavendas.model.PedidoVenda;

public class PedidoVendaDAO implements GenericDAO<PedidoVenda> {

    private SQLiteOpenHelper openHelper;

    private SQLiteDatabase bd;

    private String[] colunas = {"CODIGO", "CODIGOCLIENTE", "VALORTOTAL", "TPAGAMENTO", "NRPARCELAS", "CODENDERECOENTREGA"};

    private String tableName = "PEDIDOVENDA";

    private Context context;

    private PedidoVendaDAO(Context context) {
        this.context = context;
        openHelper = new SQLiteDataHelper(this.context, "UNIPAR", null, 1);
        bd = openHelper.getWritableDatabase();
    }

    private static PedidoVendaDAO instancia;

    public static PedidoVendaDAO getInstancia(Context context){
        if(instancia == null){
            return instancia = new PedidoVendaDAO(context);
        } else {
            return instancia;
        }
    }
    @Override
    public long insert(PedidoVenda object) {
        try{
            ContentValues valores = new ContentValues();
            valores.put("CODIGO", object.getCodigo());
            valores.put("VALORTOTAL", object.getValorTotal());
            valores.put("TPAGAMENTO", object.getTpPagamento());
            valores.put("NRPARCELAS", object.getNrParcelas());
            valores.put("CODENDERECOENTREGA", object.getCodEnderecoEntrega());
            valores.put("CODIGOCLIENTE", object.getCodCliente());

            return bd.insert(tableName, null, valores);
        }catch (SQLException ex){
            Log.e("Erro", "PedidoVendaDAO.insert: "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public long update(PedidoVenda object) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("VALORTOTAL", object.getValorTotal());;
            valores.put("TPAGAMENTO", object.getTpPagamento());
            valores.put("NRPARCELAS", object.getNrParcelas());
            valores.put("CODENDERECOENTREGA", object.getCodEnderecoEntrega());
            valores.put("CODIGOCLIENTE", object.getCodCliente());

            String[]identificador = {String.valueOf(object.getCodigo())};

            return bd.update(tableName, valores, "CODIGO = ?", identificador);

        }catch (SQLException ex){
            Log.e("Erro", "PedidoVendaDAO.update: "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public long delete(PedidoVenda object) {
        try{
            String[]identificador = {String.valueOf(object.getCodigo())};

            return bd.delete(tableName, "CODIGO = ?", identificador);
        }catch (SQLException ex){
            Log.e("Erro", "PedidoVendaDAO.delete: "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public ArrayList<PedidoVenda> getAll() {
        ArrayList<PedidoVenda> lista = new ArrayList<>();

        try {
            Cursor cursor = bd.query(tableName, colunas, null, null, null, null, "CODIGO asc");

            if (cursor.moveToFirst()){
                do{
                    PedidoVenda pedidoVenda = new PedidoVenda();
                    pedidoVenda.setCodigo(cursor.getInt(0));
                    pedidoVenda.setCodCliente(cursor.getInt(1));
                    pedidoVenda.setValorTotal(cursor.getDouble(2));
                    pedidoVenda.setTpPagamento(cursor.getString(3));
                    pedidoVenda.setNrParcelas(cursor.getInt(4));
                    pedidoVenda.setCodEnderecoEntrega(cursor.getInt(5));
                    lista.add(pedidoVenda);
                }while (cursor.moveToNext());
            }
        }catch (SQLException ex) {
            Log.e("Erro", "PedidoVendaDAO.getAll: "+ex.getMessage());
        }
        return lista;
    }

    @Override
    public PedidoVenda getById(int id) {
        try {
            String[]identificador = {String.valueOf(id)};
            Cursor cursor = bd.query(tableName, colunas, "CODIGO = ?", identificador, null, null, "CODIGO asc");

            if (cursor.moveToFirst()){
                PedidoVenda pedidoVenda = new PedidoVenda();
                pedidoVenda.setCodigo(cursor.getInt(0));
                pedidoVenda.setCodCliente(cursor.getInt(1));
                pedidoVenda.setValorTotal(cursor.getDouble(2));
                pedidoVenda.setTpPagamento(cursor.getString(3));
                pedidoVenda.setNrParcelas(cursor.getInt(4));
                pedidoVenda.setCodEnderecoEntrega(cursor.getInt(5));

                return pedidoVenda;
            }
        }catch (SQLException ex) {
            Log.e("Erro", "PedidoVendaDAO.getById: "+ex.getMessage());
        }
        return null;
    }
}
