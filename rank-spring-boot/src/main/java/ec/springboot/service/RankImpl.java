package ec.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class RankImpl implements Rank {
    private Integer[] scores = {71, 71, 85, 70, 85, 99, 70, 79, 89, 83, 96, 85, 82, 84, 96, 77, 89, 81, 71, 90, 89, 71, 99, 99, 84, 74, 90, 75, 73, 86};
    private Grade grade;

    @Autowired
    public RankImpl(Grade grade) {
        Arrays.sort(scores, Collections.reverseOrder());
        this.grade = grade;
    }

    @Override
    public String getGrade(int score) {
        return grade.getLetterGrade(score);
    }

    @Override
    public int getRank(int score) {
        int left = 0;
        int right = scores.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] == score) {
                while (mid > 0 && scores[mid - 1] == score) {
                    mid--;
                }
                return mid + 1;
            } else if (scores[mid] < score) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left + 1;
    }
}
