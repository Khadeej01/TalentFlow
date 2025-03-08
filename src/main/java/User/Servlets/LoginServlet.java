
package User.Servlets;

import Candidat.Models.Candidat;
import Candidat.DAO.CandidatDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        CandidatDAO candidatDAO = new CandidatDAO();
        HttpSession session = req.getSession();

        Candidat candidat = candidatDAO.loginCandidat(email, password);
        if (candidat != null) {
            session.setAttribute("user", candidat);
            resp.sendRedirect("CandidatList.jsp");
        } else {
            req.setAttribute("errorMessage", "Invalid email or password!");
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
    }}
