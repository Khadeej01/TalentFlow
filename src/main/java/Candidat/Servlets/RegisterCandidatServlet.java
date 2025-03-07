package Candidat.Servlets;

import Candidat.DAO.CandidatDAO;
import Candidat.Models.Candidat;
import User.DAO.userDAO;
import User.Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RegisterCandidat")
public class RegisterCandidatServlet extends HttpServlet {

private CandidatDAO candidatDAO = new CandidatDAO();
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

    String nom = req.getParameter("nom");
    String email = req.getParameter("email");
    String password = req.getParameter("password");
    String telephone = req.getParameter("telephone");
    String cv = req.getParameter("cv");

        Candidat candidat = new Candidat(nom,email,password,telephone,cv);
        CandidatDAO candidatdao = new CandidatDAO();

        candidatDAO.registerCandidat(candidat);
    }


}
