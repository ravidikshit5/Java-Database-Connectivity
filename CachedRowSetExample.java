import java.sql.*;
import javax.sql.rowset.*;
import javax.sql.rowset.spi.*;
import java.io.*;



public class CachedRowSetExample {
static Console console = System.console();
static String answer;
static boolean quit = false;

public static void main(String[] args) {
String url = "jdbc:mysql://localhost:3306/mca";
String username = "root";
String password = "SONYindia59830@";

try (Connection conn = DriverManager.getConnection(url, username, password)) {
conn.setAutoCommit(false);

String sql = "SELECT * FROM student";

Statement statement = conn.createStatement();

ResultSet result = statement.executeQuery(sql);

RowSetFactory factory = RowSetProvider.newFactory();
CachedRowSet rowset = factory.createCachedRowSet();

rowset.setTableName("student");

rowset.populate(result);

while (!quit) {
if (!readStudent(rowset)) continue;

updateStudent(rowset);

deleteStudent(rowset);

insertStudent(rowset);

saveChanges(rowset, conn);

askToQuit();

}

} catch (SQLException ex) {
System.out.println(ex.getMessage());
ex.printStackTrace();
}

}

static void readStudentInfo(String position, ResultSet result)
throws SQLException {
String Name = result.getString("Name");
String City = result.getString("City");


String studentInfo = "%s: %s - %s\n";
System.out.format(studentInfo, position, Name, City);
}

static boolean readStudent(ResultSet result) throws SQLException {
int row = Integer.parseInt(console.readLine("Enter student number: "));

if (result.absolute(row)) {
readStudentInfo("Student at row " + row + ": ", result);
return true;
} else {
System.out.println("There's no student at row " + row);
return false;
}
}

static void updateStudent(ResultSet result) throws SQLException {
answer = console.readLine("Do you want to update this student (Y/N)?: ");

if (answer.equalsIgnoreCase("Y")) {
String Name = console.readLine("\tUpdate Name: ");
String City = console.readLine("\tUpdate City: ");


if (!Name.equals("")) result.updateString("Name", Name);
if (!City.equals("")) result.updateString("City", City);


result.updateRow();

System.out.println("The student has been updated.");
}

}

static void deleteStudent(ResultSet result) throws SQLException {
answer = console.readLine("Do you want to delete this student (Y/N)?: ");

if (answer.equalsIgnoreCase("Y")) {
result.deleteRow();

System.out.println("The student has been removed.");
}

}

static void insertStudent(ResultSet result) throws SQLException {
answer = console.readLine("Do you want to insert a new student (Y/N)?: ");

if (answer.equalsIgnoreCase("Y")) {
String Name = console.readLine("\tEnter Name: ");
String City = console.readLine("\tEnter City: ");


result.moveToInsertRow();

result.updateNull("ID");
result.updateString("Name", Name);
result.updateString("City", City);


result.insertRow();
result.moveToCurrentRow();

System.out.println("The student has been added.");
}

}

static void saveChanges(CachedRowSet rowset, Connection conn) {
answer = console.readLine("Do you want to save changes (Y/N)?: ");

if (answer.equalsIgnoreCase("Y")) {
try {
rowset.acceptChanges(conn);
} catch (SyncProviderException ex) {
System.out.println("Error commiting changes to the database: " + ex);
}
}
}

static void askToQuit() {
answer = console.readLine("Do you want to quit (Y/N)?: ");
quit = answer.equalsIgnoreCase("Y");
}
}