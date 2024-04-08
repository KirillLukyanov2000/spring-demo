
package ru.lukyanov.g11ndemo;

import java.util.Locale;

public class Runner {

    public static void main(String[] args) {
        ResourceManager translator = ResourceManager.INSTANCE;
        Locale locale = new Locale("ru", "RU");
        translator.setLocale(locale);
        System.out.println(translator.getResKey(Message.GREETING) + " " + translator.getResKey(Message.QUESTION));
        System.out.println(translator.getResKey(User.FIRST_NAME) + " " + translator.getResKey(User.LAST_NAME));
    }

}
