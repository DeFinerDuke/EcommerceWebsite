/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BenNguyen
 */
public class AddAddressController extends HttpServlet {
    private static final String SHOWADDRESSCONTROLLER = "AddressController";
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
          HttpSession session = request.getSession();
          String username = (String)session.getAttribute("USERNAME");
          String FullName = request.getParameter("txtFullname");
          String PhoneNumber = request.getParameter("txtPhonenumber");
          String City = request.getParameter("txtCity");
          String District = request.getParameter("txtDistrict");
          String Ward = request.getParameter("txtWard");
          String StreetNameAndHouseNo = request.getParameter("txtStreetnamehouseno");
          String Label = request.getParameter("txtLabel");
          String Default = request.getParameter("txtDefault");
          String url = null;
          UserDAO dao = new UserDAO();
          boolean result = dao.AddAddress(FullName, PhoneNumber, City, District, Ward, StreetNameAndHouseNo, Label, Default, username);
          try {
              if (result){
                  url = "user?action=Addresses";
              } else {
                  
              }
          } catch (Exception ex){
              ex.getMessage();
          }
          RequestDispatcher dist = request.getRequestDispatcher(url);
          dist.forward(request, response);
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

}
