/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.meservice.Calservice_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author arpit
 */
public class calServelet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WebApplication1/calservice.wsdl")
    private Calservice_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            double num1, num2;
            num1 =Double.parseDouble(request.getParameter("number1"));
            num2 =Double.parseDouble(request.getParameter("number2"));
            /* double num1 = Double.parseDouble(request.getParameter("number1"));
        double num2 = Double.parseDouble(request.getParameter("number2"));
        String operation = request.getParameter("operation");

        double result = 0;
        String opName = "";

        switch (operation) {
            case "add":
                result = addition(num1, num2);
                opName = "Addition";
                break;
            case "sub":
                result = substraction(num1, num2);
                opName = "Subtraction";
                break;
            case "mul":
                result = multiplication(num1, num2);
                opName = "Multiplication";
                break;
            case "div":
                result = division(num1, num2);
                opName = "Division";
                break;
            default:
                opName = "Invalid Operation";
                break;
        }
*/
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>calculator</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Addition is: " + addition(num1, num2) + "</h1>");
            out.println("<h1>Substraction is: " + substraction(num1, num2) + "</h1>");
            out.println("<h1>Multiplication is: " + multiplication(num1, num2) + "</h1>");
            out.println("<h1>Division is: " + division(num1, num2) + "</h1>");
            /* out.println("<h1>" + opName + " Result: " + result + "</h1>"); */
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private double addition(double num1, double num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.meservice.Calservice port = service.getCalservicePort();
        return port.addition(num1, num2);
    }

    private double division(double num1, double num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.meservice.Calservice port = service.getCalservicePort();
        return port.division(num1, num2);
    }

    private double multiplication(double num1, double num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.meservice.Calservice port = service.getCalservicePort();
        return port.multiplication(num1, num2);
    }

    private double substraction(double num1, double num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.meservice.Calservice port = service.getCalservicePort();
        return port.substraction(num1, num2);
    }

}
