package servlet;

import constant.Pages;
import entity.Product;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ProductService;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = Pages.PRODUCTS_PAGE)
public class ProductServlet extends HttpServlet {

    private ProductService productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        productService = (ProductService) servletContext.getAttribute("productService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Product> allProducts = productService.getAllProducts();
        List<Product> userProducts = allProducts.stream()
                .filter(product -> product.getUserId().equals(session.getAttribute("userId")))
                .collect(Collectors.toList());

        req.setAttribute("userProducts", userProducts);
        req.getRequestDispatcher(Pages.PRODUCTS_PAGE+".jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String imageUrl = req.getParameter("imageUrl");

        HttpSession session = req.getSession();

        productService.create(Product.builder()
                .id(UUID.randomUUID())
                .name(name)
                .userId( (UUID) session.getAttribute("userId"))
                .imageUrl(imageUrl)
                .build()
        );

        resp.sendRedirect(Pages.PRODUCTS_PAGE);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID productId = UUID.fromString( req.getParameter("productId") );

        productService.delete(productId);

        resp.sendRedirect(Pages.PRODUCTS_PAGE);
    }
}
