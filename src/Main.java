import com.wbt.db.configuration.DatabaseConfig;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        final var dbManager = DriverManager.getConnection(DatabaseConfig.DATABASE_URL); // Can also pass username and password alongside
        final var statement = dbManager.createStatement();
        statement.execute(DatabaseConfig.createUserTable);
        // insert new user
        final var pStatement = dbManager.prepareStatement(DatabaseConfig.insertNewUser);
        pStatement.setString(1, "leonel ka");
        pStatement.setString(2, "wabo");
        pStatement.setString(3, "waboleonel@gmail.com");
        pStatement.setString(4, "(+237)681-592-765");
        int i = pStatement.executeUpdate();
        System.out.println("\t\t -------> " + i);
    }
}