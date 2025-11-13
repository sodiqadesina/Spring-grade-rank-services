package ec.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class GradeImpl implements Grade {
    private int[] gradeBoundary = {0, 70, 73, 77, 80, 85, 90, 100};
    private String[] letterGrade = {"F", "B-", "B", "B+", "A-", "A", "A+", "A+"};
    private int count = gradeBoundary.length;

    @Override
    public String getLetterGrade(int numericalGrade) {
        int left = 0;
        int right = count - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (numericalGrade < gradeBoundary[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left < letterGrade.length ? letterGrade[left] : "F";
    }
}
