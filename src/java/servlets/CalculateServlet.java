/*
Copyright 2015 Drew Bryant and Patrick Lathan
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.Calculator;

/**
 *
 * @author drewbryant
 */
@WebServlet(name = "CalculateServlet", urlPatterns = {"/calculate"})
public class CalculateServlet extends HttpServlet {
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
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet CalculateServlet</title>");      
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet CalculateServlet at " + request.getContextPath() + "</h1>");
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
    String message = "";
    String url = "/index.html";
    
    String action = request.getParameter("action");
    
    if(action == null){
      action = "enter";
    }
    if(action.equals("enter")){
      url = "/index.html";
    }
    if(action.equals("calculate")){
      String amountString = request.getParameter("amount");
      String rateString = request.getParameter("rate");
      String yearsString = request.getParameter("years");
      double amount;
      double rate;
      int years;
      
      if(amountString == null || amountString.isEmpty() || rateString == null
              || rateString.isEmpty() || yearsString == null || 
              yearsString.isEmpty()){
        message = "Please fill out all 3 fields";
        url = "/index.html";
      }
      try{
        amount = Double.parseDouble(amountString);
        if(amount < 0){
          amount = 0;
        }
        rate = Double.parseDouble(rateString);
        if(rate < 0){
          rate = 0;
        }
        years = Integer.parseInt(yearsString);
        if(years < 0){
          years = 0;
        }
      } catch (NumberFormatException nfe){
        message = "Please put a positive number in all 3 fields";
        url = "/index.html";
        return;
      }
      
      Calculator calc = new Calculator(amount, rate, years);
      double futureAmount = calc.calculate();
      
      request.setAttribute("futureAmount", futureAmount);
      request.setAttribute("message", message);
      request.setAttribute("calc", calc);
      
      System.out.println(futureAmount);
      
      url = "/calculate.jsp";
    }
    getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
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
}
