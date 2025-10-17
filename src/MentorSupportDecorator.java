public class MentorSupportDecorator extends CourseDecorator{
    public MentorSupportDecorator(Course selCourse)
    {
        super(selCourse);
    }

    @Override
    public void deliverContent()
    {
        super.deliverContent();
        getMentor();

    }
    @Override
    public String getName()
    {
        return selCourse.getName()+" Mentor Support";
    }

    public void getMentor()
    {
        System.out.println("Mentor support enabled");
    }
}
