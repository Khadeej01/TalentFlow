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
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

//@WebServlet("/liste-offres")
//public class ListeOffresServlet extends HttpServlet {
//    private OffreEmploiDAO offreEmploiDAO;
//
//    @Override
//    public void init() {
//        try {
//            // Connexion via DBConnection
//            Connection conn = DBConnection.getConnection();
//            offreEmploiDAO = new OffreEmploiDAO();
//        } catch (Exception e) {
//            throw new RuntimeException("Erreur de connexion à la base de données", e);
//        }
//    }
//
//    // 🔹 Afficher la liste des offres d'emploi (GET)
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<OffreEmploi> offres = null;
//
//        try {
//            offres = offreEmploiDAO.getAllOffresEmploi();
//            // Utilisation du DAO pour récupérer les offres
//
//
//            for (OffreEmploi offre : offres) {
//                request.setAttribute("datePub_" + offre.getId(),
//                        Date.from(offre.getDatePublication().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la récupération des offres.");
//            return;
//        }
//
//        // Ajouter les offres au contexte de la requête pour les afficher dans la JSP
//        request.setAttribute("offres", offres);
//        request.getRequestDispatcher("offres-emploi.jsp").forward(request, response);
//    }
//}

@WebServlet("/liste-offres")
public class ListeOffresServlet extends HttpServlet {
    private OffreEmploiDAO offreEmploiDAO;

    @Override
    public void init() throws ServletException {
        try {
            offreEmploiDAO = new OffreEmploiDAO();
        } catch (Exception e) {
            throw new ServletException("Erreur d'initialisation du DAO", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<OffreEmploi> offres = offreEmploiDAO.getAllOffresEmploi();

            // Conversion des dates pour la JSP
            for (OffreEmploi offre : offres) {
                if (offre.getDatePublication() != null) {
                    Date datePub = Date.from(offre.getDatePublication()
                            .atStartOfDay(ZoneId.systemDefault())
                            .toInstant());
                    request.setAttribute("datePub_" + offre.getId(), datePub);
                }
            }

            request.setAttribute("offres", offres);
            request.getRequestDispatcher("/offres-emploi.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Erreur lors de la récupération des offres: " + e.getMessage());
        }
    }
}