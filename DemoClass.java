import java.sql.*;
public class DemoClass{
public static void main(String args[])throws Exception{
String url = "jdbc:mysql://localhost:3306/mca";
String uname = "root";
String pass = "SONYindia59830@";
String query = "select * from student";
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection(url,uname,pass);
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(query);
rs.next();
rs.next();
String name = rs.getString("student");
System.out.println(name);
st.close();
con.close();
}
}
