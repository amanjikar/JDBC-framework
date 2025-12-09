package JdbcTest;
import java.sql.*;

public class Deletion {

    public static void main(String []args){
        try{
            Class.forName("com.sql.jdbc.Driver");
            System.out.println("Driver Class loaded Successfully!!!");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="tiger";

        try{
            Connection con =DriverManager.getConnection(url,username,password);
            System.out.println("Connection Successful!!!");
            Statement stmt = con.createStatement();
            int rowaffected=stmt.executeUpdate("delete from employees where id=1;");
            if(rowaffected>0){
                System.out.println("Employee Deleted Successfully!!!");
            }else{
                System.out.println("Employee Deletion Failed!!!");
            }
            con.close();
            stmt.close();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
