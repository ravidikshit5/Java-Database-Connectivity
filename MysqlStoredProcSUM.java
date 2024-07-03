import java.sql.*;
class MysqlStoredProcSUM{
public static void main(String args[]){

try (Connection conn = DriverManager.getConnection(
"jdbc:mysql://127.0.0.1:3306/mca", "root", "SONYindia59830@")) {



if (conn != null) {
System.out.println("Connected to the database!");
} else {
System.out.println("Failed to make connection!");
}
CallableStatement cst=conn.prepareCall("{call Sum(?,?,?)}");
cst.setInt(1,100);
cst.setInt(2,200);
cst.registerOutParameter(3,Types.INTEGER);
cst.execute();
System.out.println("Result"+cst.getInt(3));
conn.close();
}
catch(Exception e){ System.out.println(e);}
}
}