public class MathCourse implements Course{
    @Override
    public void deliverContent()
    {
        System.out.println("Deliver math content");
    }
    @Override
    public String getName()
    {
        return "Math";
    }
}
