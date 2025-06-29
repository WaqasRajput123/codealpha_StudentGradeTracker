import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    static class Student {
        String name;
        double grade;

        Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Tracker ===");
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Input loop
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter " + name + "'s grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            students.add(new Student(name, grade));
        }

        // Processing
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String topStudent = "";
        String bottomStudent = "";

        for (Student s : students) {
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s.name;
            }
            if (s.grade < lowest) {
                lowest = s.grade;
                bottomStudent = s.name;
            }
        }

        double average = total / students.size();

        // Output
        System.out.println("\n=== Grade Summary Report ===");
        for (Student s : students) {
            System.out.println(s.name + " - " + s.grade);
        }

        System.out.println("\nAverage Grade: " + average);
        System.out.println("Highest Grade: " + highest + " (" + topStudent + ")");
        System.out.println("Lowest Grade: " + lowest + " (" + bottomStudent + ")");

        scanner.close();
    }
}
