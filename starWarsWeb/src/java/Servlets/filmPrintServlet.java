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
        Film filmH = new Film(0, "Là-Haut","2010", 1, 1234.123, 6443.123);
        daoFilm.addFilm("films", filmH);
        daoFilm.listReadingConsole("SELECT * FROM films");
        daoFilm.deleteFilm("films", 67);
        ArrayList daoFilmList = new ArrayList();
        daoFilmList.addAll(daoFilm.listReadingArrayList("SELECT * FROM films"));
        print("\n[daoFilmList] : \n"+daoFilmList);
        daoFilm.close();
    
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet filmPrintServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet filmPrintServlet at " + request.getContextPath() + "</h1>");
            out.println("<HTML>\n<BODY>\n" +
				"<H1>Recapitulatif des informations</H1>\n" +
				"<UL>\n" +	
                                "  <LI>Id: "
				+ request.getParameter("id") + "\n" +
                                "  <LI>Titre: "
				+ request.getParameter("titre") + "\n" +
				"  <LI>Anée de sortie: "
				+ request.getParameter("anneeDeSortie") + "\n" +
				"  <LI>Numéro épisode: "
				+ request.getParameter("numEpisode") + "\n" +
                                "  <LI>Coût: "
				+ request.getParameter("cout") + "\n" +
                                "  <LI>Recette: "
				+ request.getParameter("recette") + "\n" +
				"</UL>\n");
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

}
