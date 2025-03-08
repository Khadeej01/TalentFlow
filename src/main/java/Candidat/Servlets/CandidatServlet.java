package Candidat.Servlets;

import Candidat.DAO.CandidatDAO;
import Candidat.Models.Candidat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet ("/Candidat")
public class CandidatServlet extends HttpServlet {

    private CandidatDAO candidatDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        candidatDAO = new CandidatDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String telephone = req.getParameter("telephone");
        String cv = req.getParameter("cv");
        String password = req.getParameter("password");

        Candidat candidat = new Candidat(name, email, telephone, cv, password);
        CandidatDAO candidatDAO = new CandidatDAO();


    }


}
