package servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import service.UserService;

public abstract class AuthServlet  extends HttpServlet {

    protected UserService userService;
    protected BCryptPasswordEncoder encoder;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ServletContext servletContext = config.getServletContext();

        userService = (UserService) servletContext.getAttribute("userService");

        System.out.println("userService:"+userService);

        encoder     = (BCryptPasswordEncoder) servletContext.getAttribute("encoder");
    }



}
