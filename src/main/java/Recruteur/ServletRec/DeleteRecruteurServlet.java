package Recruteur.ServletRec;

import Candidat.DAO.CandidatDAO;
import Recruteur.DAORec.RecruteurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/DeleteRecruteurServlet")
public class DeleteRecruteurServlet extends HttpServlet {
    private RecruteurDAO recruteurDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        recruteurDAO = new RecruteurDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean isDeleted = recruteurDAO.deleteRecruteur(id);

        if (isDeleted) {
            resp.sendRedirect("RecruiterList.jsp");
        } else {
            resp.sendRedirect("RecruiterList.jsp");
        }
    }
}