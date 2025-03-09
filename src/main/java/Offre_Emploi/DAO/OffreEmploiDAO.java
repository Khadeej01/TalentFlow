package Offre_Emploi.DAO;

import Offre_Emploi.Models.OffreEmploi;
import utils.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static utils.DBConnection.getConnection;

public class OffreEmploiDAO {

    private Connection connection;

    public OffreEmploiDAO() {
        this.connection = DBConnection.getConnection();
    }

    public void addOffreEmploi(OffreEmploi offreEmploi) throws SQLException {
        String query = "INSERT INTO OffreEmploi (titre, description, recruteur_email) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, offreEmploi.getTitre());
            statement.setString(2, offreEmploi.getDescription());
            statement.setString(3, offreEmploi.getRecruteurEmail()); // Correction ici

            statement.executeUpdate();
        }
    }



    public OffreEmploi getOffreEmploiById(int id) throws SQLException {
        String query = "SELECT * FROM OffreEmploi WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToOffreEmploi(resultSet);
            }
        }
        return null;
    }
    public int getRecruteurIdByEmail(String email) throws SQLException {
        String query = "SELECT id FROM Recruteurs WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1; // Retourne -1 si le recruteur n'existe pas
    }

    public List<OffreEmploi> getAllOffresEmploi() throws SQLException {
        List<OffreEmploi> offresEmploi = new ArrayList<>();
        String query = "SELECT * FROM OffreEmploi";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                offresEmploi.add(mapResultSetToOffreEmploi(resultSet));
            }
        }
        return offresEmploi;
    }

    public void updateOffreEmploi(OffreEmploi offreEmploi) throws SQLException {
        String query = "UPDATE OffreEmploi SET titre = ?, description = ?, date_publication = ?, recruteur_email = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, offreEmploi.getTitre());
            statement.setString(2, offreEmploi.getDescription());
            statement.setDate(3, Date.valueOf(offreEmploi.getDatePublication()));
            statement.setString(4, offreEmploi.getRecruteurEmail()); // Correction ici
            statement.setInt(5, offreEmploi.getId());

            statement.executeUpdate();
        }
    }



    public void deleteOffreEmploi(int id) throws SQLException {
        String query = "DELETE FROM OffreEmploi WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    private OffreEmploi mapResultSetToOffreEmploi(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String titre = resultSet.getString("titre");
        String description = resultSet.getString("description");
        LocalDate datePublication = resultSet.getDate("date_publication").toLocalDate();
        String recruteurEmail = resultSet.getString("recruteur_email"); // Correction ici

        return new OffreEmploi(id, titre, description, datePublication, recruteurEmail);
    }


    public List<OffreEmploi> getAllOffres() throws SQLException {
        List<OffreEmploi> offres = new ArrayList<>();

        // Remplace ces valeurs par les informations de connexion réelles
        String url = "jdbc:mysql://localhost:3306/TalentFlow2";  // L'URL de ta base de données
        String user = "root";  // Utilisateur de ta base de données
        String password = "Root@123";  // Mot de passe de ta base de données

        String query = "SELECT * FROM OffreEmploi";

        // Utilise ces chaînes de caractères pour établir la connexion
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String titre = rs.getString("titre");
                String description = rs.getString("description");
                String entreprise = rs.getString("entreprise");

                Date datePublication = rs.getDate("date_publication");

                OffreEmploi offre = new OffreEmploi(id, titre, description, entreprise, datePublication);
                offres.add(offre);
            }
        }

        return offres;
    }

    public List<OffreEmploi> searchOffres(String keyword) throws SQLException {
        List<OffreEmploi> offres = new ArrayList<>();
        String sql = "SELECT * FROM OffreEmploi WHERE titre LIKE ? OR entreprise LIKE ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                offres.add(new OffreEmploi(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("description"),
                        rs.getDate("date_publication").toLocalDate(),
                        rs.getString("entreprise")
                ));
            }
        }
        return offres;
    }

    public List<OffreEmploi> filterOffresByDate(String date) throws SQLException {
        List<OffreEmploi> offres = new ArrayList<>();
        String sql = "SELECT * FROM OffreEmploi WHERE date_publication = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(date));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                offres.add(new OffreEmploi(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("description"),
                        rs.getDate("date_publication").toLocalDate(),
                        rs.getString("entreprise")
                ));
            }
        }
        return offres;
    }


    public List<OffreEmploi> getAllOffers() {
        List<OffreEmploi> offreEmploiList = new ArrayList<>();

        // SQL query to select all offers
        String query = "SELECT titre, description, date_publication, recruteur_email, entreprise FROM offre_emploi";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // Loop through the result set
            while (rs.next()) {
                String titre = rs.getString("titre");
                String description = rs.getString("description");
                Date datePublication = rs.getDate("date_publication");
                String recruteurEmail = rs.getString("recruteur_email");
                String entreprise = rs.getString("entreprise");

                // Create a new OffreEmploi object and add it to the list
                OffreEmploi offreEmploi = new OffreEmploi(
                        titre,
                        description,
                        datePublication.toLocalDate(),
                        recruteurEmail,
                        entreprise
                );
                offreEmploiList.add(offreEmploi);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception appropriately
        }

        return offreEmploiList;
    }
}

