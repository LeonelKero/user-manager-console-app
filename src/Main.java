import com.wbt.db.configuration.DatabaseConfig;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        final var dbManager = DriverManager.getConnection(DatabaseConfig.DATABASE_URL); // Can also pass username and password alongside
        final var statement = dbManager.createStatement();
        statement.execute(DatabaseConfig.CREATE_USER_TABLE_QUERY);

        // insert new user
//        final var insertPrepareStatement = dbManager.prepareStatement(DatabaseConfig.insertNewUser);
//        insertPrepareStatement.setString(1, "leonel ka");
//        insertPrepareStatement.setString(2, "wabo");
//        insertPrepareStatement.setString(3, "waboleonel@gmail.com");
//        insertPrepareStatement.setString(4, "(+237)681-592-765");
//        insertPrepareStatement.execute();

        // delete user
//        final var deletePrepareStatement = dbManager.prepareStatement(DatabaseConfig.deleteUserById);
//        deletePrepareStatement.setInt(1, 3);
//        deletePrepareStatement.executeUpdate();

        // get user by Id
//        final var getUserByIdStatement = dbManager.prepareStatement(DatabaseConfig.selectUserById);
//        getUserByIdStatement.setInt(1,1);

        // get all users
        final var resultSet = statement.executeQuery(DatabaseConfig.selectAll);
        while (resultSet.next()) { // loop through the result set
            var id = resultSet.getInt("id");
            var firstname = resultSet.getString("firstname");
            var lastname = resultSet.getString("lastname");
            var email = resultSet.getString("email");
            var phone = resultSet.getString("phone");
            System.out.println("\t{\n\t\t id: " + id + "\n\t\t firstname: " + firstname + "\n\t\t lastname: " + lastname
                    + "\n\t\t email: " + email + "\n\t\t phone: " + phone + "\n\t},");
        }

        // get user via email - same goes for id
        final var selectRequestStatement = dbManager.prepareStatement(DatabaseConfig.selectUserByEmail);
        selectRequestStatement.setString(1, "waboleonel@gmail.com");
        final var executedQuery = selectRequestStatement.executeQuery();
        if (executedQuery.next()) System.out.println("\n\t ==> This user exist.");

        // update user details
//        final var updateRequestStatement = dbManager.prepareStatement(DatabaseConfig.updateUser);
//        updateRequestStatement.setString(1, "leonel");
//        updateRequestStatement.setString(2, "wabo kanmogne");
//        updateRequestStatement.setInt(3, 1);
//        if (updateRequestStatement.executeUpdate() == 1) System.out.println("\n\t ==> User data updated!.");
    }
}