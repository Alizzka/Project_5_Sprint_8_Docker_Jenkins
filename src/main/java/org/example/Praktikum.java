package org.example;

public class Praktikum {

    public static void main(String[] args) {
        runProgram();
    }

    public static void runProgram() {
        String fullName = "Тимоти Шаламе";
        Account account = new Account(fullName);
        boolean canEmboss = account.checkNameToEmboss();
        System.out.println("Можно ли использовать имя \"" + fullName + "\" для печати на карте? " + (canEmboss ? "Да" : "Нет"));
    }
}


