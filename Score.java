package io.wisoft.first.project;

public class Score implements ViewInterface{

  @Override
  public void viewAble() {

    System.out.println("["+ Management.getUserNames()[Management.indexNum]+"]\n");
    System.out.println(Management.getJavas()[Management.indexNum] + "\t" + calculateScore(Management.getJavas()[Management.indexNum])+"\n");
    System.out.println(Management.getAlgos()[Management.indexNum] + "\t" + calculateScore(Management.getAlgos()[Management.indexNum])+"\n");
    System.out.println(Management.getOss()[Management.indexNum] + "\t" + calculateScore(Management.getOss()[Management.indexNum])+"\n");
    System.out.println(Management.getDatas()[Management.indexNum] + "\t" + calculateScore(Management.getDatas()[Management.indexNum])+"\n");

  }

  public String calculateScore(final String subject){

    String grade;
    int sub = Integer.parseInt(subject);

    grade = sub >=95 ? "A+" : (90 <= sub ? "A" : ( 85 <= sub ? "B+" : (80 <= sub ? "B" : (75 <= sub ? "C+" : (70 <= sub ? "C" : "F")))));


    return grade;
  }

}
