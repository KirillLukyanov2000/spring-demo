package ru.lukyanov.g11ndemo;

import java.util.ResourceBundle;

public enum ResourceManager {

  INSTANCE;

  public static final String BASENAME = "lang";
  private ResourceBundle resourceBundle;

  ResourceManager() {
    setLocale(Locale.getDefault());
  }

  public void setLocale(Locale locale) {
    this.resourceBundle = ResourceBundle.getBundle(BASENAME, locale);
  }

  public String getResKey(String key) {
    return resourceBundle.getString(key);
  }
   
}
