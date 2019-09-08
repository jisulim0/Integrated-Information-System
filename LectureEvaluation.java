package io.wisoft.first.project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class LectureEvaluation implements ViewInterface {

  private int sum;
  private int check;
  private Scanner scanner = new Scanner(System.in);
  private boolean[] checkers = new boolean[4];
  private String path = "C:/Users/jisulim/Desktop/wisoft/JAVA/src/io/wisoft/project/lectureEvaluation.properties";


  public void subjectChoice(){

    boolean jump = true;

    while (jump){

      saveId();
      System.out.println("==================");
      System.out.println("1. Java");
      System.out.println("2. Algorithm");
      System.out.println("3. OS");
      System.out.println("4. Data");
      System.out.println("5. 종료");
      System.out.println("==================");
      System.out.println("과목을 선택해 주세요 >>");

      switch (Input()){
        case 1:
          overlapCheck();
          break;
        case 2:
          overlapCheck();
          break;
        case 3:
          overlapCheck();
          break;
        case 4:
          overlapCheck();
          break;
        case 5:
          jump = false;
          break;
        default:
          continue;
      }
    }

  }

  public int Input(){
    check = scanner.nextInt();
    return check;
  }

  public void InputLectureEvalautionScore(){
    int number = scanner.nextInt();
    if(number<=5) {
      sum += number;
    }
    else{
      System.out.println("1~5사이의 점수를 입력해주세요.");
      InputLectureEvalautionScore();
    }
  }

  @Override
  public void viewAble(){
    final String[] lectureEvaluationString = {
        "1. 교수는 수업준비를 철저하게 하였다.",
        "2. 평가기준 및 방식이 객관적이고 합리적으로 제시되었다.",
        "3. 교수는 열정적으로 강의하였다.",
        "4. 교수는 교과내용을 학생들이 이해할 수 있도록 명확하게 설명하였다.",
        "5. 과제는 학습효과를 높이는데 도움이 되었다."
    };

    sum = 0;

    for(String string : lectureEvaluationString){
      System.out.println(string);
      InputLectureEvalautionScore();
      save();
    }

  }

  public void overlapCheck(){

    if(checkers[check-1] == false){
      viewAble();
      checkers[check-1] = true;
    }
    else {
      System.out.println("종료된 설문입니다.");
    }
  }

  public void save() {

    try {

      Properties props = new Properties();
      FileInputStream fis = new FileInputStream(path);
      props.load(new java.io.BufferedInputStream(fis));

      switch (check){
        case 1:
          props.put(Management.getId()+" java 점수",Integer.toString(sum));
          props.store( new FileOutputStream(path),"강의평가");
          break;
        case 2:
          props.put(Management.getId()+" algo 점수",Integer.toString(sum));
          props.store( new FileOutputStream(path),"강의평가");
          break;
        case 3:
          props.put(Management.getId()+" os 점수",Integer.toString(sum));
          props.store( new FileOutputStream(path),"강의평가");
          break;
        case 4:
          props.put(Management.getId()+" data 점수",Integer.toString(sum));
          props.store( new FileOutputStream(path),"강의평가");
          break;
      }

    }
    catch (IOException e){
      e.printStackTrace();
    }

  }

  public void saveId(){
    try {
      Properties props = new Properties();
      FileInputStream fis = new FileInputStream(path);
      props.load(new java.io.BufferedInputStream(fis));
      props.store(new FileOutputStream(path),"");
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }

}
