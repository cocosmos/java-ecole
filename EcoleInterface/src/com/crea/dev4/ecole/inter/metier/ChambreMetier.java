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
			System.out.println("COde de l'op�ration : " + code);
			if (code == 1) {
				addornot = "Chambre " + chambreNew.getNo() + " ajout� avec succes !!";
				request.setAttribute("txtconfirmationadd", addornot);
				pagejsp = "/confirmation.jsp";
			}
		} else {
			request.setAttribute("txterro", "Erreur Chambre Existante");
			pagejsp = "/addchambre.jsp";
		}

		return pagejsp;

	}

	public static String processGetAllChambres(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Chambre> allchambres = new ArrayList<Chambre>();
		allchambres = ChambreDao.getAllChambres();

		request.setAttribute("allchambres", allchambres);
		pagejsp = "/allchambre.jsp";
		return pagejsp;
	}

	public static String processDeleteChambre(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String deleteornot = "Erreur : un eleve est assign� � cette chambre";
		int num = Integer.parseInt(request.getParameter("nochambre")); // a partir de chaque formulaire
																		// HTML/XHTML/JSTL/JSP
		Chambre chambreToFind = ChambreDao.getChambreByNo(num);

		if (chambreToFind == null) {
			request.setAttribute("txterro", "Erreur Chambre Inexistant");
			pagejsp = "/allchambreform.jsp";
		} else {
			int code = ChambreDao.deleteChambreByNo(num);
			System.out.println("Code de l'op�ration : " + code + " no " + num);
			if (code == 1) {
				deleteornot = "La chambre " + chambreToFind.getNo() + " a �t� supprim� !!";
			}
			request.setAttribute("txtconfirmation", deleteornot);
			pagejsp = "/allchambreform.jsp";
		}
		return pagejsp;
	}

	public static String processUpdatePrixChambre(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String updatedornot = "not updated";
		int num = Integer.parseInt(request.getParameter("nochambre"));
		Float newPrix = Float.parseFloat(request.getParameter("prixchambre"));
		int code = 0;

		Chambre chambreToFind = ChambreDao.getChambreByNo(num);

		if (chambreToFind == null) {
			request.setAttribute("txterro", "Erreur Chambre Inexistant");
			pagejsp = "/allchambreform.jsp";
		} else {

			code = ChambreDao.updateChambrePriceByNo(num, newPrix);
			updatedornot = "Le prix de la chambre num�ro " + num + " a �t� chang� de " + chambreToFind.getPrix()
					+ " en " + newPrix;
			request.setAttribute("txtconfirmation", updatedornot);
			pagejsp = "/allchambreform.jsp";
		}
		return pagejsp;

	}

}
