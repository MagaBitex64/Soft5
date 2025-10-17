public class StudentPortalFacade {
    private Leaderboard leaderboard = new Leaderboard();
    private Student[] students;

    public void enrollInCourse(Course course,String sname)
    {
        System.out.println(sname+" enrolled in "+ course.getName());
    }

    public void startLearning(Course course, String sname)
    {
        System.out.println(sname+" learning "+course.getName());
        course.deliverContent();
    }

    public void completeCourse(Course course, String sname)
    {
        System.out.println(sname + "completed "+course.getName());
        if(checker(course)){leaderboard.show();}
    }

    public Leaderboard getLeaderboard(){
        return leaderboard;
    }

    public boolean checker(Course course)
    {
        if(course instanceof GamificationDecorator){return true;}
        if(course instanceof CourseDecorator)
        {
            return checker(((CourseDecorator) course).selCourse);
        }
        return false;
    }
}
