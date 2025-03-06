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
}