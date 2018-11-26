package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    public String database_file_name = "";
    public Connection connection = null;

    public Database(String db_file) {
        this.database_file_name = db_file;
    }

    public Connection getConnection() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            // create a database connection
            String connectionString = "jdbc:sqlite:" + this.database_file_name;
            connection = DriverManager.getConnection(connectionString);
            System.out.println(connectionString);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        this.connection = connection;
        return connection;
    }

    public Statement getStatement(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return statement;
    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void executeStatement(String query, Statement statement) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public ResultSet getResults(String query, Statement statement) {
        ResultSet results = null;
        try {
            results = statement.executeQuery(query);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return results;
    }
}