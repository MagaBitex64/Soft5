import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    int year;
    List<Course> enrolledCourses = new ArrayList<>();
    private static int nid=1;
    int id;

    public Student(String name, int year) {
        this.id = nid++;
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString()
    {
        return id+": "+name+" (Year "+year+")";
    }
}
