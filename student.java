import java.util.Scanner;

public class student {
    // Global arrays to store student data
    static String[] studentNames = new String[50];
    static int[][] studentGrades = new int[50][5]; // 5 subjects per student
    static int studentCount = 0;
    static String[] subjects = {"Math", "Science", "English", "History", "Programming"};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║  STUDENT GRADE MANAGEMENT SYSTEM      ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    viewStudentDetails(scanner);
                    break;
                case 4:
                    calculateClassAverage();
                    break;
                case 5:
                    findTopStudent();
                    break;
                case 6:
                    findLowestStudent();
                    break;
                case 7:
                    searchStudent(scanner);
                    break;
                case 8:
                    updateStudentGrades(scanner);
                    break;
                case 9:
                    displaySubjectStatistics();
                    break;
                case 10:
                    displayFailingStudents();
                    break;
                case 11:
                    sortStudentsByAverage();
                    break;
                case 0:
                    System.out.println("\n✓ Thank you for using the system. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("\n✗ Invalid choice! Please try again.");
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    // Display the main menu
    public static void displayMenu() {
        System.out.println("\n" + "=".repeat(45));
        System.out.println("               MAIN MENU");
        System.out.println("=".repeat(45));
        System.out.println("1.  Add New Student");
        System.out.println("2.  View All Students");
        System.out.println("3.  View Student Details");
        System.out.println("4.  Calculate Class Average");
        System.out.println("5.  Find Top Student");
        System.out.println("6.  Find Lowest Performing Student");
        System.out.println("7.  Search Student by Name");
        System.out.println("8.  Update Student Grades");
        System.out.println("9.  Display Subject Statistics");
        System.out.println("10. Display Failing Students");
        System.out.println("11. Sort Students by Average");
        System.out.println("0.  Exit");
        System.out.println("=".repeat(45));
    }
    
    // Add a new student with grades
    public static void addStudent(Scanner scanner) {
        if (studentCount >= 50) {
            System.out.println("\n✗ Student limit reached!");
            return;
        }
        
        System.out.println("\n--- ADD NEW STUDENT ---");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        studentNames[studentCount] = name;
        
        System.out.println("\nEnter grades for " + name + " (0-100):");
        for (int i = 0; i < subjects.length; i++) {
            while (true) {
                System.out.print(subjects[i] + ": ");
                int grade = scanner.nextInt();
                
                if (grade >= 0 && grade <= 100) {
                    studentGrades[studentCount][i] = grade;
                    break;
                } else {
                    System.out.println("✗ Invalid grade! Enter 0-100.");
                }
            }
        }
        scanner.nextLine(); // Consume newline
        
        studentCount++;
        System.out.println("\n✓ Student added successfully!");
    }
    
    // View all students with their averages
    public static void viewAllStudents() {
        if (studentCount == 0) {
            System.out.println("\n✗ No students in the system.");
            return;
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    ALL STUDENTS");
        System.out.println("=".repeat(60));
        System.out.printf("%-5s %-20s %-15s %-10s%n", "No.", "Name", "Average", "Grade");
        System.out.println("-".repeat(60));
        
        for (int i = 0; i < studentCount; i++) {
            double average = calculateAverage(studentGrades[i]);
            String letterGrade = getLetterGrade(average);
            System.out.printf("%-5d %-20s %-15.2f %-10s%n", 
                (i + 1), studentNames[i], average, letterGrade);
        }
        System.out.println("=".repeat(60));
    }
    
    // View detailed information for a specific student
    public static void viewStudentDetails(Scanner scanner) {
        if (studentCount == 0) {
            System.out.println("\n✗ No students in the system.");
            return;
        }
        
        System.out.print("\nEnter student number (1-" + studentCount + "): ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (index < 0 || index >= studentCount) {
            System.out.println("\n✗ Invalid student number!");
            return;
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("STUDENT DETAILS: " + studentNames[index]);
        System.out.println("=".repeat(50));
        
        int total = 0;
        for (int i = 0; i < subjects.length; i++) {
            int grade = studentGrades[index][i];
            total += grade;
            System.out.printf("%-15s: %3d (%s)%n", 
                subjects[i], grade, getLetterGrade(grade));
        }
        
        double average = (double) total / subjects.length;
        System.out.println("-".repeat(50));
        System.out.printf("Average        : %.2f%n", average);
        System.out.printf("Letter Grade   : %s%n", getLetterGrade(average));
        System.out.printf("Status         : %s%n", 
            average >= 60 ? "PASSING" : "FAILING");
        System.out.println("=".repeat(50));
    }
    
    // Calculate and display class average
    public static void calculateClassAverage() {
        if (studentCount == 0) {
            System.out.println("\n✗ No students in the system.");
            return;
        }
        
        double totalAverage = 0;
        for (int i = 0; i < studentCount; i++) {
            totalAverage += calculateAverage(studentGrades[i]);
        }
        
        double classAverage = totalAverage / studentCount;
        System.out.println("\n" + "=".repeat(40));
        System.out.println("         CLASS STATISTICS");
        System.out.println("=".repeat(40));
        System.out.printf("Total Students  : %d%n", studentCount);
        System.out.printf("Class Average   : %.2f%n", classAverage);
        System.out.printf("Letter Grade    : %s%n", getLetterGrade(classAverage));
        System.out.println("=".repeat(40));
    }
    
    // Find and display the top performing student
    public static void findTopStudent() {
        if (studentCount == 0) {
            System.out.println("\n✗ No students in the system.");
            return;
        }
        
        int topIndex = 0;
        double topAverage = calculateAverage(studentGrades[0]);
        
        for (int i = 1; i < studentCount; i++) {
            double currentAverage = calculateAverage(studentGrades[i]);
            if (currentAverage > topAverage) {
                topAverage = currentAverage;
                topIndex = i;
            }
        }
        
        System.out.println("\n" + "=".repeat(45));
        System.out.println("          TOP PERFORMING STUDENT");
        System.out.println("=".repeat(45));
        System.out.println("Name    : " + studentNames[topIndex]);
        System.out.printf("Average : %.2f%n", topAverage);
        System.out.println("Grade   : " + getLetterGrade(topAverage));
        System.out.println("=".repeat(45));
    }
    
    // Find and display the lowest performing student
    public static void findLowestStudent() {
        if (studentCount == 0) {
            System.out.println("\n✗ No students in the system.");
            return;
        }
        
        int lowestIndex = 0;
        double lowestAverage = calculateAverage(studentGrades[0]);
        
        for (int i = 1; i < studentCount; i++) {
            double currentAverage = calculateAverage(studentGrades[i]);
            if (currentAverage < lowestAverage) {
                lowestAverage = currentAverage;
                lowestIndex = i;
            }
        }
        
        System.out.println("\n" + "=".repeat(45));
        System.out.println("       LOWEST PERFORMING STUDENT");
        System.out.println("=".repeat(45));
        System.out.println("Name    : " + studentNames[lowestIndex]);
        System.out.printf("Average : %.2f%n", lowestAverage);
        System.out.println("Grade   : " + getLetterGrade(lowestAverage));
        System.out.println("=".repeat(45));
    }
    
    // Search for a student by name
    public static void searchStudent(Scanner scanner) {
        if (studentCount == 0) {
            System.out.println("\n✗ No students in the system.");
            return;
        }
        
        System.out.print("\nEnter student name to search: ");
        String searchName = scanner.nextLine();
        
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (studentNames[i].toLowerCase().contains(searchName.toLowerCase())) {
                if (!found) {
                    System.out.println("\n--- SEARCH RESULTS ---");
                    found = true;
                }
                double average = calculateAverage(studentGrades[i]);
                System.out.printf("%d. %s (Average: %.2f, Grade: %s)%n", 
                    (i + 1), studentNames[i], average, getLetterGrade(average));
            }
        }
        
        if (!found) {
            System.out.println("\n✗ No students found matching '" + searchName + "'");
        }
    }
    
    // Update grades for a specific student
    public static void updateStudentGrades(Scanner scanner) {
        if (studentCount == 0) {
            System.out.println("\n✗ No students in the system.");
            return;
        }
        
        System.out.print("\nEnter student number (1-" + studentCount + "): ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (index < 0 || index >= studentCount) {
            System.out.println("\n✗ Invalid student number!");
            return;
        }
        
        System.out.println("\nUpdating grades for: " + studentNames[index]);
        System.out.println("Current grades:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%s: %d%n", subjects[i], studentGrades[index][i]);
        }
        
        System.out.println("\nEnter new grades (0-100):");
        for (int i = 0; i < subjects.length; i++) {
            while (true) {
                System.out.print(subjects[i] + ": ");
                int grade = scanner.nextInt();
                
                if (grade >= 0 && grade <= 100) {
                    studentGrades[index][i] = grade;
                    break;
                } else {
                    System.out.println("✗ Invalid grade! Enter 0-100.");
                }
            }
        }
        scanner.nextLine();
        
        System.out.println("\n✓ Grades updated successfully!");
    }
    
    // Display statistics for each subject
    public static void displaySubjectStatistics() {
        if (studentCount == 0) {
            System.out.println("\n✗ No students in the system.");
            return;
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                 SUBJECT STATISTICS");
        System.out.println("=".repeat(60));
        System.out.printf("%-15s %-12s %-12s %-12s%n", 
            "Subject", "Average", "Highest", "Lowest");
        System.out.println("-".repeat(60));
        
        for (int subject = 0; subject < subjects.length; subject++) {
            int sum = 0;
            int highest = studentGrades[0][subject];
            int lowest = studentGrades[0][subject];
            
            for (int student = 0; student < studentCount; student++) {
                int grade = studentGrades[student][subject];
                sum += grade;
                if (grade > highest) highest = grade;
                if (grade < lowest) lowest = grade;
            }
            
            double average = (double) sum / studentCount;
            System.out.printf("%-15s %-12.2f %-12d %-12d%n", 
                subjects[subject], average, highest, lowest);
        }
        System.out.println("=".repeat(60));
    }
    
    // Display students with failing grades (average < 60)
    public static void displayFailingStudents() {
        if (studentCount == 0) {
            System.out.println("\n✗ No students in the system.");
            return;
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           STUDENTS WITH FAILING GRADES");
        System.out.println("=".repeat(50));
        
        boolean foundFailing = false;
        for (int i = 0; i < studentCount; i++) {
            double average = calculateAverage(studentGrades[i]);
            if (average < 60) {
                if (!foundFailing) {
                    System.out.printf("%-5s %-20s %-15s%n", "No.", "Name", "Average");
                    System.out.println("-".repeat(50));
                    foundFailing = true;
                }
                System.out.printf("%-5d %-20s %-15.2f%n", 
                    (i + 1), studentNames[i], average);
            }
        }
        
        if (!foundFailing) {
            System.out.println("✓ No students with failing grades!");
        }
        System.out.println("=".repeat(50));
    }
    
    // Sort and display students by average (highest to lowest)
    public static void sortStudentsByAverage() {
        if (studentCount == 0) {
            System.out.println("\n✗ No students in the system.");
            return;
        }
        
        // Create arrays to hold averages and indices
        double[] averages = new double[studentCount];
        int[] indices = new int[studentCount];
        
        for (int i = 0; i < studentCount; i++) {
            averages[i] = calculateAverage(studentGrades[i]);
            indices[i] = i;
        }
        
        // Bubble sort (descending order)
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - i - 1; j++) {
                if (averages[j] < averages[j + 1]) {
                    // Swap averages
                    double tempAvg = averages[j];
                    averages[j] = averages[j + 1];
                    averages[j + 1] = tempAvg;
                    
                    // Swap indices
                    int tempIdx = indices[j];
                    indices[j] = indices[j + 1];
                    indices[j + 1] = tempIdx;
                }
            }
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          STUDENTS RANKED BY AVERAGE");
        System.out.println("=".repeat(60));
        System.out.printf("%-5s %-20s %-15s %-10s%n", 
            "Rank", "Name", "Average", "Grade");
        System.out.println("-".repeat(60));
        
        for (int i = 0; i < studentCount; i++) {
            int studentIndex = indices[i];
            System.out.printf("%-5d %-20s %-15.2f %-10s%n", 
                (i + 1), studentNames[studentIndex], 
                averages[i], getLetterGrade(averages[i]));
        }
        System.out.println("=".repeat(60));
    }
    
    // Helper method: Calculate average of grades
    public static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }
    
    // Helper method: Convert numeric grade to letter grade
    public static String getLetterGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }
}