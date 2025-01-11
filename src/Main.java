import com.wbt.db.configuration.DatabaseConfig;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        final var dbManager = DriverManager.getConnection(DatabaseConfig.DATABASE_URL); // Can also pass username and password alongside
        final var statement = dbManager.createStatement();
        statement.execute(DatabaseConfig.createUserTable);
        // insert new user
        final var insertPrepareStatement = dbManager.prepareStatement(DatabaseConfig.insertNewUser);
        insertPrepareStatement.setString(1, "leonel ka");
        insertPrepareStatement.setString(2, "wabo");
        insertPrepareStatement.setString(3, "waboleonel@gmail.com");
        insertPrepareStatement.setString(4, "(+237)681-592-765");
        insertPrepareStatement.executeUpdate();

        // delete user
        final var deletePrepareStatement = dbManager.prepareStatement(DatabaseConfig.deleteUserById);
        deletePrepareStatement.setInt(1, 3);
        deletePrepareStatement.executeUpdate();

        // get user by Id
//        final var getUserByIdStatement = dbManager.prepareStatement(DatabaseConfig.selectUserById);
//        getUserByIdStatement.setInt(1,1);

    }
}