import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String Name;
    private int RollNumber;
    private double FeesPaid;

    public Student(String Name, int RollNumber, double FeesPaid) {
        this.Name = Name;
        this.RollNumber = RollNumber;
        this.FeesPaid = FeesPaid;
    }

    public String getName() {
        return Name;
    }

    public int getRollNumber() {
        return RollNumber;
    }

    public double getFeesPaid() {
        return FeesPaid;
    }

    public void setFeesPaid(double feesPaid) {
        this.FeesPaid = FeesPaid;
    }
}

class FeesManagementSystem {
    private List<Student> students;

    public FeesManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudentDetails() {
        System.out.println("Student Details:");
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Fees Paid: " + student.getFeesPaid());
            System.out.println("--------------------------");
        }
    }

    public void updateFees(int RollNumber, double FeesPaid) {
        for (Student student : students) {
            if (student.getRollNumber() == RollNumber) {
                double newFeesPaid = student.getFeesPaid() + FeesPaid;
                student.setFeesPaid(newFeesPaid);
                System.out.println("Fees updated successfully.");
                return;
            }
        }
        System.out.println("Student with Roll number " + RollNumber + " not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FeesManagementSystem feesManagementSystem = new FeesManagementSystem();

        boolean running = true;
        while (running) {
            System.out.println("1. Add Student");
            System.out.println("2. Display Student Details");
            System.out.println("3. Update Fees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter Fees Paid: ");
                    double feesPaid = scanner.nextDouble();
                    Student student = new Student(name, rollNumber, feesPaid);
                    feesManagementSystem.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    feesManagementSystem.displayStudentDetails();
                    break;
                case 3:
                    System.out.print("Enter Roll Number: ");
                    rollNumber = scanner.nextInt();
                    System.out.print("Enter Fees Paid: ");
                    feesPaid = scanner.nextDouble();
                    feesManagementSystem.updateFees(rollNumber, feesPaid);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again...");
            }
        }

        scanner.close();
    }
}