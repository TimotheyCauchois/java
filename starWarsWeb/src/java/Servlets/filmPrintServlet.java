/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import starwars.Film;
import starwars.DAOFilm;
import static starwars.StarWars.print;

/**
 *
 * @author timot
 */
public class filmPrintServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            DAOFilm daoFilm = new DAOFilm();

          
            ArrayList daoFilmList = new ArrayList();
            daoFilmList.addAll(daoFilm.listReadingArrayList("SELECT * FROM films"));
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet filmPrintServlet</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">"
                    + "<div class=\"row\">"
                    + "<div class=\"col-12\">"
                  
                    + "                    <table class=\"table\">"
                    + "                    <thead>"
                    + "                    <tr>"
                    + "                    <th scope=\"col\">Id</th>"
                    + "                    <th scope=\"col\">Titre</th>"
                    + "                    <th scope=\"col\">Année</th>"
                    + "                    <th scope=\"col\">Numéro de l'épisode</th>"
                    + "                    <th scope=\"col\">Coût</th>"
                    + "                    <th scope=\"col\">Recette</th>"
                    + "                    </tr>"
                    + "                    </thead>"
                    + "                    <tbody>");

                    for (Iterator it = daoFilmList.iterator(); it.hasNext();) {
                    Film film = (Film) it.next();
                    out.println(""
                    +"<tr>"
                    +"<th scope=\"row\">"+film.getId()+"</th>"
                    +"<td>"+film.getTitre()+"</td>"
                    +"<td>"+film.getAnneeDeSortie()+"</td>"
                    +"<td>"+film.getNumEpisode()+"</td>"
                    +"<td>"+film.getCout()+"</td>"
                    +"<td>"+film.getRecette()+"</td>"
                    
                    +"</tr>");
                                }
                                
                    out.println(""
                    + "</tbody>"
                    + "</table>"
                    + "</div>"
                    + "</div>"
                    + "</div>"
                    + "</body>"
                    + "</html>"
                    + "");
                   
                    daoFilm.close();
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(filmPrintServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(filmPrintServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
