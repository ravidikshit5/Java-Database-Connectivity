import java.sql.*;



public class ScrollableRSet {

public static void main(String[] args) {
String url = "jdbc:mysql://localhost:3306/mca";
String username = "root";
String password = "SONYindia59830@";


try (Connection conn = DriverManager.getConnection(url, username, password)) {

String sql = "SELECT * FROM student";

Statement statement = conn.createStatement(
ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

ResultSet result = statement.executeQuery(sql);

result.first();

readStudentInfo("first", result);

result.relative(3);

readStudentInfo("relative(3)", result);

result.previous();

readStudentInfo("previous", result);

result.absolute(4);

readStudentInfo("absolute(4)", result);

result.last();

readStudentInfo("last", result);

result.relative(-2);

readStudentInfo("relative(-2)", result);


} catch (SQLException ex) {
ex.printStackTrace();
}

}

private static void readStudentInfo(String position, ResultSet result)
throws SQLException {
String name = result.getString("name");
String city = result.getString("city");


String studentInfo = "%s: %s - %s\n";
System.out.format(studentInfo, position, name, city);
}
}