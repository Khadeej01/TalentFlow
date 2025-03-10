package Recruteur.DAORec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Candidat.Models.Candidat;
import Recruteur.ModelRec.Recruteur;
import utils.DBConnection;

public class RecruteurDAO {



    public void registerRecruteur(Recruteur recruteur) {

        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO recruteurs (nom, email, password,  entreprise) VALUES (?, ?, ?, ?)";
            PreparedStatement stmnt = con.prepareStatement(query);
            stmnt.setString(1, recruteur.getNom());
            stmnt.setString(2, recruteur.getEmail());
            stmnt.setString(3, recruteur.getPassword());
            stmnt.setString(4, recruteur.getEntreprise());
            stmnt.executeUpdate() ;

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public Recruteur loginRecruteur(String email, String password) {

        Recruteur recruteur = null;
        try(Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM recruteurs WHERE email = ? AND password = ?";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.setString(1, email);
            stmnt.setString(2, password);
            ResultSet rs = stmnt.executeQuery();

            if (rs.next()) {
                recruteur = new Recruteur();
                recruteur.setId(rs.getInt("id"));
                recruteur.setNom(rs.getString("nom"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return recruteur;
    }

    public List<Recruteur> getAllRecruteurs() {
        List<Recruteur> recruteurs = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM recruteurs");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Recruteur recruteur = new Recruteur();
                recruteur.setId(rs.getInt("id"));
                recruteur.setNom(rs.getString("nom"));
                recruteur.setEmail(rs.getString("email"));
                recruteur.setEntreprise(rs.getString("entreprise"));
                recruteurs.add(recruteur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recruteurs;
    }

    public Recruteur getRecruteurById(int id) {
        Recruteur recruteur = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM recruteurs WHERE id = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    recruteur = new Recruteur();
                    recruteur.setId(rs.getInt("id"));
                    recruteur.setNom(rs.getString("nom"));
                    recruteur.setEmail(rs.getString("email"));
                    recruteur.setEntreprise(rs.getString("entreprise"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recruteur;
    }

    public boolean updateRecruteur(Recruteur recruteur) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE recruteurs SET nom=?, email=?, entreprise=? WHERE id=?")) {
            stmt.setString(1, recruteur.getNom());
            stmt.setString(2, recruteur.getEmail());
            stmt.setString(3, recruteur.getEntreprise());
            stmt.setInt(4, recruteur.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteRecruteur(int id) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM recruteurs WHERE id=?")) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}





//    public void addRecruteur(Recruteur recruteur) throws SQLException {
//
//        String query = "INSERT INTO Users (nom, email, password, role) VALUES (?, ?, ?, ?)";
//
//        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
//            statement.setString(1, recruteur.getNom());
//            statement.setString(2, recruteur.getEmail());
//            statement.setString(3, recruteur.getPassword());
//            statement.setString(4, recruteur.getEntreprise());
//            statement.setString(5, recruteur.getSecteur());
//
//            int rowsAffected =   statement.executeUpdate();
//
//
//            if (rowsAffected > 0) {
//                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//                    if (generatedKeys.next()) {
//                        recruteur.setId(generatedKeys.getInt(1));
//                    }
//                }
//            }
//        }
//    }



//    public Recruteur getRecruteurById(int id) throws SQLException {
//        String query = "SELECT * FROM Users WHERE id = ? AND role = 'recruteur'";
//
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                return mapResultSetToRecruteur(resultSet);
//            }
//        }
//        return null;
//    }


//    public Recruteur getRecruteurByEmail(String email) throws SQLException {
//        String query = "SELECT * FROM Users WHERE email = ? AND role = 'recruteur'";
//
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, email);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                return mapResultSetToRecruteur(resultSet);
//            }
//        }
//        return null;
//    }


//    public void updateRecruteur(Recruteur recruteur) throws SQLException {
//        String query = "UPDATE Users SET nom = ?, email = ?, password = ?, role = ?, entreprise = ?, secteur = ? WHERE id = ?";
//
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, recruteur.getNom());
//            statement.setString(2, recruteur.getEmail());
//            statement.setString(3, recruteur.getPassword());
//            statement.setString(4, recruteur.getRole());
//            statement.setString(5, recruteur.getEntreprise());
//            statement.setString(6, recruteur.getSecteur());
//            statement.setInt(7, recruteur.getId());
//
//            statement.executeUpdate();
//        }
//    }


//    public void deleteRecruteur(int id) throws SQLException {
//        String query = "DELETE FROM Users WHERE id = ? AND role = 'recruteur'";
//
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, id);
//            statement.executeUpdate();
//        }
//    }


//    private Recruteur mapResultSetToRecruteur(ResultSet resultSet) throws SQLException {
//        int id = resultSet.getInt("id");
//        String nom = resultSet.getString("nom");
//        String email = resultSet.getString("email");
//        String password = resultSet.getString("password");
//        String role = resultSet.getString("role");
//        String entreprise = resultSet.getString("entreprise");
//        String secteur = resultSet.getString("secteur");
//
//        return new Recruteur(id, nom, email, password, role, entreprise, secteur);
//    }
//}

