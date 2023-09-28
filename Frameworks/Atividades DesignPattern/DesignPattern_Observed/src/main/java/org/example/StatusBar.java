package org.example;

public class StatusBar implements Observer{
    DataSource dataSource = new DataSource();

    public StatusBar(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("StatusBar got notified: ");
    }
}
