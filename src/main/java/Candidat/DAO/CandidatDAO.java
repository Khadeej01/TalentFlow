package Candidat.DAO;

import java.sql.*;
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
}