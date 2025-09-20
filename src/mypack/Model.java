package mypack;

import java.util.ArrayList;
public interface Model
{
    public void getUser();
    public ArrayList<Student> getStudentData(String order, String filter);
}
