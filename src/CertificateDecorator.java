import java.util.Scanner;

public class CertificateDecorator extends CourseDecorator {
    public CertificateDecorator(Course course) {
        super(course);
    }

    public void deliverContent() {
        course.deliverContent();
        System.out.println("Certificate option added!");
    }

    public boolean checkTask(Scanner sc) {
        System.out.print("Checker task: 3+9=?");
        return sc.nextLine().trim().equals("12");
    }


    public boolean checkFinalTask(Scanner sc) {
        System.out.print("Final: lg(1)=? ");
        return sc.nextLine().trim().equals("0");
    }
}
