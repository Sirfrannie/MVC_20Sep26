package mypack;

import java.util.ArrayList;
import java.util.Scanner;

public class RegistrySystem
    implements Controller
{
    // first page on admin page
    public void getStudentData(){
        studentList(null, null);
    }
    private void studentList(String order, String school_filter){
        Model m = new DatabaseManager();
        View v = new UI();
        Scanner sc = new Scanner(System.in);

        // data from database
        ArrayList<Student> data = new ArrayList<>();
        data = m.getStudentData(order, school_filter);

        // display
        v.displayAdminPage(data);
        // user input
        int input = sc.nextInt(); 
        if (input == 1){
            studentList("surname", null);
        }
        if (input == 2){
           System.out.println("Type school name :");
           String school = sc.nextLine().trim();
           studentList(null, school);
        } 
        if (input == 3){
            v.selectSeeStudentDetail(data);
        }else{
            studentList(null, null);
        }
    }
}
