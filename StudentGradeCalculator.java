import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Calculator!");

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();
        double[] grades = new double[numberOfSubjects];
        double total = 0;

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter grade for subject " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
            total += grades[i];
        }

        double average = total / numberOfSubjects;

        char letterGrade;
        if (average >= 90) {
            letterGrade = 'A';
        } else if (average >= 80) {
            letterGrade = 'B';
        } else if (average >= 70) {
            letterGrade = 'C';
        } else if (average >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }

        System.out.println("Average grade: " + average);
        System.out.println("Letter grade: " + letterGrade);

        scanner.close();
    }
}
