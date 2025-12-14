import java.util.Scanner;
public class studentgradecalculator {
  int[] grade = {85, 92, 76, 88, 90};

    public void calcu(){
        System.out.println("================================STUDENT GRADE CALCULATOR================================");
        for (int i = 0; i<grade.length; i++ ) {
            System.out.println("STUDENT"+(i+1)+"."+grade[i]);
        }
    }
     public double calcu1(){
      double sum = 0;
      for (int i = 0; i < grade.length; i++) {
        sum+=grade[i];
      }
      double average = sum / grade.length;
        return average;
     }
     public int calcu3(){
        int high = grade[0];
        for (int i = 0; i < grade.length; i++) {
          if (grade[i]>high) {
            high = grade [i];
            
          }
        }
        return high;


     }
      public int findLowestGrade() {
        
        int lowest = grade[0];
        
       
        for (int i = 1; i < grade.length; i++) {
            if (grade[i] < lowest) {
                lowest = grade[i];
            }
        }
         return lowest;
      }
      public int calcu4(){
        int pass = 0;
         for (int i = 0; i < grade.length; i++) {
            if (grade[i] >= 75) {
                pass++;
            }
        }
        return pass;
      }
   public static void main(String[] args) {
    studentgradecalculator calculator = new  studentgradecalculator();
   calculator.calcu();
        
        System.out.println("\n=== STATISTICS ===");
        System.out.println("Average Grade: " + calculator.calcu1());
        System.out.println("Highest Grade: " + calculator.calcu3());
        System.out.println("Lowest Grade: " + calculator.findLowestGrade());
        System.out.println("Students Passed: " + calculator.calcu4());
   }
   
  }