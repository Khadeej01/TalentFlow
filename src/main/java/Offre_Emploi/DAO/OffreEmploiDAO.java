package Offre_Emploi.DAO;

import Offre_Emploi.Models.OffreEmploi;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OffreEmploiDAO {

    private Connection connection;

    public OffreEmploiDAO(Connection connection) {
        this.connection = connection;
    }

    public void addOffreEmploi(OffreEmploi offreEmploi) throws SQLException {
        String query = "INSERT INTO offre_emploi (titre, description, datePublication, recruteurEmail) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, offreEmploi.getTitre());
            statement.setString(2, offreEmploi.getDescription());
            statement.setDate(3, Date.valueOf(offreEmploi.getDatePublication())); // Conversion de LocalDate à java.sql.Date
            statement.setString(4, offreEmploi.getRecruteurEmail());

            statement.executeUpdate();
        }
    }

    public OffreEmploi getOffreEmploiById(int id) throws SQLException {
        String query = "SELECT * FROM offre_emploi WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToOffreEmploi(resultSet);
            }
        }
        return null;
    }


    public List<OffreEmploi> getAllOffresEmploi() throws SQLException {
        List<OffreEmploi> offresEmploi = new ArrayList<>();
        String query = "SELECT * FROM offre_emploi";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                offresEmploi.add(mapResultSetToOffreEmploi(resultSet));
            }
        }
        return offresEmploi;
    }


    public void updateOffreEmploi(OffreEmploi offreEmploi) throws SQLException {
        String query = "UPDATE offre_emploi SET titre = ?, description = ?, datePublication = ?, recruteurEmail = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, offreEmploi.getTitre());
            statement.setString(2, offreEmploi.getDescription());
            statement.setDate(3, Date.valueOf(offreEmploi.getDatePublication()));
            statement.setString(4, offreEmploi.getRecruteurEmail());
            statement.setInt(5, offreEmploi.getId());

            statement.executeUpdate();
        }
    }


    public void deleteOffreEmploi(int id) throws SQLException {
        String query = "DELETE FROM offre_emploi WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }


    private OffreEmploi mapResultSetToOffreEmploi(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String titre = resultSet.getString("titre");
        String description = resultSet.getString("description");
        LocalDate datePublication = resultSet.getDate("datePublication").toLocalDate();
        String recruteurEmail = resultSet.getString("recruteurEmail");

        return new OffreEmploi(id, titre, description, datePublication, recruteurEmail);
    }
}

