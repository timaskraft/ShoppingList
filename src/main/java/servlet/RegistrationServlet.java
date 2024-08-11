package servlet;

import constant.Pages;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = Pages.REGISTRATION_PAGE)
public class RegistrationServlet extends AuthServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher(Pages.REGISTRATION_PAGE+".jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("username");
        String password = encoder.encode(req.getParameter("password"));

        userService.save(
                User.builder()
                        .id(UUID.randomUUID())
                        .name(name)
                        .password(password)
                        .build()
        );

        resp.sendRedirect(Pages.LOGIN_PAGE);

    }


}
