import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try {
            c= DriverManager.getConnection("jdbc:mysql:///bankManagementSystem","root","Xworkzodc@123");
            s= c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) {

    }
}
