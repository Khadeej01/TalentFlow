
package Candidature.Servlets;
import Candidature.DAO.CandidatureDAO;
import Candidature.Models.Candidature;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/")
public class CandidatureServlet extends HttpServlet {
    private CandidatureDAO candidatureDAO;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        candidatureDAO = new CandidatureDAO();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Candidature> candidatures = candidatureDAO.getAllCandidates();
        req.setAttribute("candidatures", candidatures);
        RequestDispatcher dispatcher = req.getRequestDispatcher("CandidatList.jsp");
        dispatcher.forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);

    }


}