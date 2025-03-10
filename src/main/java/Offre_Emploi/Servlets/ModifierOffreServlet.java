package Offre_Emploi.Servlets;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Offre_Emploi.DAO.OffreEmploiDAO;
import Offre_Emploi.Models.OffreEmploi;

@WebServlet("/ModifierOffreServlet")
public class ModifierOffreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            response.sendRedirect("offres.jsp"); // Redirige si pas d'ID
            return;
        }

        int id = Integer.parseInt(idParam);
        OffreEmploiDAO offreDAO = new OffreEmploiDAO();
        OffreEmploi offre = offreDAO.getOffreById(id);

        if (offre == null) {
            System.out.println(" ERREUR : Aucune offre trouvée avec l'id " + id);
            response.sendRedirect("modifier_offre.jsp"); // Redirige si offre non trouvée
            return;
        } else {
            System.out.println(" Offre trouvée : " + offre.getTitre());
        }

        request.setAttribute("offre", offre);
        request.getRequestDispatcher("modifier_offre.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titre = request.getParameter("titre");
        String description = request.getParameter("description");

        OffreEmploiDAO offreDAO = new OffreEmploiDAO();
        offreDAO.modifierOffre(id, titre, description);

        response.sendRedirect("offres.jsp");
    }
}

