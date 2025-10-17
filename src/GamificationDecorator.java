public class GamificationDecorator extends CourseDecorator{
    private Student[] students;
    private int points;
    private Leaderboard leaderboard;
    public GamificationDecorator(Course selCourse, Student[] students, Leaderboard leaderboard)
    {
        super(selCourse);
        this.students = students;
        this.points = 0;
        this.leaderboard = leaderboard;
    }

    @Override
    public void deliverContent()
    {
        super.deliverContent();
        addPoints(10,);
    }
    @Override
    public String getName()
    {
        return selCourse.getName()+" Gamification";
    }


    public void addPoints(int scores, int index)
    {
        points+=scores;
        leaderboard.addPoints(students[index].getName(),points);
        System.out.println(students[index]+" get "+ scores +"(Total "+points+" )");
    }
}

