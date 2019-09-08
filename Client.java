package io.wisoft.first.project;

public class Client {

  public static void main(String[] args) {

    Management user = new Management();
    user.login();

    Menu menu = new Menu();
    menu.viewAble();

  }
}
