package Candidat.DAO;

import java.sql.*;
import Candidat.Models.Candidat;
import utils.DBConnection;

public class CandidatDAO {

    public static boolean AddCandidat(Candidat candidat) {

        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO Users (nom, email, password, role, telephone, cv) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, candidat.getNom());
            ps.setString(2, candidat.getEmail());
            ps.setString(3, candidat.getPassword());
            ps.setString(4, "Candidat");
            ps.setString(5, candidat.getTelephone());
            ps.setString(6, candidat.getCv());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}