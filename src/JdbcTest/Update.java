package JdbcTest;

import java.sql.*;
public class Update {
    public static void main(String[] args) throws SQLException{

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="tiger";

        try{
            Class.forName("com.sql.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!!!");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("Connection loaded Successfully !!!");
            Statement stmt=con.createStatement();
            int rowintrpt =stmt.executeUpdate("UPDATE employees SET job_title='DEVOps Engineer',salary=88000.0 WHERE id=3;");

            if(rowintrpt>0){
                System.out.println("Update Successfully "+rowintrpt+ " row(s) affected");
            }else {
                System.out.println("Updation Failed");
            }
            con.close();
            stmt.close();
            System.out.println("Interfaces closed Successfully!!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }


    }
}
