import java.sql.*;
import java.io.*;



public class UpdatableResultSetExample {

public static void main(String[] args) {
String url = "jdbc:mysql://localhost:3306/mca";
String username = "root";
String password = "SONYindia59830@";

Console console = System.console();

try (Connection conn = DriverManager.getConnection(url, username, password)) {

DatabaseMetaData metadata = conn.getMetaData();

boolean isUpdatable = metadata.supportsResultSetConcurrency(
ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

if (!isUpdatable) {
System.out.println("The database does not support updatable result sets.");
return;
}

String sql = "SELECT * FROM student";

Statement statement = conn.createStatement(
ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);


ResultSet result = statement.executeQuery(sql);

int row = -1;

while (row != 0) {
row = Integer.parseInt(console.readLine("Enter row number: "));

if (result.absolute(row)) {
readStudentInfo("Student at row " + row + ": ", result);

String answer = console.readLine("Do you want to update this row (Y/N)?: ");

if (answer.equalsIgnoreCase("Y")) {
String Name = console.readLine("\tUpdate name: ");
String City = console.readLine("\tUpdate city: ");
//String major = console.readLine("\tUpdate major: ");

result.updateString("name", Name);
result.updateString("city", City);
//result.updateString("major", major);
result.updateRow();

System.out.println("The student at row " + row + " has been updated.");
}

answer = console.readLine("Do you want to delete this row (Y/N)?: ");

if (answer.equalsIgnoreCase("Y")) {
result.deleteRow();
System.out.println("The student at row " + row + " has been deleted.");
}

answer = console.readLine("Do you want to insert new row (Y/N)?: ");

if (answer.equalsIgnoreCase("Y")) {
result.moveToInsertRow();

String Name = console.readLine("\tUpdate name: ");
String City = console.readLine("\tUpdate city: ");
//String major = console.readLine("\tUpdate major: ");

result.updateString("name", Name);
result.updateString("city", City);
//result.updateString("major", major);
result.insertRow();

result.moveToCurrentRow();

System.out.println("The new student has been inserted.");
}

} else {
System.out.println("There's no student at row " + row);
}
}

} catch (SQLException ex) {
ex.printStackTrace();
}

}

private static void readStudentInfo(String position, ResultSet result)
throws SQLException {
String Name = result.getString("name");
String City = result.getString("city");
//String major = result.getString("major");

String studentInfo = "%s: %s - %s\n";
System.out.format(studentInfo, position, Name, City);
}
}