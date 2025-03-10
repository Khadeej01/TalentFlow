package Offre_Emploi.Servlets;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Offre_Emploi.DAO.OffreEmploiDAO;

@WebServlet("/SupprimerOffreServlet")
public class SupprimerOffreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            OffreEmploiDAO offreDAO = new OffreEmploiDAO();
            offreDAO.supprimerOffre(id);
        }

        response.sendRedirect("offres.jsp"); // Rediriger vers la page après suppression
    }
}

