import java.util.Scanner;
public class project1 {
    public static void main(String[]args){
        Scanner j = new Scanner(System.in);
        System.out.println("\n=======STUDENT CALCULATOR GRADE========");
        System.out.print("Enter your name: ");
        String name = j.nextLine();
        System.out.print("Enter Your age: ");
        int age = j.nextInt();
        System.out.print("Enter your Student ID: ");
        long id = j.nextLong();
        System.out.print("Is student enrolled? (true/false): ");
        boolean enrolled = j.nextBoolean();
        System.out.print("Student Grade Lavel: ");
        char gradelevel = j.next().charAt(0);
        System.out.println("\n ---TEST SCORE---");
        System.out.print("Enter test score 1: ");
        double score1 = j.nextDouble();
        System.out.print("Enter test score 2: ");
        double score2 = j.nextDouble();
        System.out.print("Enter test score 3: ");
        double score3 = j.nextDouble();
        System.out.print("Enter test score 4: ");
        double score4= j.nextDouble();
        System.out.print("Enter test score 5: ");
        double score5 = j.nextDouble();
        System.out.print("attendance percentage (0-100)");
        double attendance = j.nextDouble();
        System.out.print("Extra Credit Point ");
        double credit = j.nextDouble();
        double average = (score1 + score2 + score3 + score4 + score5)/5;
        double wigthedaverage = (average * 0.8) + (attendance * 0.2) ;
        double finalscore = wigthedaverage + credit;
        if (finalscore >= 90) {
            System.out.println(" A");
        } else if (finalscore >= 80) {
            System.out.println(" B");
        } else if (finalscore >= 70) {
            System.out.println("C");
        } else if (finalscore >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F"); 
            
        }
       if (finalscore >=60 && attendance >=75) {
        System.out.println("PASSED✅✅✅");
       }
       else{
        System.out.println("FAELD❌❌❌");
       }
        
     double highest = score1;
        if (score2 > highest) {
            highest = score2;
        }
        else if (score3 > highest) {
            highest = score3;
        }
        else if (score4 > highest) {
            highest = score4;
        }
        else if (score5 > highest) {
            highest = score5;
        }
        double lowest = score1;
        if (score2 < lowest) {  
            lowest = score2;
        }
        else if (score3 < lowest) {
            lowest = score3;
        }
        else if (score4 < lowest) {
            lowest = score4;
        }
        else if (score5 < lowest) {
            lowest = score5;
        }       
        double range = highest - lowest;

       boolean passed = (score1 >= 60) && (score2 >= 60) && 
                    (score3 >= 60) && (score4 >= 60) && 
                    (score5 >= 60);
    System.out.println("\n==========================================");
    System.out.println("\nSTUDENT GRADE REPORT");
    System.out.println("\n==========================================");
        System.out.println(" Name: "+ name);
        System.out.println(" age: "+ age);
        System.out.println(" Student ID: "+ id );
        System.out.println("Enrolled:  "+ enrolled);
        System.out.println("Grade level: "+ gradelevel);
        System.out.println("---TEST SCORE---");
        System.out.printf("test1: %.2f%n" , score1);
        System.out.printf("test2: %.2f%n" , score2);
        System.out.printf("test3: %.2f%n" , score3);
        System.out.printf("test4: %.2f%n" , score4);
        System.out.printf("test5: %.2f%n" , score5);
        System.out.println("----\nCALCULATION----");
        System.out.println("AVERAGE test Score: "+average);
        System.out.println("WEIGTH GRADE: "+wigthedaverage);
        System.out.println("EXTRA CREDIT: "+ credit);
        System.out.println("FINAL SCORE: "+finalscore);
        System.out.println("\nLETTER GRADE: "+finalscore);
        System.out.println("\n---STATIC---");
        System.out.println("HIGHEST TEST SCORE: "+highest);
         System.out.println("LOWEST TEST SCORE: "+lowest);
        System.out.println("Score Range: "+ range);
        System.out.println(" ALL TEST PASSED? : "+passed);
        System.out.println("\nExcellent work, Alice! Keep it up!");
        System.out.println("=====================================");
    }
}
