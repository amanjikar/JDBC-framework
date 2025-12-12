package JdbcTest;
import java.sql.*;
public class TransactionHandling {
    public static void main(String[]args){
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "tiger";
        String withdrawQuery="UPDATE accounts SET balance=balance - ? WHERE account_number=?;";
        String depositQuery="UPDATE accounts SET balance=balance + ? WHERE account_number=?;";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("Connection Successful...");
            con.setAutoCommit(false);

            try{
                PreparedStatement withdrawstmt=con.prepareStatement(withdrawQuery);
                PreparedStatement depositstmt=con.prepareStatement(depositQuery);
                withdrawstmt.setDouble(1,500);
                withdrawstmt.setString(2,"account123");
                depositstmt.setDouble(1,500);
                depositstmt.setString(2,"account456");
                depositstmt.executeUpdate();
                withdrawstmt.executeUpdate();
                con.commit();
                System.out.println("Transaction Successful...");
            }catch(Exception e){
                con.rollback();
                System.out.println("Transaction Failed...!");
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
