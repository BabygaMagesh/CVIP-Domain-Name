import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your gender [Male(or)Female]: ");
        String gender = scanner.next();

        System.out.print("Enter your weight in kilograms: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your height in meters: ");
        double height = scanner.nextDouble();

        double bmi = calculateBMI(weight, height);
        System.out.println("Your BMI is: " + bmi);

        String bmiCategory = getBMICategory(bmi, age, gender);
        System.out.println("BMI Category: " + bmiCategory);
    }

    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public static String getBMICategory(double bmi, int age, String gender) {
        if (age < 18) {
            return "BMI category is not suitable for  under 18 years old.";
        } else {
            if (gender.equalsIgnoreCase("Male")) {
                if (bmi < 18.5) {
                    return "You are Underweight";
                } else if (bmi >= 18.5 && bmi < 25) {
                    return "You are Normal weight";
                } else if (bmi >= 25 && bmi < 30) {
                    return "You are Overweight";
                } else {
                    return "You are Obese";
                }
            } else if (gender.equalsIgnoreCase("Female")) {
                if (bmi < 18.5) {
                    return "You are Underweight";
                } else if (bmi >= 18.5 && bmi < 24) {
                    return "You are Normal weight";
                } else if (bmi >= 24 && bmi < 30) {
                    return "You are  Overweight";
                } else {
                    return "You are Obese";
                }
            } else {
                return "Gender not valid";
            }
        }
    }
}