package com.crea.dev4.ecole.inter.metier;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.crea.dev4.ecole.model.beans.Chambre;
import com.crea.dev4.ecole.model.dao.ChambreDao;

public class ChambreMetier {

	/* Add Chambre */
	public static String processAddChambre(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String addornot = "not added";
		int num = Integer.parseInt(request.getParameter("nochambre"));

		Chambre chambreToFind = ChambreDao.getChambreByNo(num);

		if (chambreToFind == null) {
			Float prix = Float.parseFloat(request.getParameter("prixchambre"));
			Chambre chambreNew = new Chambre(num, prix);
			int code = ChambreDao.addChambre(chambreNew);
			System.out.println("COde de l'opération : " + code);
			if (code == 1) {
				addornot = "Chambre " + chambreNew.getNo() + " ajouté avec succes !!";
				request.setAttribute("txtconfirmationsearch", addornot);
				pagejsp = "/confirmation.jsp";
			}
		} else {
			request.setAttribute("txterro", "Erreur Chambre Existante");
			pagejsp = "/addchambre.jsp";
		}

		return pagejsp;

	}

	/**
	 * Get all chambres
	 * 
	 * @param request message
	 * @return page
	 */

	public static String processGetAllChambres(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Chambre> allchambres = new ArrayList<Chambre>();
		allchambres = ChambreDao.getAllChambres();

		request.setAttribute("allchambres", allchambres);
		pagejsp = "/allchambre.jsp";
		return pagejsp;
	}

	/**
	 * Get all chambres no occupied
	 * 
	 * @param request
	 * @return
	 */

	public static String processGetAllChambresNoOccupied(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Chambre> allchambres = new ArrayList<Chambre>();
		allchambres = ChambreDao.getChambresNoOccupied();

		request.setAttribute("allchambres", allchambres);
		pagejsp = "/allchambre.jsp";
		return pagejsp;
	}

	/**
	 * Search a chambre by No
	 * 
	 * @param request no chambre
	 * @return result page
	 */
	public static String processGetChambreByNo(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		int nochambre = Integer.parseInt(request.getParameter("nochambre"));
		String foundornot = "La chambre n°" + nochambre + " not found";

		Chambre findchambre = ChambreDao.getChambreByNo(nochambre);
		if (findchambre != null && findchambre.getNo() == nochambre) {
			foundornot = "La chambre n°" + findchambre.getNo() + " prix : " + findchambre.getPrix() + " CHF is found";
		}
		request.setAttribute("txtresult", foundornot);
		pagejsp = "/foundornot.jsp";
		return pagejsp;

	}

	/**
	 * Delete a chambre by no
	 * 
	 * @param request no of chambre
	 * @return pages allchambreform with message
	 */

	public static String processDeleteChambre(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String deleteornot = "Erreur : un eleve est assigné à cette chambre";
		int num = Integer.parseInt(request.getParameter("nochambre")); // a partir de chaque formulaire
																		// HTML/XHTML/JSTL/JSP
		Chambre chambreToFind = ChambreDao.getChambreByNo(num);

		if (chambreToFind == null) {
			request.setAttribute("txterro", "Erreur Chambre Inexistant");
			pagejsp = "/allchambreform.jsp";
		} else {
			int code = ChambreDao.deleteChambreByNo(num);
			System.out.println("Code de l'opération : " + code + " no " + num);
			if (code == 1) {
				deleteornot = "La chambre " + chambreToFind.getNo() + " a été supprimé !!";
			}
			request.setAttribute("txtconfirmation", deleteornot);
			pagejsp = "/allchambreform.jsp";
		}
		return pagejsp;
	}

	/**
	 * Update price room
	 * 
	 * @param request no chambre and new price
	 * @return page all chambre form with message
	 */
	public static String processUpdatePrixChambre(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String updatedornot = "not updated";
		int no = Integer.parseInt(request.getParameter("nochambre"));
		Float newPrix = Float.parseFloat(request.getParameter("prixchambre"));
		int code = 0;

		Chambre chambreToFind = ChambreDao.getChambreByNo(no);

		if (chambreToFind == null) {
			request.setAttribute("txterro", "Erreur Chambre Inexistant");
			pagejsp = "/allchambreform.jsp";
		} else {

			code = ChambreDao.updateChambrePriceByNo(no, newPrix);
			updatedornot = "Le prix de la chambre numéro " + no + " a été changé de " + chambreToFind.getPrix() + " en "
					+ newPrix;
			request.setAttribute("txtconfirmation", updatedornot);
			pagejsp = "/allchambreform.jsp";
		}
		return pagejsp;

	}

}
