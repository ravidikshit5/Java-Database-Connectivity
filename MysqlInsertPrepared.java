import java.sql.*;
import java.io.*;
class MysqlInsertPrepared{
public static void main(String args[]){

try (Connection conn = DriverManager.getConnection(
"jdbc:mysql://127.0.0.1:3306/mca", "root", "SONYindia59830@")) {



if (conn != null) {
System.out.println("Connected to the database!");
} else {
System.out.println("Failed to make connection!");
}
String sql="insert into mytablenew(Name,City) values(?,?)";
PreparedStatement pstmt=conn.prepareStatement(sql);
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter your name:");
String Name=br.readLine();
System.out.println("Enter city:");
String City=br.readLine();
pstmt.setString(1,Name);
pstmt.setString(2,City);
pstmt.executeUpdate();
System.out.println("Inserted...");
conn.close();
}
catch(Exception e){ System.out.println(e);}
}
}