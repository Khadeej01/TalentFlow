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

    public List<OffreEmploi> getAllOffers() {
        List<OffreEmploi> offres = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();
            if (conn == null) {
                System.out.println("Erreur : Connexion à la base de données échouée !");
                return offres;
            }

            String sql = "SELECT * FROM OffreEmploi";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                OffreEmploi offre = new OffreEmploi();
                offre.setTitre(rs.getString("titre"));
                offre.setDescription(rs.getString("description"));
                offre.setDatePublication(rs.getDate("date_publication").toLocalDate());
                offre.setRecruteurEmail(rs.getString("recruteur_email"));
                offre.setEntreprise(rs.getString("entreprise"));
                offres.add(offre);
            }

            System.out.println("Nombre d'offres récupérées : " + offres.size());

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return offres;
    }

    public OffreEmploi getOffreById(int id) {
        OffreEmploi offre = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM OffreEmploi WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                offre = new OffreEmploi(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (offre == null) {
            System.out.println(" Aucune offre trouvée avec l'id " + id);
        }
        return offre;
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
    public void supprimerOffre(int id) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM OffreEmploi WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierOffre(int id, String titre, String description) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE OffreEmploi SET titre = ?, description = ? WHERE id = ?")) {
            stmt.setString(1, titre);
            stmt.setString(2, description);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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


}

