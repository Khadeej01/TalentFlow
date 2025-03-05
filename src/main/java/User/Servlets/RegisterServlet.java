package User.Servlets;

import User.DAO.userDAO;
import User.Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

private userDAO userdao = new userDAO();
    @Override
    public void init() throws ServletException {
        super.init();
        userdao = new userDAO();
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
    String role = req.getParameter("role");

        User user = new User(nom,email,password,role);
        userDAO userdao = new userDAO();

        userdao.registerUser(user);
    }


}
