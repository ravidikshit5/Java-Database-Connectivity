import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableRSetCount {

public static void main(String[] args) {
String url = "jdbc:mysql://localhost:3306/mca";
String username = "root";
String password = "SONYindia59830@";


try (Connection conn = DriverManager.getConnection(url, username, password)) {

String sql = "SELECT * FROM student";

Statement statement = conn.createStatement(
ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);





/*

* An insensitive scrollable result set is one where the values captured in the

* result set never change, even if changes are made to the table from which the

* data was retrieved.

* A sensitive scrollable result set is one where the current values in the table

* are reflected in the result set. So if a change is made to a row in the table,

* the result set will show the new data when the cursor is moved to that row

*/


// Create an insensitive scrollable result set (for sensitive scrollable result sets use ResultSet.TYPE_SCROLL_SENSITIVE directive)

//Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

ResultSet results = statement.executeQuery(sql);


// Get cursor position

System.out.println("Cursor position " + results.getRow() + ", is before first ? " + results.isBeforeFirst());


// Every call to next() moves cursor to the next row - in this case the first row

results.next();


// Get cursor position

System.out.println("Cursor position " + results.getRow() + ", is first ? " + results.isFirst());


// A call to last() moves cursor to the last row; the row number is also the row count

results.last();


// Get cursor position

System.out.println("Cursor position " + results.getRow() + ", is last ? " + results.isLast());


// A call to after last moves cursor past last row (before first row)

results.afterLast();


// Get cursor position

System.out.println("Cursor position " + results.getRow() + ", is after last ? " + results.isAfterLast());


// Move cursor to the third row

results.absolute(3);


// Get cursor position

System.out.println("Cursor position " + results.getRow());


// Move cursor to the last row

results.absolute(-1);


// Get cursor position

System.out.println("Cursor position " + results.getRow() + ", is last ? " + results.isLast());


// Move cursor to the forth last row

results.absolute(-4);


// Get cursor position

System.out.println("Cursor position " + results.getRow());


// Move cursor down 5 rows from the current row. If this moves

// cursor beyond the last row, cursor is put after the last row

results.relative(5);


// Get cursor position

System.out.println("Cursor position " + results.getRow() + ", is after last ? " + results.isAfterLast());


// Move cursor up 13 rows from the current row. If this moves

// cursor beyond the first row, cursor is put before the first row

results.relative(-13);


// Get cursor position

System.out.println("Cursor position " + results.getRow() + ", is before first ? " + results.isBeforeFirst());


} catch (SQLException e) {

System.out.println("Could not retrieve data from the database " + e.getMessage());

}

}
}