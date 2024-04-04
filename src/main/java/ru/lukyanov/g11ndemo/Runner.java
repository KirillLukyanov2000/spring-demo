
package ru.lukyanov.g11ndemo;

import java.util.Locale;

public class Runner {

 public static void main(String[] args) {
   ResourceManager translator = ResourceManager.INSTANCE;
   Locale locale = new Locale("ru", "RU");
   translator.setLocale(locale);
   System.out.println(translator.get(Message.GREETING) + " " + translator.get(Message.QUESTION));
   System.out.println(translator.get(User.FIRST_NAME) + " " + translator.get(User.LAST_NAME));   
 }
 
}
