package org.example;

public class StockListView implements Observer{

    private DataSource dataSource;

    public StockListView(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("StockListView got notified: New Value "+dataSource.getValue());
    }

}
