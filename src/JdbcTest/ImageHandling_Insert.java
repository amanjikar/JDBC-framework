package JdbcTest;

import java.io.FileInputStream;
import java.sql.*;

public class ImageHandling_Insert {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "tiger";
        String image_path="C:\\Users\\HP\\Pictures\\wlp 1.jpg";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("Connected to database...");
            FileInputStream fis=new FileInputStream(image_path);
            byte[] imagedata=new byte[fis.available()];
            fis.read(imagedata);

            PreparedStatement pstmt=con.prepareStatement("INSERT INTO image_table(image_data) VALUES(?)");
            pstmt.setBytes(1, imagedata);
            int affectedRows=pstmt.executeUpdate();
            if(affectedRows>0){
                System.out.println("Image inserted successfully");
            }else{
                System.out.println("Image insert failed");
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
