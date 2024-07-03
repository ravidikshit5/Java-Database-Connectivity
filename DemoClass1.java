import java.sql.*;
public class DemoClass1{
public static void main(String[] args) throws Exception{
String url = "jdbc:mysql://localhost:3306/mca";
String uname = "root";
String pass = "SONYindia59830@";
String query = " select Name from student";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(url,uname,pass);
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(query);
rs.next();

String name = rs.getString("Name");
rs.next();
System.out.println("Connected to the Database");
System.out.println(name);
st.close();
con.close();
}
}