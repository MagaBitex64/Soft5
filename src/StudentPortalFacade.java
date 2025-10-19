import java.util.*;

public class StudentPortalFacade {
    private final Leaderboard leaderboard = new Leaderboard();
    private final List<Student> students = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\nLMS");
            System.out.println("1.Add Student");
            System.out.println("2.Enroll in Course");
            System.out.println("3.Learn Course");
            System.out.println("4.Show Leaderboard");
            System.out.println("5.Complete Course");
            System.out.println("0.Exit");
            System.out.print("Choose:");
            switch (sc.nextLine()) {
                case "1": {addStudent();break;}
                case "2": {enrollStudent();break;}
                case "3": {learnCourse();break;}
                case "4": {leaderboard.showLeaderboard();break;}
                case "5": {completeCourse();break;}
                case "0": {
                    System.out.println("Bye");
                    return;
                }
                default: {System.out.println("Invalid choice!");break;}
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter year (1-3): ");
        int year = Integer.parseInt(sc.nextLine());
        students.add(new Student(name, year));
        System.out.println("Added student " + name);
    }

    private void enrollStudent() {
        Student s = selectStudent();
        if (s == null) return;

        Course course = null;
        if (s.year == 1) {
            course = new MathCourse();
        } else if (s.year == 2) {
            System.out.print("Choose course 1-Math, 2-Programming: ");
            course = sc.nextLine().equals("1") ? new MathCourse() : new ProgrammingCourse();
        } else if (s.year == 3) {
            course = new ProgrammingCourse();
        }

        System.out.print("Add mentor support? (y/n): ");
        if (sc.nextLine().equals("y"))
            course = new MentorSupportDecorator(course);

        System.out.print("Add certificate? (y/n): ");
        if (sc.nextLine().equals("y"))
            course = new CertificateDecorator(course);

        System.out.print("Add gamification? (y/n): ");
        boolean gamified = sc.nextLine().equals("y");
        if (gamified)
            course = new GamificationDecorator(course, leaderboard, s);

        s.enrolledCourses.add(course);
        System.out.println("Enrolled " + s.name + " to " + course.getName());
    }

    private Course selectCourse(Student s) {
        if (s.enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled.");
            return null;
        }

        System.out.println("Courses for " + s.name + ":");
        for (int i = 0; i < s.enrolledCourses.size(); i++) {
            System.out.println((i + 1) + ". " + s.enrolledCourses.get(i).getName());
        }
        System.out.print("Select: ");
        int choice = Integer.parseInt(sc.nextLine()) - 1;
        if (choice < 0 || choice >= s.enrolledCourses.size()) {
            System.out.println("Invalid choice.");
            return null;
        }
        return s.enrolledCourses.get(choice);
    }


    private void learnCourse() {
        Student s = selectStudent();
        if (s == null) return;

        Course c = selectCourse(s);
        if (c == null) return;

        c.deliverContent();

        if (isGamified(c)) {
            GamificationDecorator g = getGamified(c);
            if (g != null) g.addPoints();
        }

        if (isCertificate(c)) {
            CertificateDecorator cert = getCertificate(c);
            if (cert != null) {
                if (cert.checkTask(sc))
                    System.out.println("Course learning successful");
                else
                    System.out.println("Task failed");
            }
        } else {
            System.out.println("Course learning completed");
        }
    }

    private void completeCourse() {
        Student s = selectStudent();
        if (s == null) return;

        Course c = selectCourse(s);
        if (c == null) return;

        System.out.println("Completing " + c.getName() + " for " + s.name);

        if (isCertificate(c)) {
            CertificateDecorator cert = getCertificate(c);
            if (cert != null) {
                if (cert.checkFinalTask(sc))
                    System.out.println("Congratulations! " + s.name + " completed the course and earned a certificate!");
                else
                    System.out.println("Final task failed.");
            }
        } else {
            System.out.println("Course completed.");
        }
    }


    private Student selectStudent() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return null;
        }
        System.out.println("Students:");
        for (int i = 0; i < students.size(); i++){
            System.out.println(students.get(i));
        }
        System.out.print("Select: ");
        int i = Integer.parseInt(sc.nextLine()) - 1;
        return (i >= 0 && i < students.size()) ? students.get(i) : null;
    }

    private boolean isGamified(Course c) {
        if (c instanceof GamificationDecorator) return true;
        if (c instanceof CourseDecorator) return isGamified(((CourseDecorator) c).course);
        return false;
    }

    private GamificationDecorator getGamified(Course c) {
        if (c instanceof GamificationDecorator g) return g;
        if (c instanceof CourseDecorator) return getGamified(((CourseDecorator) c).course);
        return null;
    }

    private boolean isCertificate(Course c) {
        if (c instanceof CertificateDecorator) return true;
        if (c instanceof CourseDecorator) return isCertificate(((CourseDecorator) c).course);
        return false;
    }

    private CertificateDecorator getCertificate(Course c) {
        if (c instanceof CertificateDecorator cert) return cert;
        if (c instanceof CourseDecorator) return getCertificate(((CourseDecorator) c).course);
        return null;
    }
}
