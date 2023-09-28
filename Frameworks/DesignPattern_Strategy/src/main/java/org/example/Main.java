package org.example;

public class Main {
    public static void main(String[] args) {
        ImageStorage imageStorage = new ImageStorage(new JpegCompressor(), new hcFilter());
        imageStorage.store("Arquivo 01");
    }
}