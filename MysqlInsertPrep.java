import java.sql.*;
class MysqlInsertPrep{
public static void main(String args[]){
try (Connection conn = DriverManager.getConnection(
"jdbc:mysql://127.0.0.1:3306/mca", "root", "SONYindia59830@")) {



if (conn != null) {
System.out.println("Connected to the database!");
} else {
System.out.println("Failed to make connection!");
}

PreparedStatement pstmt=conn.prepareStatement("insert into mytablenew values(?,?,?)");
pstmt.setInt(1,16); //1 specifies the first parameter in the query
pstmt.setString(2,"Michael");
pstmt.setString(3,"Ontario");

int i=pstmt.executeUpdate();
System.out.println(i+" records inserted");

conn.close();

}catch(Exception e){ System.out.println(e);}

}
}