
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import DATABASE.Database;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadTextAsString {
    public static void main(String[] args)
            throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        Database db = new Database("new.db");
        Connection connection = db.getConnection();
        Statement statement = db.getStatement(connection);
        db.executeStatement("create table new_table (col_a int null)", statement);
        db.executeStatement("insert into new_table values(1),(2)", statement);
        ResultSet results = db.getResults("Select * from new_table", statement);
        while (results.next()) {
            System.out.println("col_a = " + results.getInt("col_a"));
        }

        InputStream inStream = new FileInputStream("../STATIC/ProgramFile.txt");
        BufferedReader inBuffer = new BufferedReader(new InputStreamReader(inStream));
        String line = inBuffer.readLine();
        while (line != null) {
            String tmp[] = line.split(",");
            String name = tmp[0];
            System.out.println(name);
            line = inBuffer.readLine();
        }
        inBuffer.close();
    }
}
