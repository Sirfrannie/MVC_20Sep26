package mypack;

public class Student
{
    private String name;
    private String school;
    private int age;
    private int id;
    
    public Student(){

    }

    public void setName(String name){
        this.name = name;
    }
    public void setSchool(String school){
        this.school = school;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setID(int id){
        this.id = id;
    }

    public int getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getSchool(){
        return this.school;
    }
    public int getAge(){
        return this.age;
    }
}
