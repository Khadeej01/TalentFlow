package Recruteur.ServletRec;

import Candidat.DAO.CandidatDAO;
import Candidat.Models.Candidat;
import Recruteur.DAORec.RecruteurDAO;
import Recruteur.ModelRec.Recruteur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/UpdateRecruteurServlet")
public class UpdateRecruteurServlet extends HttpServlet {
    private RecruteurDAO recruteurDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        recruteurDAO = new RecruteurDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nom = req.getParameter("nom");
        String email = req.getParameter("email");
        String entreprise = req.getParameter("entreprise");

        Recruteur recruteur = new Recruteur(id, nom, email,"", entreprise);
        boolean isUpdated = recruteurDAO.updateRecruteur(recruteur);

        if (isUpdated) {
            resp.sendRedirect("RecruiterList.jsp");
        } else {
            resp.sendRedirect("editRecruteur.jsp?id=" + id);
        }
    }
}