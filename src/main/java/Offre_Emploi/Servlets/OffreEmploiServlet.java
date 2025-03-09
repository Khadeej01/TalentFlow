package Offre_Emploi.Servlets;

import Offre_Emploi.DAO.OffreEmploiDAO;
import Offre_Emploi.Models.OffreEmploi;
import utils.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/offre-emploi")
public class OffreEmploiServlet extends HttpServlet {
    private OffreEmploiDAO offreEmploiDAO;

    @Override
    public void init() {
        try {
            Connection connection = DBConnection.getConnection();
            offreEmploiDAO = new OffreEmploiDAO();
        } catch (Exception e) {
            throw new RuntimeException("Erreur de connexion à la base de données", e);
        }
    }

    // 🔹 Ajouter une offre d'emploi (POST)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String titre = request.getParameter("titre");
            String description = request.getParameter("description");
            String recruteurEmail = request.getParameter("recruteurEmail");
            String entreprise = request.getParameter("entreprise");
            LocalDate datePublication = LocalDate.parse(request.getParameter("datePublication"));

            OffreEmploi offreEmploi = new OffreEmploi(titre, description, datePublication, recruteurEmail, entreprise);
            offreEmploiDAO.addOffreEmploi(offreEmploi);

            response.sendRedirect("offres.jsp?success=true");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("offres.jsp?error=true");
        }
    }

    // 🔹 Récupérer une offre spécifique (GET)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                OffreEmploi offreEmploi = offreEmploiDAO.getOffreEmploiById(id);
                if (offreEmploi != null) {
                    request.setAttribute("offreEmploi", offreEmploi);
                    request.getRequestDispatcher("/offre-emploi-detail.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Offre d'emploi non trouvée.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la récupération.");
            }
        } else {
            try {
                List<OffreEmploi> offres = offreEmploiDAO.getAllOffresEmploi();
                request.setAttribute("offresEmploi", offres);
                request.getRequestDispatcher("/offres.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la récupération.");
            }
        }
    }

    // 🔹 Modifier une offre (PUT)
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String titre = request.getParameter("titre");
            String description = request.getParameter("description");
            LocalDate datePublication = LocalDate.parse(request.getParameter("datePublication"));
            String recruteurEmail = request.getParameter("recruteurEmail");
            String entreprise = request.getParameter("entreprise");

            OffreEmploi offreEmploi = new OffreEmploi(id, titre, description, datePublication, recruteurEmail, entreprise);
            offreEmploiDAO.updateOffreEmploi(offreEmploi);

            response.sendRedirect("offre-emploi?id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la modification.");
        }
    }

    // 🔹 Supprimer une offre (DELETE)
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            offreEmploiDAO.deleteOffreEmploi(id);
            response.sendRedirect("offres.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la suppression.");
        }
    }
}
