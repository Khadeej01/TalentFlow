package Candidat.DAO;

import java.sql.*;
import Candidat.Models.Candidat;
import utils.DBConnection;

public class CandidatDAO {
    private Connection con;
public CandidatDAO() {
    con = DBConnection.getConnection();
}

public void registerCandidat(Candidat candidat) {

    try{
        String query = "insert into Candidats (nom,email,telephone,cv,password) values (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
