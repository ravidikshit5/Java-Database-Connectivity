import java.sql.*;
class MysqlContnew{
public static void main(String args[]){

try (Connection conn = DriverManager.getConnection(
"jdbc:mysql://127.0.0.1:3306/mca", "root", "SONYindia59830@")) {



if (conn != null) {
System.out.println("Connected to the database!");
} else {
System.out.println("Failed to make connection!");
}
//Statement stmt=conn.createStatement();
String sql="create table mytablenew(ID int(20) primary key auto_increment,Name varchar(200), City varchar(200))";
Statement stmt=conn.createStatement();
stmt.executeUpdate(sql);
System.out.println("table created in database");
conn.close();
}
catch(Exception e){ System.out.println(e);}
}
}