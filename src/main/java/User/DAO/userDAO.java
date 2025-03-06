package User.DAO;

import User.Models.User;
import utils.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userDAO {

    private Connection con;
    private static final String SelectAllUsers ="select * from Users";
    public userDAO() {
        con = DBConnection.getConnection();
    }
    public void registerUser( User user){
        try{
        String query = "INSERT INTO Users(nom,email,password,role) VALUES(?,?,?,?)";
        PreparedStatement stmnt = con.prepareStatement(query);
        stmnt.setString(1, user.getNom());
        stmnt.setString(2, user.getEmail());
        stmnt.setString(3, user.getPassword());
        stmnt.executeUpdate();



        } catch(SQLException e){
        e.printStackTrace();}
    }

    public static List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();
        try{

            Connection con = DBConnection.getConnection();
            PreparedStatement stmnt = con.prepareStatement(SelectAllUsers);
            ResultSet rs = stmnt.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setNom(rs.getString("nom"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));

                users.add(user);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);

        }return  users;
    }
}
