import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      final int STUDENT_COUNT = 5;

      Student [] students = new Student[STUDENT_COUNT];
      double average = 0.0;

      for (int i = 0; i < STUDENT_COUNT; i++) {
        String name = enterNames(i + 1);
        double grade = enterGrades(name);
        students[i] = new Student(name, grade);
      }

      for (int i = 0; i < STUDENT_COUNT; i++) {
        average += students[i].getGrade();
      }

      average /= STUDENT_COUNT;

      System.out.println("The average grade is: " + average);

      for (int i = 0; i < STUDENT_COUNT; i++) {
        if (students[i].getGrade() <= average) {
          System.out.println(students[i].getName() + " has a grade below average, with: " + students[i].getGrade());
        }
      }
    }


  private static String enterNames(int index) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the name of student #" + (index) + ": ");
    return sc.nextLine();
  }

  private static double enterGrades(String name) {
    Scanner sc = new Scanner(System.in);
    double resultGrade = 0.0;

    System.out.print("Enter the grade for student " + (name) + " (1.0 - 10.0): ");
    try {
      double grade = Double.parseDouble(sc.nextLine());
      if (grade >= 1.0 && grade <= 10.0) {
        resultGrade = grade;
      } else {
        System.out.println("Error: grade must be between 1.0 and 10.0.");
      }
    } catch (NumberFormatException e) {
      System.out.println("Error: please enter a valid number.");
    }

    return resultGrade;
  }
}