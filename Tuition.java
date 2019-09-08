package io.wisoft.first.project;

import java.util.ArrayList;

public class Tuition implements ViewInterface{

  static private int tuition = 236400;
  ArrayList<Double> changeScores = new ArrayList();

  public double totalScore() {

    double avgScore;
    double sumScore = 0;

    for (int i = 0; i < changeScores.size(); i++) {
      sumScore += (changeScores.get(i) * 3);
    }
    avgScore = sumScore / 12;

    return avgScore;

  }

  public double changeScore(final String subject) {

    double grade;
    int sub = Integer.parseInt(subject);

    grade = sub >= 95 ? 4.5 : (90 <= sub ? 4.0 : (85 <= sub ? 3.5 : (80 <= sub ? 3.0 : (75 <= sub ? 2.5 : (70 <= sub ? 2.0 : 0.0)))));

    return grade;

  }

  @Override

  public void viewAble() {

    changeScores.add(changeScore(Management.getJavas()[Management.indexNum]));
    changeScores.add(changeScore(Management.getAlgos()[Management.indexNum]));
    changeScores.add(changeScore(Management.getOss()[Management.indexNum]));
    changeScores.add(changeScore(Management.getDatas()[Management.indexNum]));

    System.out.println("\n==================");
    System.out.println("등록금 : " + tuition);
    System.out.println("장학금 : " + calculateTuition(totalScore()));
    System.out.println("총 액  : " + (tuition - calculateTuition(totalScore())));
    System.out.println("\n==================");

  }

  public int calculateTuition(final double avgScore) {

    int scholarship = (int) (avgScore >= 4.0 ? tuition : (avgScore >= 3.5 ? (tuition * 0.5) : 0));

    return scholarship;

  }

}
