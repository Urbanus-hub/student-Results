import java.util.Scanner;

class StudentMarks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of students");
        int nums = input.nextInt();
        String studentDetails[][] = new String[nums][9]; // Assuming each student has roll number, name, and marks for three subjects, result, grade, total marks, and average.

        System.out.println("Enter the details for each student:");

        for (int i = 0; i < nums; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Enter the student roll number:");
            studentDetails[i][0] = input.next();

            System.out.println("Enter the student's name:");
            studentDetails[i][1] = input.next();

            int totalMarks = 0;
            boolean resultP = true;

            // Collect marks for three subjects
            for (int j = 0; j < 3; j++) {
                System.out.println("Enter marks for subject " + (j + 1) + ":");
                studentDetails[i][j + 2] = input.next();
                int marks = Integer.parseInt(studentDetails[i][j + 2]);
                totalMarks += marks;

                // Check if any mark is below 50
                if (marks < 50) {
                    resultP = false;
                }
            }

            // Calculate the grade
            studentDetails[i][8] = calculateGrade(totalMarks);

            // Determine the result (P for all marks above 50, F otherwise)
            studentDetails[i][7] = (resultP) ? "P" : "F";

            // Store the total marks and average
            studentDetails[i][6] = String.valueOf(totalMarks);
            double average = (double) totalMarks / 3;
            studentDetails[i][5] = String.format("%.2f", average);
        }

        // Display the details in the specified format
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\tSTUDENT MARKLIST");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                "Roll", "Name", "Mark1", "Mark2", "Mark3", "Total", "Result", "Average", "Grade");
        

        for (int i = 0; i < nums; i++) {
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                    studentDetails[i][0], studentDetails[i][1], studentDetails[i][2],
                    studentDetails[i][3], studentDetails[i][4], studentDetails[i][6],
                    studentDetails[i][7], studentDetails[i][5], studentDetails[i][8]);
        }

    }

    // Function to calculate the grade based on total marks
    public static String calculateGrade(int totalMarks) {
        if (totalMarks >= 70 && totalMarks <= 100) {
            return "A";
        } else if (totalMarks >= 50 && totalMarks < 70) {
            return "B";
        } else {
            return "C";
        }
    }
}
