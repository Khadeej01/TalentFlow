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

@WebServlet("/RegisterRecruteur")
public class RegisterRecruteur extends HttpServlet {

    private RecruteurDAO recruteurDAO = new RecruteurDAO();
    @Override
    public void init() throws ServletException {
        super.init();
        recruteurDAO = new RecruteurDAO();
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
        String entreprise = req.getParameter("entreprise");


        Recruteur recruteur = new Recruteur(nom,email,password,entreprise);
        RecruteurDAO recruteurDAO = new RecruteurDAO();

        recruteurDAO.registerRecruteur(recruteur);
        resp.sendRedirect("Login.jsp");
    }


}

