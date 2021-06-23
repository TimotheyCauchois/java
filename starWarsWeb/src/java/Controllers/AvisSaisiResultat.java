/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.DAOAvis;
import Controllers.DAOFilm;
import static Controllers.StarWars.print;
import Models.Avis;
import Models.Film;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AvisSaisiResultat", urlPatterns = {"/AvisSaisiResultat"})
public class AvisSaisiResultat extends HttpServlet {

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
            
            String result = "Aucun résultat.";               
            int avisId = 0;
            String avisTitre = "";
            String avisDescription = "";
            int avisNote = 0;
            Avis avisAAjouter = null;
            
            try {
                if(!request.getParameter("avisajoutvalider").isEmpty() && "Valider".equals(request.getParameter("avisajoutvalider"))){
                    print("Ajout d'un avis demandé.");
                    try {
                        avisTitre = request.getParameter("AvisTitre");
                        avisDescription = request.getParameter("AvisDescription");
                        avisNote = Integer.parseInt(request.getParameter("AvisNote"));
                    } catch (Exception e) {}
                    avisAAjouter = new Avis(0, avisTitre, avisDescription, avisNote);
                    DAOAvis daoAvis = new DAOAvis();
                    result = daoAvis.addAvis(avisAAjouter);
                    print(result);
                } else { result = "Ajout non effectué."; }
            } catch (Exception e) {}
            
            
            out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<title>Servlet AvisSaisiResultat</title>"
                    + "<link href=\"https://dev.ldumay.fr/resources/bootstrap/4.1.3/css/bootstrap.min.css\" rel=\"stylesheet\">"
                    + "<link href=\"https://dev.ldumay.fr/resources/bootstrap/4.1.3/css/bootstrap-grid.min.css\" rel=\"stylesheet\">"
                    + "</head>"
                    + "<body>"
                    + "<div class=\"container\">"
                    + "<div class=\"row\">"
                    + "<div class=\"col-12\">"
                    + "<h1>Résultat de l'ajout d'un avis <small style=\"font-size:16px;\"><a href=\"/starWarsWeb/\">[accueil]</a></small></h1>"
                    + "<hr>"
                    + ""+result+""
                    + "<br>"
                    + "<a href=\"/starWarsWeb/FilmListe\">Retour à la liste des films</a>"
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
            Logger.getLogger(AvisSaisiResultat.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AvisSaisiResultat.class.getName()).log(Level.SEVERE, null, ex);
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
