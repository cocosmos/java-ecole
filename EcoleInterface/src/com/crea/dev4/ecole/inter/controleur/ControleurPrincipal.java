package com.crea.dev4.ecole.inter.controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crea.dev4.ecole.inter.metier.ChambreMetier;
import com.crea.dev4.ecole.inter.metier.EleveMetier;
import com.crea.dev4.ecole.inter.metier.UvMetier;

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
		// 0- On se base sur un acc�s unique par un test sur un param�tre
		// d'identification de la requ�te
		String idform = request.getParameter("idaction"); // a partir de chaque formulaire HTML/XHTML/JSTL/JSP

		switch (idform) {
		/**********************************************************
		 * Traitement m�tier pour les fonctionnalit�s de l'�l�ve
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
		case "updatechambrebyeleve":
			pagejsp = EleveMetier.processUpdateChambreByEleve(request);
			break;
		/**********************************************************
		 * Traitement m�tier pour les fonctionnalit�s de la chambre
		 *********************************************************/
		case "addchambre":
			pagejsp = ChambreMetier.processAddChambre(request);
			break;
		case "getallChambres":
			pagejsp = ChambreMetier.processGetAllChambres(request);
			break;
		case "getallChambresNoOccupied":
			pagejsp = ChambreMetier.processGetAllChambresNoOccupied(request);
			break;
		case "deleteChambre":
			pagejsp = ChambreMetier.processDeleteChambre(request);
			break;
		case "updatePrixChambre":
			pagejsp = ChambreMetier.processUpdatePrixChambre(request);
			break;
		case "searchChambre":
			pagejsp = ChambreMetier.processGetChambreByNo(request);
			break;
		case "getChambresByPrice":
			pagejsp= ChambreMetier.processGetChambreByPrice(request);
			break;
		case "getChambreByEleveNum":
			pagejsp= ChambreMetier.processGetChambreByEleveNum(request);
			break;
			
		/**********************************************************
		 * Traitement metier pour les fonctionnalites de Uv
		 *********************************************************/
		case "getAllUv":
			pagejsp= UvMetier.processGetAllUv(request);
			break;
		case "getUvByCode":
			pagejsp = UvMetier.processGetUvByCode(request);
			break;
		case "getUvByNbhSuperior":
			pagejsp = UvMetier.processGetUvByNbhSuperior(request);
			break;
		case "updateUvNbh":
			pagejsp= UvMetier.processUpdateUvNbh(request);
			break;
		case "updateUvCoord":
			pagejsp= UvMetier.processUpdateUvCoord(request);
			break;
		case "deleteUv":
			pagejsp= UvMetier.processDeleteUv(request);
			break;
			
			
		/**********************************************************
		 * Traitement metier pour les fonctionnalites du Livre
		 *********************************************************/
		// TD DO
			
			
			
			
		
		
			
			
			
		
		/**********************************************************
		 * Traitement m�tier pour les fonctionnalites de Inscrit
		 *********************************************************/
		// TD DO
		default:
			pagejsp= "/index.jsp";
			System.out.println("None selected");
			break;
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
