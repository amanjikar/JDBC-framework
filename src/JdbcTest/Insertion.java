package JdbcTest;
import java.sql.*;

public class Insertion {
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
            int rowintrpt =stmt.executeUpdate("INSERT INTO employees(id,name,job_title,salary) values(1,'Aman','Java developer',35000.0) ");

            if(rowintrpt>0){
                System.out.println("Insert Successfully "+rowintrpt+ " row(s) affected");
            }else {
                System.out.println("Insertion Failed");
            }
            con.close();
            stmt.close();
            System.out.println("Interfaces closed Successfully!!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }


    }
}
