package com.crea.dev4.ecole.inter.controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crea.dev4.ecole.inter.metier.ChambreMetier;
import com.crea.dev4.ecole.inter.metier.EleveMetier;

/**
 * Servlet implementation class ControleurPrincipal
 */
@WebServlet("/ControleurPrincipal")
public class ControleurPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pagejsp;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControleurPrincipal() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		pagejsp = "/WEB-INF/error.jsp";
		// Mettre en place une architecture d'un controleur unique
		// 0- On se base sur un accès unique par un test sur un paramï¿½tre
		// d'identification de la requï¿½te
		String idform = request.getParameter("idaction"); // a partir de chaque formulaire HTML/XHTML/JSTL/JSP

		switch (idform) {
		/**********************************************************
		 * Traitement métier pour les fonctionnalités de l'élève
		 *********************************************************/
		case "getelevebynum":
			pagejsp = EleveMetier.processGetEleveBynum(request);
			break;
		case "getelevesbychambreno":
			pagejsp = EleveMetier.processGetElevesByChambreNo(request);
			break;
		case "getelevesbydate":
			pagejsp = EleveMetier.processGetElevesByDateNaissance(request);
			break;
		case "getelevesbynom":
			pagejsp = EleveMetier.processGetElevesByNom(request);
			break;
		case "addEleve":
			pagejsp = EleveMetier.processAddEleve(request);
			break;
		case "deleteEleveBynum":
			pagejsp = EleveMetier.processDeleteEleve(request);
			break;
		case "getallEleves":
			pagejsp = EleveMetier.processGetAllEleves(request);
			break;
		case "updateeleve":
			pagejsp = EleveMetier.processUpdateEleve(request);
			break;
		/**********************************************************
		 * Traitement métier pour les fonctionnalités de la chambre
		 *********************************************************/
		case "addchambre":
			pagejsp = ChambreMetier.processAddChambre(request);
			break;

		case "getallChambres":
			pagejsp = ChambreMetier.processGetAllChambres(request);
			break;

		/**********************************************************
		 * Traitement métier pour les fonctionnalités du Livre
		 *********************************************************/
		// TD DO
		/**********************************************************
		 * Traitement métier pour les fonctionnalités de Uv
		 *********************************************************/
		// TD DO
		/**********************************************************
		 * Traitement métier pour les fonctionnalités de Inscrit
		 *********************************************************/
		// TD DO
		default:
			System.out.println("None selected");
		}

		// Confirmer le dispatching
		this.getServletContext().getRequestDispatcher(pagejsp).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
