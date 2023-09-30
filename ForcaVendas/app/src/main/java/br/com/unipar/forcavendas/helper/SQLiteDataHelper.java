package br.com.unipar.forcavendas.helper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SQLiteDataHelper extends SQLiteOpenHelper {
    public SQLiteDataHelper(@Nullable Context context,
                            @Nullable String name,
                            @Nullable SQLiteDatabase.CursorFactory factory,
                            int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE ENDERECO(CODIGO INTEGER, LOGRADOURO VARCHAR(100), NUMERO VARCHAR(5), BAIRRO VARCHAR(100), CIDADE VARCHAR(100), UF VARCHAR(2))");
        sqLiteDatabase.execSQL("CREATE TABLE CLIENTE(CODIGO INTEGER, NOME VARCHAR(100), CPF VARCHAR(11), DTNASC VARCHAR(10), CODENDERECO INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE ITEM(CODIGO INTEGER, DESCRICAO VARCHAR(100), VLUNIT DOUBLE, UNMEDIDA VARCHAR(3), DESCITEM VARCHAR(100))");
        sqLiteDatabase.execSQL("CREATE TABLE PEDIDOVENDA(CODIGO INTEGER, CODIGOCLIENTE INTEGER, VALORTOTAL DOUBLE, TPAGAMENTO VARCHAR(1), NRPARCELAS INTEGER, CODENDERECOENTREGA INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE ITEMPEDIDOVENDA(CODIGO INTEGER, CODIGOPEDIDO INTEGER, CODIGOITEM INTEGER, QTITEM INTEGER, VlUNITITEM DOUBLE)");
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
