package Candidat.Servlets;

import Candidat.DAO.CandidatDAO;
import Candidat.Models.Candidat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateCandidatServlet")
public class UpdateCandidatServlet extends HttpServlet {
    private CandidatDAO candidatDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        candidatDAO = new CandidatDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nom = req.getParameter("nom");
        String email = req.getParameter("email");
        String telephone = req.getParameter("telephone");
        String cv = req.getParameter("cv");

        Candidat candidat = new Candidat(id, nom, email, "", telephone, cv);
        boolean isUpdated = candidatDAO.updateCandidat(candidat);

        if (isUpdated) {
            resp.sendRedirect("CandidatList.jsp");
        } else {
            resp.sendRedirect("editCandidat.jsp?id=" + id);
        }
    }
}