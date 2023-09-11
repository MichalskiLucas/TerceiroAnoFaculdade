package org.example;

public class hcFilter implements Filter{
    @Override
    public void filter(String fileName) {
        System.out.println("Applying filter high contrast");
    }
}
