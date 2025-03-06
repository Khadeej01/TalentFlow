package Recruteur.DAORec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Recruteur.ModelRec.Recruteur;
import java.sql.*;

public class RecruteurDAO {
    private Connection connection;


    public RecruteurDAO(Connection connection) {
        this.connection = connection;
    }


    public void addRecruteur(Recruteur recruteur) throws SQLException {

        String query = "INSERT INTO Users (nom, email, password, role) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, recruteur.getNom());
            statement.setString(2, recruteur.getEmail());
            statement.setString(3, recruteur.getPassword());
            statement.setString(4, recruteur.getRole());
            statement.setString(5, recruteur.getEntreprise());
            statement.setString(6, recruteur.getSecteur());

            int rowsAffected =  ²² statement.executeUpdate();


            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        recruteur.setId(generatedKeys.getInt(1));
                    }
                }
            }
        }
    }


    public Recruteur getRecruteurById(int id) throws SQLException {
        String query = "SELECT * FROM Users WHERE id = ? AND role = 'recruteur'";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToRecruteur(resultSet);
            }
        }
        return null;
    }


    public Recruteur getRecruteurByEmail(String email) throws SQLException {
        String query = "SELECT * FROM Users WHERE email = ? AND role = 'recruteur'";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToRecruteur(resultSet);
            }
        }
        return null;
    }


    public void updateRecruteur(Recruteur recruteur) throws SQLException {
        String query = "UPDATE Users SET nom = ?, email = ?, password = ?, role = ?, entreprise = ?, secteur = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, recruteur.getNom());
            statement.setString(2, recruteur.getEmail());
            statement.setString(3, recruteur.getPassword());
            statement.setString(4, recruteur.getRole());
            statement.setString(5, recruteur.getEntreprise());
            statement.setString(6, recruteur.getSecteur());
            statement.setInt(7, recruteur.getId());

            statement.executeUpdate();
        }
    }


    public void deleteRecruteur(int id) throws SQLException {
        String query = "DELETE FROM Users WHERE id = ? AND role = 'recruteur'";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }


    private Recruteur mapResultSetToRecruteur(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String nom = resultSet.getString("nom");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        String role = resultSet.getString("role");
        String entreprise = resultSet.getString("entreprise");
        String secteur = resultSet.getString("secteur");

        return new Recruteur(id, nom, email, password, role, entreprise, secteur);
    }
}

