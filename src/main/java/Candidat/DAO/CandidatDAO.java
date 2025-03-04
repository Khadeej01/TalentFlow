package Candidat.DAO;

import java.sql.*;
import Candidat.Models.Candidat;
import utils.DBConnection;

public class CandidatDAO {
    private Connection con;
public CandidatDAO() {
    con = DBConnection.getConnection();
}
}
