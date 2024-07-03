import java.sql.*;
class MysqlInsertnu{
public static void main(String args[]){

try (Connection conn = DriverManager.getConnection(
"jdbc:mysql://127.0.0.1:3306/mca", "root", "SONYindia59830@")) {



if (conn != null) {
System.out.println("Connected to the database!");
} else {
System.out.println("Failed to make connection!");
}
Statement stmt=conn.createStatement();
String sql = "INSERT INTO student " +
"VALUES (15,'Amity', 'Zurich')";
stmt.executeUpdate(sql);
sql = "INSERT INTO student " +
"VALUES (16,'University', 'Barcelona' )";
stmt.executeUpdate(sql);
sql = "INSERT INTO student " +
"VALUES (17,'Noida', 'London')";
stmt.executeUpdate(sql);
sql = "INSERT INTO student " +
"VALUES(18,'Sumit', 'Austin')";
stmt.executeUpdate(sql);
System.out.println("Inserted records into the table...");



conn.close();
}
catch(Exception e){ System.out.println(e);}
}
}