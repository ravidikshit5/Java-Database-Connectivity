import java.sql.*;
public class JDBCExample2 {
public static void main(String[] args) {
// creates Connection objects
Connection conn1 = null;

try {
String url1 = "jdbc:mysql://localhost:3306/mca";
String user = "root";
String password = "SONYindia59830@";
conn1 = DriverManager.getConnection(url1, user, password);
if (conn1 != null) {
System.out.println("Connected to the database mca");
}
} catch (SQLException ex) {
System.out.println("An error occurred. Maybe user/password is invalid");
ex.printStackTrace();
}
}
}