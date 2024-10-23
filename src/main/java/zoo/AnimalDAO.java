package zoo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {
    private Connection connection;

    public AnimalDAO(Connection connection) {
        this.connection = connection;
    }

    public void addAnimal(Animal animal) throws SQLException {
        String sql = "INSERT INTO animals (name, gender, birth_date, arrival_date, health_status, section_name, location, food) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, animal.getName());
            statement.setString(2, animal.getGender());
            statement.setDate(3, Date.valueOf(animal.getBirthDate()));
            statement.setDate(4, Date.valueOf(animal.getArrivalDate()));
            statement.setString(5, animal.getHealthStatus().getStatus());
            statement.setString(6, animal.getSection().getSectionName());
            statement.setString(7, animal.getSection().getLocation());
            statement.setString(8, animal.getFoodName());
            statement.executeUpdate();
        }
    }

    public List<Animal> getAllAnimals() throws SQLException {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM animals";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                // Використання Builder для створення об'єкта HealthStatus
                HealthStatus healthStatus = new HealthStatus.HealthStatusBuilder()
                        .setStatus(resultSet.getString("health_status"))
                        .build();

                // Використання Builder для створення об'єкта Section
                Section section = new Section.SectionBuilder()
                        .setSectionName(resultSet.getString("section_name"))
                        .setLocation(resultSet.getString("location"))
                        .build();

                Animal animal = new AnimalBuilder()
                        .setName(resultSet.getString("name"))
                        .setGender(resultSet.getString("gender"))
                        .setBirthDate(resultSet.getDate("birth_date").toString())
                        .setArrivalDate(resultSet.getDate("arrival_date").toString())
                        .setHealthStatus(healthStatus)
                        .setSection(section)
                        .setFoodName(resultSet.getString("food"))
                        .build();
                animals.add(animal);
            }
        }
        return animals;
    }
}
