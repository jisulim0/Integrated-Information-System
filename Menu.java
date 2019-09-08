package io.wisoft.first.project;

import java.util.Scanner;

public class Menu implements ViewInterface{

  private int number;
  private boolean exit = true;
  private Score score = new Score();
  private Tuition tuition = new Tuition();
  private LectureEvaluation lectureEvaluation = new LectureEvaluation();

  @Override
  public void viewAble() {
    Scanner scanner = new Scanner(System.in);
    while (exit) {

      System.out.println("\n==================");
      System.out.println("메뉴");
      System.out.println("1. 성적관리");
      System.out.println("2. 등록금");
      System.out.println("3. 수강관리");
      System.out.println("4. 종료");
      System.out.println("==================\n");
      System.out.print("선택해주세요 >> ");
      number = scanner.nextInt();
      System.out.println();

      switch (number) {
        case 1:
          score.viewAble();
          break;
        case 2:
          tuition.viewAble();
          break;
        case 3:
          lectureEvaluation.subjectChoice();
          break;
        case 4:
          exit = false;
        default:
          continue;
      }
    }
  }

}
