package Offre_Emploi.DAO;

import Offre_Emploi.Models.OffreEmploi;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.mysql.cj.conf.PropertyKey.PASSWORD;
import static com.mysql.cj.conf.PropertyKey.USER;
import static jakarta.servlet.SessionTrackingMode.URL;

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

    public List<OffreEmploi> getAllOffres() throws SQLException {
        List<OffreEmploi> offres = new ArrayList<>();

        // Remplace ces valeurs par les informations de connexion réelles
        String url = "jdbc:mysql://localhost:3306/TalentFlow2";  // L'URL de ta base de données
        String user = "root";  // Utilisateur de ta base de données
        String password = "Root@123";  // Mot de passe de ta base de données

        String query = "SELECT * FROM offre_emploi";

        // Utilise ces chaînes de caractères pour établir la connexion
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String titre = rs.getString("titre");
                String description = rs.getString("description");
                String entreprise = rs.getString("entreprise");
                String localisation = rs.getString("localisation");
                Date datePublication = rs.getDate("date_publication");

                OffreEmploi offre = new OffreEmploi(id, titre, description, entreprise, localisation, datePublication);
                offres.add(offre);
            }
        }

        return offres;
    }

    public List<OffreEmploi> searchOffres(String keyword) throws SQLException {
        List<OffreEmploi> offres = new ArrayList<>();
        String sql = "SELECT * FROM offres WHERE titre LIKE ? OR entreprise LIKE ?";

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
        String sql = "SELECT * FROM offres WHERE date_publication = ?";

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


}

