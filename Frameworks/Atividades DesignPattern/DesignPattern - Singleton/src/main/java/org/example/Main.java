package org.example;

public class Main {
    public static void main(String[] args) {
        UserManager user = UserManager.getInstance();
        Usuario users =  new Usuario("login", "32432948230", "Lucas");
        user.set(users, users.getNome());

        UserManager otherUser = UserManager.getInstance();

        System.out.println(otherUser.get(users));
        user.set(users, users.getLogin());
        otherUser = UserManager.getInstance();

        System.out.println(otherUser.get(users));


    }
}