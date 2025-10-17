public class CertificateDecorator extends CourseDecorator{
    public CertificateDecorator(Course selCourse)
    {
        super(selCourse);
    }

    public void getCertificate()
    {
        System.out.println("Certificate granted");
    }
    @Override
    public void deliverContent()
    {
        super.deliverContent();
        getCertificate();

    }
    @Override
    public String getName()
    {
        return selCourse.getName()+" Certificate";
    }
}
