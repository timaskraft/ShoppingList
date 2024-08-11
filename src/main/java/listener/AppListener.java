package listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import constant.DataFiles;
import dao.ProductDAO;
import dao.UserDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import service.ProductService;
import service.UserService;

import javax.xml.crypto.Data;
import java.io.File;
import java.util.Objects;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext =  sce.getServletContext();

        ObjectMapper objectMapper = new ObjectMapper();

        File userFile = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(DataFiles.USERS)).getFile());
        File productFile = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(DataFiles.PRODUCTS)).getFile());

        System.out.println(userFile.getPath());

        UserDAO userDAO = new UserDAO(objectMapper,userFile);
        ProductDAO productDAO = new ProductDAO(objectMapper,productFile);

        UserService userService  = new UserService(userDAO);
        ProductService productService = new ProductService(productDAO);


        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        servletContext.setAttribute("userService",userService);
        servletContext.setAttribute("productService",productService);
        servletContext.setAttribute("encoder",encoder);


        System.out.println("App initialized.");



    }
}


