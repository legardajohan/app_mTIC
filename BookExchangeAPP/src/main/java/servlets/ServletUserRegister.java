package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UsuarioController;

@WebServlet("/ServletUserRegister")
public class ServletUserRegister extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    public ServletUserRegister() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        UsuarioController usuario = new UsuarioController();

        String username = request.getParameter("username");
        String contrasena = request.getParameter("contrasena");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        boolean premium = Boolean.parseBoolean(request.getParameter("premium"));

        String result = usuario.register(username, contrasena, nombre, apellidos, email, saldo, premium);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }


}
