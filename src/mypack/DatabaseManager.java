package mypack;

import java.sql.*;
import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DatabaseManager 
    implements Model
{
    private Connection databaseConnection = null;
    private String dbURL = "jdbc:sqlite:Database.db";
    public DatabaseManager(){
        connect();
    }
    private boolean connect(){
        /* establish connection to database
         * if exceed limit of attemp return false 
         * attemp limit = 5
         */
        int attempt = 0;
        while (attempt < 5){
            try {
                databaseConnection = DriverManager.getConnection(dbURL);
                return true;
            }catch(SQLException e){
                System.out.println("Error: "+e.getMessage());
                ++attempt; 
            }       
        }
        return false;
    }

    public ArrayList<Student> getStudentData(String order, String filter){
        ArrayList<Student> ret = new ArrayList<>();
        String qString = "SELECT * FROM Students";
        if (filter != null){
            qString += " WHERE current_school="+filter;
        }
        if (order != null ){
            qString += " ORDER BY "+order;
        }
        ResultSet r = query(qString);
        
        if (r != null){
            try {
                while(r.next()){
                    ret.add(new Student());
                    int i = ret.size() - 1;
                    Student s = ret.get(i);
                    s.setID(r.getInt("id"));
                    s.setSchool(r.getString("current_school"));
                    s.setName(r.getString("prefix") +" "+r.getString("surname"));
                    int dob = r.getInt("date_of_birth");
                    s.setAge(calculateAge(dob));
                }        
            }catch (SQLException e){}
        }
        return ret;
    }
    private int calculateAge(int dobInt) {
        String dobStr = String.valueOf(dobInt);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate birthDate = LocalDate.parse(dobStr, formatter);

        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    public void getUser(){
        String queryString = "SELECT * FROM users";
        query(queryString);
    } 
    private ResultSet query(String queryString){
        ResultSet rs = null;
        try {
            Statement stmt = databaseConnection.createStatement();
            rs = stmt.executeQuery(queryString);
        }catch(SQLException e){

        }
        return rs;
    }
}
