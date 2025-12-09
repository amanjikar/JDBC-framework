package JdbcTest;
import java.sql.*;

public class PreparedStatements {
    public static void main(String []args) throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "tiger";
        String query="SELECT * FROM employees where name=?;";
        try{
            Class.forName("com.sql.jdbc.Driver");
            System.out.println("Driver loaded Successfully...");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("Connection Successful...");
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1,"Aman_Jikar");
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                String name=rs.getString("name");
                System.out.println(name);
            }
            con.close();
            pst.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
