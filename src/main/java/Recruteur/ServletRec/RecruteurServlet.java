package Recruteur.ServletRec;

import Recruteur.DAORec.RecruteurDAO;
import Recruteur.ModelRec.Recruteur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
        import java.io.IOException;
import java.sql.*;

@WebServlet("/recruteur")
public class RecruteurServlet extends HttpServlet {

    private RecruteurDAO recruteurDAO;

    @Override
    public void init() throws ServletException {

        String jdbcUrl = "jdbc:mysql://localhost:3306/TalentFlowDB";
        String username = "root";
        String password = "Root@123";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            recruteurDAO = new RecruteurDAO(connection);
        } catch (SQLException e) {
            throw new ServletException("Database connection error.", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String entreprise = request.getParameter("entreprise");
        String secteur = request.getParameter("secteur");

        Recruteur recruteur = new Recruteur(nom, email, password, "recruteur", entreprise, secteur);

        try {
            recruteurDAO.addRecruteur(recruteur);
            response.sendRedirect("recruteur?id=" + recruteur.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding recruteur.");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                Recruteur recruteur = recruteurDAO.getRecruteurById(id);
                if (recruteur != null) {
                    request.setAttribute("recruteur", recruteur);
                    request.getRequestDispatcher("/recruteur-detail.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Recruteur not found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching recruteur.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Recruteur ID is required.");
        }
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                String nom = request.getParameter("nom");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String entreprise = request.getParameter("entreprise");
                String secteur = request.getParameter("secteur");

                Recruteur recruteur = new Recruteur(id, nom, email, password, "recruteur", entreprise, secteur);
                recruteurDAO.updateRecruteur(recruteur);
                response.sendRedirect("recruteur?id=" + id); // Rediriger vers la page du recruteur
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error updating recruteur.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Recruteur ID is required.");
        }
    }


    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                recruteurDAO.deleteRecruteur(id);
                response.sendRedirect("recruteurs");
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error deleting recruteur.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Recruteur ID is required.");
        }
    }
}
