package org.example;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        // Проверка длины строки
        if (name.length() < 3 || name.length() > 19) {
            return false;
        }

        // Проверка на наличие пробела и его позицию
        int spaceIndex = name.indexOf(" ");
        if (spaceIndex <= 0 || spaceIndex >= name.length() - 1) {
            return false;
        }

        // Проверка, что в строке только один пробел
        if (name.lastIndexOf(" ") != spaceIndex) {
            return false;
        }

        // Проверка на наличие символов до и после пробела
        if (spaceIndex > 0 && (name.length() - spaceIndex - 1) > 0) {
            // Дополнительная проверка на наличие только букв и пробелов
            for (char c : name.toCharArray()) {
                if (!Character.isLetter(c) && c != ' ') {
                    return false; // недопустимый символ
                }
            }
            return true; // все проверки пройдены
        }

        return false;
    }
}


