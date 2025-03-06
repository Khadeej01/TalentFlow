package Candidature.DAO;

import java.util.ArrayList;
import java.util.List;
import Candidature.Models.Candidature;
import java.sql.*;

import static utils.DBConnection.getConnection;

public class CandidatureDAO {

    // Récupérer tous les candidats depuis la base de données
    public List<Candidature> getAllCandidates() {
        List<Candidature> candidates = new ArrayList<>();
        String sql = "SELECT candidatId, nom, email, telephone, offreId, status FROM Users WHERE role = 'candidat'";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int candidatId = rs.getInt("candidatId");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                int offreId = rs.getInt("offreId");
                String status = rs.getString("status");

                candidates.add(new Candidature(candidatId, nom, email, telephone, offreId, status));
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des candidats : " + e.getMessage());
            e.printStackTrace();
        }

        return candidates;
    }

}
