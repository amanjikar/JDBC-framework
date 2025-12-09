package JdbcTest;

import java.sql.*;
public class RetrivalData {
    public static void main(String[] args) throws ClassNotFoundException {

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="tiger";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver class Found Successfully!!!");
        }catch(ClassNotFoundException e){
            System.out.print(e.getMessage());
        }

        try{
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("Connection Set Successfully!!!");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from employees");

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String job_title=rs.getString("job_title");
                double salary=rs.getDouble("salary");
                System.out.println("___________________________________________-");
                System.out.println("id: "+ id);
                System.out.println("name: "+ name);
                System.out.println("job_title: "+ job_title);
                System.out.println("salary: "+ salary);
                System.out.println("___________________________________________-");
            }
            rs.close();
            stmt.close();
            con.close();


        }catch(SQLException e){
            System.out.print(e.getMessage());
        }

    }
}