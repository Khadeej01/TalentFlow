package Candidat.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Candidat.Models.Candidat;
import utils.DBConnection;

public class CandidatDAO {

    public void registerCandidat(Candidat candidat) {

        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO Candidats (nom, email, password,  telephone, cv) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmnt = con.prepareStatement(query);
            stmnt.setString(1, candidat.getNom());
            stmnt.setString(2, candidat.getEmail());
            stmnt.setString(3, candidat.getPassword());
            stmnt.setString(4, candidat.getTelephone());
            stmnt.setString(5, candidat.getCv());
            stmnt.executeUpdate() ;

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public Candidat loginCandidat(String email, String password) {

        Candidat candidat = null;
        try(Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM Candidats WHERE email = ? AND password = ?";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.setString(1, email);
            stmnt.setString(2, password);
            ResultSet rs = stmnt.executeQuery();

            if (rs.next()) {
                candidat = new Candidat();
                candidat.setId(rs.getInt("id"));
                candidat.setNom(rs.getString("nom"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return candidat;
    }

    public Candidat getCandidatById(int id) {
        Candidat candidat = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Candidats WHERE id = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    candidat = new Candidat();
                    candidat.setId(rs.getInt("id"));
                    candidat.setNom(rs.getString("nom"));
                    candidat.setEmail(rs.getString("email"));
                    candidat.setTelephone(rs.getString("telephone"));
                    candidat.setCv(rs.getString("cv"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidat;
    }

    public List<Candidat> getAllCandidats() {
        List<Candidat> candidats = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Candidats");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Candidat candidat = new Candidat();
                candidat.setId(rs.getInt("id"));
                candidat.setNom(rs.getString("nom"));
                candidat.setEmail(rs.getString("email"));
                candidat.setTelephone(rs.getString("telephone"));
                candidat.setCv(rs.getString("cv"));
                candidats.add(candidat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidats;
    }

    public boolean updateCandidat(Candidat candidat) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE Candidats SET nom=?, email=?, telephone=?, cv=? WHERE id=?")) {
            stmt.setString(1, candidat.getNom());
            stmt.setString(2, candidat.getEmail());
            stmt.setString(3, candidat.getTelephone());
            stmt.setString(4, candidat.getCv());
            stmt.setInt(5, candidat.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCandidat(int id) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM Candidats WHERE id=?")) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}