package jdbc_practice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtility {

    static final String DB_URL = "jdbc:sqlserver://;servername=ISW-230601-1355;instanceName=SQLEXPRESS;encrypt=false;integratedSecurity=true;";

    static  String QUERY = "SELECT id, first, last, age " + "FROM Registration";

    static  final String selectStudentQuery = "SELECT * FROM studentRecords";

    static  List<Column> studentCols = new ArrayList<>();
//    public static void createDatabase(String databaseName) {
//        // Open a connection
//        try(Connection conn = DriverManager.getConnection(DB_URL);
//            Statement statement = conn.createStatement()
//        ) {
//            String sql = "IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = " +
//                    "'" + databaseName + "') CREATE DATABASE "
//                    + databaseName + ";";
//            statement.executeUpdate(sql);
//            System.out.println("Database created successfully.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void createTable(String databaseName) {
//        // Open a connection
//        try(Connection conn = DriverManager.getConnection(DB_URL + "databaseName="+databaseName+";");
//            Statement statement = conn.createStatement()
//        ) {
//            String sql = "IF OBJECT_ID(N'dbo.REGISTRATION', N'U') " + "IS NULL " +
//                    "CREATE TABLE REGISTRATION " +
//                    "(id INT not NULL  IDENTITY(1,1), " +
//            " first VARCHAR(50), " +
//            " last VARCHAR(50), " +
//            " age INT, " +
//            "PRIMARY KEY ( id ))";
//            statement.executeUpdate(sql);
//            System.out.println("Created table in a given database");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    public static void insertRecords(String databaseName) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL + "databaseName="+databaseName+";");
            Statement statement = conn.createStatement()
        ) {
            // Execute a query
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO contact VALUES " + "('Zara', 'Ali', '')";
            statement.executeUpdate(sql);
            sql = "INSERT INTO Registration VALUES " + "('Mahnaz', 'Fatma', 25)";
            statement.executeUpdate(sql);
            sql = "INSERT INTO Registration VALUES " + "('Zaid', 'Khan', 30)";
            statement.executeUpdate(sql);
            sql = "INSERT INTO Registration VALUES " + "('Sumit', 'Mittal', 28)";
            statement.executeUpdate(sql);
            System.out.println("Inserted records into table in a given database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void selectRegistration(String databaseName) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL + "databaseName="+databaseName+";");
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(QUERY);
        ) {
            while (results.next()) {
                // Display values
                System.out.println("ID: " + results.getInt("id"));
                System.out.println(", Age: " + results.getInt("age"));
                System.out.println(", First: " + results.getString("first"));
                System.out.println(", Last: " + results.getString("last"));
                System.out.println("Printing out values from database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateAge(String databaseName) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL + "databaseName="+databaseName+";");
            Statement statement = conn.createStatement();
        ) {
            String sql = "UPDATE Registration " +
                    "SET age = 22 WHERE id in (5,6)";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println(", Age: " + resultSet.getInt("age"));
                System.out.println(", First: " + resultSet.getString("first"));
                System.out.println(", Last: " + resultSet.getString("last"));
                System.out.println("Updating values in database");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteRecord(String databaseName) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL + "databaseName="+databaseName+";");
            Statement statement = conn.createStatement();
        ) {
            String sql = "DELETE  FROM Registration " +
                    "WHERE id = 5";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()) {
                // Display values
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println(", Age: " + resultSet.getInt("age"));
                System.out.println(", First: " + resultSet.getString("first"));
                System.out.println(", Last: " + resultSet.getString("last"));
                System.out.println("Deleting values in database");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectWithoutAndWithIDGreaterThanOrEqualToFive(String databaseName) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL + "databaseName="+databaseName+";");
            Statement statement = conn.createStatement();
        ) {
            String sql = "SELECT * FROM Registration";

            ResultSet results = statement.executeQuery(sql);
            while (results.next()) {
                // Display values
                System.out.println("Printing without condition from database");
                System.out.println("ID: " + results.getInt("id"));
                System.out.println(", Age: " + results.getInt("age"));
                System.out.println(", First: " + results.getString("first"));
                System.out.println(", Last: " + results.getString("last"));

            }

            System.out.println();
            sql = "SELECT * FROM Registration " +
                    "WHERE id >= 6";
            results = statement.executeQuery(sql);
            while (results.next()) {
                // Display values
                System.out.println("Printing with id greater than or equal to 6 from database");
                System.out.println("ID: " + results.getInt("id"));
                System.out.println(", Age: " + results.getInt("age"));
                System.out.println(", First: " + results.getString("first"));
                System.out.println(", Last: " + results.getString("last"));
//                System.out.println("Printing out values from database");
            }
            results.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectRecordsWithFirstNameContainsZA(String databaseName) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL + "databaseName="+databaseName+";");
            Statement statement = conn.createStatement();
        ) {
            String sql = "SELECT * FROM Registration " +
                    "WHERE first LIKE '%ZA%'";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println(", Age: " + resultSet.getInt("age"));
                System.out.println(", First: " + resultSet.getString("first"));
                System.out.println(", Last: " + resultSet.getString("last"));
                System.out.println("Updating values in database");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectRecordsSortByFirstName(String databaseName) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL + "databaseName="+databaseName+";");
            Statement statement = conn.createStatement();
        ) {
            String sql = "SELECT * FROM Registration " +
                    "ORDER BY first";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.printf("ID: %s", resultSet.getString("id"));
                System.out.println();
                System.out.printf(", Age: %s", resultSet.getString("age"));
                System.out.println();
                System.out.println(", First: " + resultSet.getString("first"));
                System.out.println(", Last: " + resultSet.getString("last"));
                System.out.println("Updating values in database");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropDatabase(String databaseName) {
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL + "databaseName=" + databaseName + ";");
             Statement statement = conn.createStatement();
        ) {
            String sql = "DROP DATABASE IF EXISTS " + databaseName + ";";
            statement.executeUpdate(sql);
            System.out.println("Database dropped successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable(String databaseName) {
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL + "databaseName=" + databaseName + ";");
             Statement statement = conn.createStatement();
        ) {
            String sql = "DROP TABLE IF EXISTS REGISTRATION";
            statement.executeUpdate(sql);
            System.out.println("Table dropped successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectStudentRecords(String databaseName, String queryString, List<Column> columnList) {
        try(Connection conn = DriverManager.getConnection(DB_URL + "databaseName=" + databaseName + ";");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(queryString);
            ) {
            // Extract data from result set
            while (resultSet.next()) {
                // Retrieve by column name
                for (Column column: columnList) {
                    if (column.getType().equalsIgnoreCase("Integer")) {
                        System.out.println(column.getLabel().concat(": ")
                                .concat(""+resultSet.getInt(column.getName())).concat(", "));
                    } else if (column.getType().equalsIgnoreCase("String")) {
                        System.out.println(column.getLabel().concat(": ")
                                .concat(resultSet.getString(column.getName())).concat(", "));
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Column studentId = new Column("Integer", "ID", "id");
        Column studentCode = new Column("String", "Code", "course_code");
        Column studentName = new Column("String", "Name", "name");

        studentCols.add(studentId);
        studentCols.add(studentCode);
        studentCols.add(studentName);
      selectStudentRecords("Training", selectStudentQuery, studentCols);
//        createDatabase("TrainingDB");
//        createTable("TrainingDB");
//        insertRecords("TrainingDB");
//        selectRegistration("TrainingDB");
//        updateAge("TrainingDB");
//        deleteRecord("TrainingDB");
//        selectRecordsSortByFirstName("TrainingDB");
//        selectRecordsWithFirstNameContainsZA("TrainingDB");
//        selectWithoutAndWithIDGreaterThanOrEqualToFive("TrainingDB");
    }
}
