package ec.spring;

public class GradeImpl implements Grade {
    private String name;
    private int[] gradeBoundary = {0, 70, 73, 77, 80, 85, 90, 100};
    private String[] letterGrade = {"F", "B-", "B", "B+", "A-", "A", "A+", "A+"};
    private int count = gradeBoundary.length;


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
        // Return the letter grade if within bounds
        return left < letterGrade.length ? letterGrade[left] : "F";
    }



    // Setter for gradeBoundary array
    public void setGradeBoundary(int[] gradeBoundary) {
        this.gradeBoundary = gradeBoundary;
        this.count = gradeBoundary.length; // Update count based on new array length
    }

    // Setter for letterGrade array
    public void setLetterGrade(String[] letterGrade) {
        this.letterGrade = letterGrade;
    }

    // Getters and Setters for name and other properties
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
