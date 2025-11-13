package ec.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GradeApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("GradeBeans.xml");
        GradeImpl gradeBean = (GradeImpl) context.getBean("grade-bean");

        // Output for grades from 66 to 100
        for (int score = 66; score <= 100; score++) {
            System.out.print(score + ":" + gradeBean.getLetterGrade(score) + " ");
            if ((score - 65) % 5 == 0) System.out.println();
        }

        // Set new grade boundaries and letters
        int[] newGradeBoundary = {0, 50, 53, 57, 60, 63, 67, 70, 73, 77, 80, 85, 90, 100};
        String[] newLetterGrade = {"F", "D-", "D", "D+", "C-", "C", "C+", "B-", "B", "B+", "A-", "A", "A+"};

        gradeBean.setGradeBoundary(newGradeBoundary);
        gradeBean.setLetterGrade(newLetterGrade);

        System.out.println("\n\nNew Grade Boundaries:");

        // Output for grades from 46 to 100
        for (int score = 46; score <= 100; score++) {
            System.out.print(score + ":" + gradeBean.getLetterGrade(score) + " ");
            if ((score - 45) % 5 == 0) System.out.println();
        }
    }
}
