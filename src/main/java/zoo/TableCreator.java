package zoo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class TableCreator {
    public static void createTables() {
        String createAnimalTable = "CREATE TABLE IF NOT EXISTS animals (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "gender VARCHAR(10), " +
                "birth_date DATE, " +
                "arrival_date DATE, " +
                "health_status VARCHAR(20), " +
                "section VARCHAR(50), " +
                "food_name VARCHAR(50))";

        try (Connection connection = DatabaseManager.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(createAnimalTable);
            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
