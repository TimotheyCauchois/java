/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "FilmSaisi", urlPatterns = {"/FilmSaisi"})
public class FilmSaisi extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<title>Servlet FilmSaisi</title>"
                    + "<link href=\"https://dev.ldumay.fr/resources/bootstrap/4.1.3/css/bootstrap.min.css\" rel=\"stylesheet\">"
                    + "<link href=\"https://dev.ldumay.fr/resources/bootstrap/4.1.3/css/bootstrap-grid.min.css\" rel=\"stylesheet\">"
                    + "</head>"
                    + "<body>"
                    + "<div class=\"container\">"
                    + "<div class=\"row\">"
                    + "<div class=\"col-12\">"
                    + "<h1>Saisir un film <small style=\"font-size:16px;\"><a href=\"/starWarsWeb/\">[accueil]</a></small></h1>"
                    + "<hr>"
                    + "<form method=\"post\" action=\"FilmSaisiResultat\">"
                    + "<label for=\"basic-url\" class=\"form-label\">Nom du film</label>"
                    + "<input type=\"texte\" class=\"form-control\" name=\"FilmTitre\" placeholder=\"(String)\"/>"
                    + "<br>"
                    + "<label for=\"basic-url\" class=\"form-label\">Année de sortie du film</label>"
                    + "<input type=\"texte\" class=\"form-control\" name=\"FilmAnneeDeSortie\" placeholder=\"(String)\"/>"
                    + "<br>"
                    + "<label for=\"basic-url\" class=\"form-label\">Numéro du film</label>"
                    + "<input type=\"texte\" class=\"form-control\" name=\"FilmNumEpisode\" placeholder=\"(int)\"/>"
                    + "<br>"
                    + "<label for=\"basic-url\" class=\"form-label\">Coût du film</label>"
                    + "<input type=\"texte\" class=\"form-control\" name=\"FilmCout\" placeholder=\"(double)\"/>"
                    + "<br>"
                    + "<label for=\"basic-url\" class=\"form-label\">Recette du film</label>"
                    + "<input type=\"texte\" class=\"form-control\" name=\"FilmRecette\" placeholder=\"(double)\"/>"
                    + "<br>"
                    + "<input type=\"submit\" class=\"btn btn-success\" name=\"add\" value=\"Valider\"/>"
                    + "</form>"
                    + "</div>"
                    + "</div>"
                    + "</div>"
                    + "</body>"
                    + "</html>"
                    + "");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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