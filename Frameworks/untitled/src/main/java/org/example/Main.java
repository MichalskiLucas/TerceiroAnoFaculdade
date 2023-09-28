package org.example;

public class Main {
    public static void main(String[] args) {

        Group group = new Group();

        group.add(new Shape());
        group.add(new Shape());


        Group group2 = new Group();

        group2.add(new Shape());
        group2.add(new Shape());

        Group group3 = new Group();
        group3.add(group);
        group3.add(group2);

        group3.render();

        group3.move();
    }
}
