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


@WebServlet(name = "FilmSaisiResultat", urlPatterns = {"/FilmSaisiResultat"})
public class FilmSaisiResultat extends HttpServlet {

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
            
            int filmId = 0;
            String filmTitre = "";
            String filmAnneeDeSortie = "";
            int filmNumEpisode = 0;
            double filmCout = 0;
            double filmRecette = 0;
            Film filmAAjouter = null;
            
            int avisId = 0;
            String avisTitre = "";
            String avisDescription = "";
            int avisNote = 0;
            Avis avisAAjouter = null;
            
            try {
                if(!request.getParameter("add").isEmpty() && "Valider".equals(request.getParameter("add"))){
                    print("Ajout d'un film demandé.");
                    try {
                        filmTitre = request.getParameter("FilmTitre");
                        filmAnneeDeSortie = request.getParameter("FilmAnneeDeSortie");
                        filmNumEpisode = Integer.parseInt(request.getParameter("FilmNumEpisode"));
                        filmCout = Double.parseDouble(request.getParameter("FilmCout"));
                        filmRecette = Double.parseDouble(request.getParameter("FilmRecette"));
                    } catch (Exception e) {}
                    filmAAjouter = new Film(0, filmTitre, filmAnneeDeSortie, filmNumEpisode, filmCout, filmRecette);
                    DAOFilm daoFilm = new DAOFilm();
                    result = daoFilm.addFilm(filmAAjouter);
                    print(result);
                } else { result = "Ajout non effectué."; }
            } catch (Exception e) {}
            try{
                if(!request.getParameter("update").isEmpty() && "Update".equals(request.getParameter("update"))){
                    print("Mise à jour d'un film demandé.");
                    try {
                        filmId = Integer.parseInt(request.getParameter("FilmId"));
                        filmTitre = request.getParameter("FilmTitre");
                        filmAnneeDeSortie = request.getParameter("FilmAnneeDeSortie");
                        filmNumEpisode = Integer.parseInt(request.getParameter("FilmNumEpisode"));
                        filmCout = Double.parseDouble(request.getParameter("FilmCout"));
                        filmRecette = Double.parseDouble(request.getParameter("FilmRecette"));
                    } catch (Exception e) {}
                    filmAAjouter = new Film(filmId, filmTitre, filmAnneeDeSortie, filmNumEpisode, filmCout, filmRecette);
                    DAOFilm daoFilm = new DAOFilm();
                    result = daoFilm.updateFilm(filmAAjouter);
                    print(result);
                } else { result = "Mise à jour non effectué."; }
            } catch (Exception e) {}
            
            out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<title>Servlet FilmSaisiResultat</title>"
                    + "<link href=\"https://dev.ldumay.fr/resources/bootstrap/4.1.3/css/bootstrap.min.css\" rel=\"stylesheet\">"
                    + "<link href=\"https://dev.ldumay.fr/resources/bootstrap/4.1.3/css/bootstrap-grid.min.css\" rel=\"stylesheet\">"
                    + "</head>"
                    + "<body>"
                    + "<div class=\"container\">"
                    + "<div class=\"row\">"
                    + "<div class=\"col-12\">"
                    + "<h1>Résultat de l'ajout d'un film <small style=\"font-size:16px;\"><a href=\"/starWarsWeb/\">[accueil]</a></small></h1>"
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
            Logger.getLogger(FilmSaisiResultat.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FilmSaisiResultat.class.getName()).log(Level.SEVERE, null, ex);
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
