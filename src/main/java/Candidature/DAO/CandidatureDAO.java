package Candidature.DAO;

import java.util.ArrayList;
import java.util.List;
import Candidature.Models.Candidature;
import java.sql.*;

import static utils.DBConnection.getConnection;

public class CandidatureDAO {


    public List<Candidature> getAllCandidates() {
        List<Candidature> candidates = new ArrayList<>();
        String sql = "SELECT * FROM candidats ";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int candidatId = rs.getInt("id");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                String cv = rs.getString("cv");


                candidates.add(new Candidature(candidatId, nom, email, telephone,cv));
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des candidats : " + e.getMessage());
            e.printStackTrace();
        }

        return candidates;
    }

}
