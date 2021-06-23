/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.DAOFilm;
import Models.Film;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AvisSaisi", urlPatterns = {"/AvisSaisi"})
public class AvisSaisi extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String listeFilm = "";
            DAOFilm films = new DAOFilm();
            ArrayList<Film> filmsTemp = new ArrayList();
            filmsTemp.addAll(films.listReadingArrayList());
            for(Film film : filmsTemp){
                listeFilm += "<option value=\""+film.getId()+"\">"+film.getTitre()+"</option>";
            }
            out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<title>Servlet AvisSaisi</title>"
                    + "<link href=\"https://dev.ldumay.fr/resources/bootstrap/4.1.3/css/bootstrap.min.css\" rel=\"stylesheet\">"
                    + "<link href=\"https://dev.ldumay.fr/resources/bootstrap/4.1.3/css/bootstrap-grid.min.css\" rel=\"stylesheet\">"
                    + "</head>"
                    + "<body>"
                    + "<div class=\"container\">"
                    + "<div class=\"row\">"
                    + "<div class=\"col-12\">"
                    + "<h1>Saisir un avis <small style=\"font-size:16px;\"><a href=\"/starWarsWeb/\">[accueil]</a></small></h1>"
                    + "<hr>"
                    +"<select class=\"form-select\" name=\"AvisFilmSelect\">"
                    +"<option selected>Choisissez le film</option>"
                    +""+listeFilm+""
                    +"</select>"
                    + "<form method=\"post\" action=\"AvisSaisiResultat\">"
                    + "<label for=\"basic-url\" class=\"form-label\">Nom de l'avis</label>"
                    + "<input type=\"texte\" class=\"form-control\" name=\"AvisTitre\" placeholder=\"(String)\"/>"
                    + "<br>"
                    + "<label for=\"basic-url\" class=\"form-label\">Description</label>"
                    + "<input type=\"texte\" class=\"form-control\" name=\"AvisDescription\" placeholder=\"(String)\"/>"
                    + "<br>"
                    + "<label for=\"basic-url\" class=\"form-label\">Note</label>"
                    + "<input type=\"texte\" class=\"form-control\" name=\"AvisNote\" placeholder=\"(int)\"/>"
                    + "<br>"
                    + "<input type=\"submit\" class=\"btn btn-success\" name=\"avisajoutvalider\" value=\"Valider\"/>"
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AvisSaisi.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AvisSaisi.class.getName()).log(Level.SEVERE, null, ex);
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