package ec.spring;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RankApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("RankBeans.xml");
        Rank rankBean = (Rank) context.getBean("rank-bean");

        // Sample scores to display ranks and grades
        Integer[] testScores = {71, 71, 85, 70, 85, 99, 70, 79, 89, 83, 96, 85, 82, 84, 96, 77, 89, 81, 71, 90, 89, 71, 99, 99, 84, 74, 90, 75, 73, 86};
        
        // Sort the testScores in descending order
        List<Integer> scoreList = Arrays.asList(testScores);
        Collections.sort(scoreList, Collections.reverseOrder());

        // Print rank and grade for each score in descending order
        for (int score : scoreList) {
            System.out.println("score:" + score + ", rank:" + rankBean.getRank(score) + ", grade:" + rankBean.getGrade(score));
        }
        // Prediction for a score not in the list
        int predictionScore = 76;
        System.out.println("\nPrediction for score:" + predictionScore);
        System.out.println("rank:" + rankBean.getRank(predictionScore) + ", grade:" + rankBean.getGrade(predictionScore));

        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
