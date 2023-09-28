package br.com.unipar.forcavendas.dao;
import java.util.ArrayList;

public interface GenericDAO<Object> {

    long insert (Object object);
    long update (Object object);
    long delete (Object object);
    ArrayList<Object> getAll();
    Object getById(int id);

}