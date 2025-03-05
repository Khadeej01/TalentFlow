package Candidature.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Candidature.DAO.CandidatureDAO;
import com.google.gson.Gson;

@WebServlet("/CandidatureServlet")
public class CandidatureServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CandidatureDAO candidatureDAO = new CandidatureDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();

        String action = request.getParameter("action");
        int candidatureId, candidatId, offreId;
        boolean success = false;

        if ("postuler".equals(action)) {
            candidatId = Integer.parseInt(request.getParameter("candidatId"));
            offreId = Integer.parseInt(request.getParameter("offreId"));
            Candidature newCandidature = candidatureDAO.postuler(candidatId, offreId);
            response.getWriter().write(gson.toJson(newCandidature));

        } else if ("modifier".equals(action)) {
            candidatureId = Integer.parseInt(request.getParameter("candidatureId"));
            offreId = Integer.parseInt(request.getParameter("offreId"));
            success = candidatureDAO.modifierCandidature(candidatureId, offreId);
            response.getWriter().write("{\"success\":" + success + "}");

        } else if ("retirer".equals(action)) {
            candidatureId = Integer.parseInt(request.getParameter("candidatureId"));
            success = candidatureDAO.retirerCandidature(candidatureId);
            response.getWriter().write("{\"success\":" + success + "}");
        }
    }
}
