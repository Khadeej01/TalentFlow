package Candidat.Servlets;

import Candidat.DAO.CandidatDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteCandidatServlet")
public class DeleteCandidatServlet extends HttpServlet {
    private CandidatDAO candidatDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        candidatDAO = new CandidatDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean isDeleted = candidatDAO.deleteCandidat(id);

        if (isDeleted) {
            resp.sendRedirect("CandidatList.jsp");
        } else {
            resp.sendRedirect("CandidatList.jsp");
        }
    }
}