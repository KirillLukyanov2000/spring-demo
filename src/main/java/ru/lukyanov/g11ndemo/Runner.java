package ru.lukyanov.g11ndemo;

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {

 public static void main(String[] args) {
   Locale ru = new Locale("ru");
   ResourceBundle strSource = ResourceBundle.getBundle("lang", ru);
   String greeting = strSource.getString("greeting");
   System.out.println(greeting);                                                
 }
}
