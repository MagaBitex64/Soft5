public class GamificationDecorator extends CourseDecorator {
    private Leaderboard leaderboard;
    private Student student;

    public GamificationDecorator(Course c, Leaderboard lb, Student student) {
        super(c);
        leaderboard = lb;
        this.student = student;
    }

    public void deliverContent() {
        course.deliverContent();
        System.out.println("Gamification enabled!");
    }

    public void addPoints() {
        leaderboard.addPoints(student, 10);
        System.out.println(student.name + " earned "+10+" points");
    }
}
