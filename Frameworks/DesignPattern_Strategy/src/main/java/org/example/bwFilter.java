package org.example;

public class bwFilter implements Filter{
    @Override
    public void filter(String fileName) {
        System.out.println("Applying filter b&w");
    }
}
