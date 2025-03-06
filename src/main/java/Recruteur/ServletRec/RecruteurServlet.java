package Recruteur.ServletRec;

import Recruteur.DAORec.RecruteurDAO;
import Recruteur.ModelRec.Recruteur;
import User.DAO.userDAO;
import User.Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/RecruteurServlet")
public class RecruteurServlet extends HttpServlet {

    private RecruteurDAO recruteurDAO;

//    @Override
//    public void init() throws ServletException {
//        // Initialiser le DAO avec une connexion à la base de données
//        Connection connection = DBConnection.getConnection();  // Assurez-vous d'avoir une méthode pour récupérer la connexion
//        recruteurDAO = new RecruteurDAO(connection);
//    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        try {
//            if (action != null) {
//                switch (action) {
//                    case "getById":
//                        getRecruteurById(request, response);
//                        break;
//                    case "getByEmail":
//                        getRecruteurByEmail(request, response);
//                        break;
//                    default:
//                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action non valide");
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de l'accès à la base de données");
//        }
//    }

//    private void getRecruteurById(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Recruteur recruteur = recruteurDAO.getRecruteurById(id);
//
//        if (recruteur != null) {
//            response.setContentType("application/json");
//            response.getWriter().write(recruteur.toString());
//        } else {
//            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Recruteur non trouvé");
//        }
//    }

//    private void getRecruteurByEmail(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//        String email = request.getParameter("email");
//        Recruteur recruteur = recruteurDAO.getRecruteurByEmail(email);
//
//        if (recruteur != null) {
//            response.setContentType("application/json");
//            response.getWriter().write(recruteur.toString());
//        } else {
//            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Recruteur non trouvé");
//        }
//    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            String nom = request.getParameter("nom");
//            String email = request.getParameter("email");
//            String password = request.getParameter("password");
//            String role = request.getParameter("role");
//            String entreprise = request.getParameter("entreprise");
//            String secteur = request.getParameter("secteur");
//
//            Recruteur recruteur = new Recruteur(nom, email, password, role, entreprise, secteur);
//            recruteurDAO.addRecruteur(recruteur);
//
//            response.setStatus(HttpServletResponse.SC_CREATED);
//            response.getWriter().write("Recruteur ajouté avec succès");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de l'ajout du recruteur");
//        }
//    }

//    @Override
//    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            int id = Integer.parseInt(request.getParameter("id"));
//            String nom = request.getParameter("nom");
//            String email = request.getParameter("email");
//            String password = request.getParameter("password");
//            String role = request.getParameter("role");
//            String entreprise = request.getParameter("entreprise");
//            String secteur = request.getParameter("secteur");
//
//            Recruteur recruteur = new Recruteur(id, nom, email, password, role, entreprise, secteur);
//            recruteurDAO.updateRecruteur(recruteur);
//
//            response.setStatus(HttpServletResponse.SC_OK);
//            response.getWriter().write("Recruteur mis à jour avec succès");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la mise à jour du recruteur");
//        }
//    }

//    @Override
//    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            int id = Integer.parseInt(request.getParameter("id"));
//            recruteurDAO.deleteRecruteur(id);
//
//            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
//            response.getWriter().write("Recruteur supprimé avec succès");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la suppression du recruteur");
//        }
//    }
}
