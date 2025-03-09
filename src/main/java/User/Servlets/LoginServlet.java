package User.Servlets;

import Candidat.Models.Candidat;
import Candidat.DAO.CandidatDAO;
import Recruteur.DAORec.RecruteurDAO;
import Recruteur.ModelRec.Recruteur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private CandidatDAO candidatDAO;
    private RecruteurDAO recruteurDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        candidatDAO = new CandidatDAO();
        recruteurDAO = new RecruteurDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        Candidat candidat = candidatDAO.loginCandidat(email, password);
        if (candidat != null) {
            session.setAttribute("user", candidat);
            resp.sendRedirect("CandidatList.jsp");
            return;
        }

        Recruteur recruteur = recruteurDAO.loginRecruteur(email, password);
        if (recruteur != null) {
            session.setAttribute("user", recruteur);
            resp.sendRedirect("RecruiterList.jsp");
            return;
        }

        req.setAttribute("errorMessage", "Invalid email or password!");
        req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }
}