package animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {
    private Connection connection;

    public AnimalDAO(Connection connection) {
        this.connection = connection;
    }


    public void insertAnimal(Animal animal) {
        String sql = "INSERT INTO animals (name, species) VALUES (?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, animal.getName());
            pstmt.setString(2, animal.getSpecies());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }



    public List<Animal> selectAllAnimals() {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM animals";

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("name");
                String species = rs.getString("species");

                animals.add(new Animal(name, species));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return animals;
    }


    public void updateAnimalCommand(Animal animal, String command) {
        String sql = "UPDATE animals SET commands = ? WHERE name = ? AND species = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, command);
            pstmt.setString(2, animal.getName());
            pstmt.setString(3, animal.getSpecies());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
