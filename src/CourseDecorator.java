abstract class CourseDecorator implements Course{
    protected Course selCourse;
    public CourseDecorator(Course selCourse)
    {
        this.selCourse = selCourse;
    }
    @Override
    public void deliverContent()
    {
        selCourse.deliverContent();
    }
    @Override
    public String getName()
    {
        return selCourse.getName();
    }
}
