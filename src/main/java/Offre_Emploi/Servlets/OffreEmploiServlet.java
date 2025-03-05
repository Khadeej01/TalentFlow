package Offre_Emploi.Servlets;

import Offre_Emploi.DAO.OffreEmploiDAO;
import Offre_Emploi.Models.OffreEmploi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
        import java.io.IOException;
import java.sql.*;
        import java.time.LocalDate;

@WebServlet("/offre-emploi")
public class OffreEmploiServlet extends HttpServlet {

    private OffreEmploiDAO offreEmploiDAO;

    @Override
    public void init() throws ServletException {

        String jdbcUrl = "jdbc:mysql://localhost:3306/TalentFlowDB";
        String username = "root";
        String password = "Root@123";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            offreEmploiDAO = new OffreEmploiDAO(connection);
        } catch (SQLException e) {
            throw new ServletException("Database connection error.", e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String titre = request.getParameter("titre");
        String description = request.getParameter("description");
        String datePublicationString = request.getParameter("datePublication");
        String recruteurEmail = request.getParameter("recruteurEmail");

        try {

            LocalDate datePublication = LocalDate.parse(datePublicationString);


            OffreEmploi offreEmploi = new OffreEmploi(titre, description, datePublication, recruteurEmail);


            offreEmploiDAO.addOffreEmploi(offreEmploi);


            response.sendRedirect("offre-emploi?id=" + offreEmploi.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding OffreEmploi.");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input data.");
        }
    }


    @Override
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
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "OffreEmploi not found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching OffreEmploi.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "OffreEmploi ID is required.");
        }
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                String titre = request.getParameter("titre");
                String description = request.getParameter("description");
                String datePublicationString = request.getParameter("datePublication");
                String recruteurEmail = request.getParameter("recruteurEmail");

                LocalDate datePublication = LocalDate.parse(datePublicationString);
                OffreEmploi offreEmploi = new OffreEmploi(id, titre, description, datePublication, recruteurEmail);
                offreEmploiDAO.updateOffreEmploi(offreEmploi);
                response.sendRedirect("offre-emploi?id=" + id);
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error updating OffreEmploi.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "OffreEmploi ID is required.");
        }
    }


    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                offreEmploiDAO.deleteOffreEmploi(id);
                response.sendRedirect("offres-emploi");
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error deleting OffreEmploi.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "OffreEmploi ID is required.");
        }
    }
}
