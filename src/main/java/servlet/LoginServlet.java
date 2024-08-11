package servlet;

import constant.Pages;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = Pages.LOGIN_PAGE)
public class LoginServlet extends AuthServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher( Pages.LOGIN_PAGE+".jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String name = req.getParameter("username");
        String password = req.getParameter("password");

        List<User> users = userService.getAllUser();
        Optional<User> existedUser =
                users.stream()
                .filter( (user -> user.getName().equals(name)) )
                .filter(user-> encoder.matches(password,user.getPassword()))
                .findFirst();

        if(existedUser.isPresent()){
            session.setAttribute("userId",existedUser.get().getId());
            resp.sendRedirect(Pages.PRODUCTS_PAGE);
        }else {
            resp.sendRedirect(Pages.LOGIN_PAGE);
        }

    }
}
