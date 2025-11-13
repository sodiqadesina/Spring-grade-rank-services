package ec.spring;

import java.util.Arrays;
import java.util.Collections;

public class RankImpl implements Rank {
    private String name;
    private Integer[] scores = {71, 71, 85, 70, 85, 99, 70, 79, 89, 83, 96, 85, 82, 84, 96, 77, 89, 81, 71, 90, 89, 71, 99, 99, 84, 74, 90, 75, 73, 86};
    private int count;
    private Grade grade;

    public RankImpl() {
        // Sort the scores in descending order
        Arrays.sort(scores, Collections.reverseOrder());
        count = scores.length;
    }

    public String getGrade(int score) {
        return grade.getLetterGrade(score);
    }


    public int getRank(int score) {
        int left = 0;
        int right = count - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] == score) {
                // If multiple instances of the score exist, find the first occurrence
                while (mid > 0 && scores[mid - 1] == score) {
                    mid--;
                }
                return mid + 1; // Ranks are 1-based
            } else if (scores[mid] < score) {
                // Since array is sorted in descending order
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // If score not found, left is the insertion point
        return left + 1;
    }

    // Setter for the Grade property
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    // Getters and setters for other properties, if needed
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   
}
