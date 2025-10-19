public class MentorSupportDecorator extends CourseDecorator {
    public MentorSupportDecorator(Course course) {
        super(course);
    }
    public void deliverContent() {
        course.deliverContent();
        System.out.println("Mentor support enabled!");
    }
}
