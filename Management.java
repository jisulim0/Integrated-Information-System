package io.wisoft.first.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Scanner;

public class Management {

  public static int indexNum;

  static private String id;
  static private String password;
  static private String[] UserId;
  static private String[] UserPass;
  static private String[] userNames;
  static private String[] javas;
  static private String[] algos;
  static private String[] oss;
  static private String[] datas;

  public static void setId(String ids) {
    id = ids;
  }
  public static void setPassword(String passwords) {
    password = passwords;
  }
  public static void setUserId(String[] userId) {
    UserId = userId;
  }
  public static void setUserPass(String[] userPass) {
    UserPass = userPass;
  }
  public static void setUserNames(String[] userName) {
    userNames = userName;
  }
  public static void setJavas(String[] java) {
    javas = java;
  }
  public static void setAlgos(String[] algo) {
    algos = algo;
  }
  public static void setOss(String[] os) {
    oss = os;
  }
  public static void setDatas(String[] data) {
    datas = data;
  }

  public static String getId() {
    return id;
  }
  public static String getPassword() {
    return password;
  }
  public static String[] getUserId() {
    return UserId;
  }
  public static String[] getUserPass() {
    return UserPass;
  }
  public static String[] getUserNames() {
    return userNames;
  }
  public static String[] getJavas() {
    return javas;
  }
  public static String[] getAlgos() {
    return algos;
  }
  public static String[] getOss() {
    return oss;
  }
  public static String[] getDatas() {
    return datas;
  }

  public void requestLogin(){

    try {

      Properties props = new Properties();
      FileInputStream fis = new FileInputStream("C:/Users/jisulim/Desktop/wisoft/JAVA/src/io/wisoft/first/project/client.properties");
      props.load(new java.io.BufferedInputStream(fis));

      setUserId(props.getProperty("id").split(","));
      setUserPass(props.getProperty("password").split(","));
      setUserNames(new String(props.getProperty("name").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8).split(","));
      setJavas(props.getProperty("java").split(","));
      setAlgos(props.getProperty("algo").split(","));
      setOss(props.getProperty("os").split(","));
      setDatas(props.getProperty("data").split(","));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void login() {

    Scanner scanner = new Scanner(System.in);
    boolean check = true;
    boolean ifcheck = false;

    while (check) {

      System.out.print("ID : ");
      setId(scanner.next());
      System.out.print("PASSWORD : ");
      setPassword(scanner.next());

      requestLogin();

      for (int i = 0; i < UserId.length; i++) {
        if (getId().equals(getUserId()[i]) && getPassword().equals(getUserPass()[i])) {
          System.out.println("[로그인 되었습니다.]");
          check = ifcheck = false;
          indexNum = i;
          break;
        } else {
          ifcheck = true;
        }
      }


      if (ifcheck) {
        System.out.println("[일치하지 않습니다.]");
      }

    }
  }

}
