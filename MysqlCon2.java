import java.sql.*;
class MysqlCon2{
public static void main(String args[]){
try (Connection conn = DriverManager.getConnection(
"jdbc:mysql://127.0.0.1:3306/mca", "root", "SONYindia59830@")) {

 if (conn != null) {
System.out.println("Connected to the database!");
} else {
System.out.println("Failed to make connection!");
}
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery("select Name from student where Roll = 1");
while(rs.next());
System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
conn.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}
