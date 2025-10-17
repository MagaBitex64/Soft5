public class ProgrammingCourse implements Course{
    @Override
    public void deliverContent()
    {
        System.out.println("Deliver Programming content");
    }
    @Override
    public String getName()
    {
        return "Programming";
    }
}
