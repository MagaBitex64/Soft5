import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 9)
        {
            System.out.println("LMS MENU. Choose option");
            System.out.println("1.Add Student");
            System.out.println("2.Enroll to course");
            System.out.println("3.Learn Course");
            System.out.println("4.Complete Course");
            System.out.println("5.Exit");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the name");
                    String sname = sc.nextLine();
            }
        }
        System.out.println("");
    }
}