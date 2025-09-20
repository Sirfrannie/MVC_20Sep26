package mypack;

import java.io.IOException;
import java.util.ArrayList;

public class UI implements View
{


    public void displayAdminPage(ArrayList<Student> student){
        clear();
        System.out.println("---------- Student List ----------");
        for (int i=0; i<student.size(); ++i){
            Student now = student.get(i);
            System.out.print(now.getID()+":");
            System.out.print(now.getName());
            System.out.print(" "+now.getAge()+" year old");
            System.out.println();
            System.out.println("Current School: "+now.getSchool());
            System.out.println("----------------------------------");
        }
        System.out.println("Choose an action                 -");
        System.out.println("1. sort by name                   ");
        System.out.println("2. filter by school               ");
        System.out.println("3. See student detail             ");
        System.out.print(">> ");
    }
    public void selectSeeStudentDetail(ArrayList<Student> student){
        clear();
        System.out.println("---------- Student List ----------");
        for (int i=0; i<student.size(); ++i){
            Student now = student.get(i);
            System.out.print((i+1)+". "+now.getID()+":");
            System.out.print(now.getName());
            System.out.println();
            System.out.println("----------------------------------");
        }
        System.out.println("Select Number                    -");
        System.out.print(">> ");
    }


    private void clear(){
        try {
            clearScreen();
        }catch (Exception e){
        }
    }
    private void clearScreen() throws IOException, InterruptedException{
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    }

}
