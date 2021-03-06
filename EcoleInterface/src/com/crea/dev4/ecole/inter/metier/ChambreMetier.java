package com.crea.dev4.ecole.inter.metier;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.crea.dev4.ecole.model.beans.Chambre;
import com.crea.dev4.ecole.model.beans.Eleve;
import com.crea.dev4.ecole.model.dao.ChambreDao;
import com.crea.dev4.ecole.model.dao.EleveDao;

/**
 * Chambre Metier
 * 
 * @author Mipam
 * 
 */

public class ChambreMetier {

	/**
	 * Add a new Chambre
	 * 
	 * @param request a new no of chambre and price
	 * @return check if fieds are null and add new chambre and return success or
	 *         error
	 */
	public static String processAddChambre(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String addornot = "not added";
		String nochambre = request.getParameter("nochambre");
		String nprix = request.getParameter("prixchambre");
		Float newPrix = 0.0f;

		if (nochambre.equals("") || nprix.equals("")) {
			addornot = "Error Cannot be null";
		} else {
			int no = Integer.parseInt(nochambre);
			Chambre chambreToFind = ChambreDao.getChambreByNo(no);

			if (chambreToFind == null) {
				newPrix = Float.parseFloat(nprix);
				Chambre chambreNew = new Chambre(no, newPrix);
				int code = ChambreDao.addChambre(chambreNew);

				System.out.println("COde de l'operation : " + code);

				if (code == 1) {
					addornot = "Chambre " + chambreNew.getNo() + " ajoute avec succes !!";
					request.setAttribute("successornot", "success");
				}
			} else if (chambreToFind != null) {
				addornot = "Erreur Chambre Existante";
			}
		}

		request.setAttribute("txterro", addornot);
		pagejsp = "/addchambre.jsp";

		return pagejsp;
	}

	/**
	 * Get all chambres
	 * 
	 * @param request all chambres
	 * @return all chambres if not empty
	 */

	public static String processGetAllChambres(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Chambre> allchambres = new ArrayList<Chambre>();
		allchambres = ChambreDao.getAllChambres();

		if (allchambres.isEmpty()) {
			request.setAttribute("txterro", "No Chambre founded");
			pagejsp = "/allchambreform.jsp";
		} else {
			request.setAttribute("allchambres", allchambres);
			pagejsp = "/allchambre.jsp";
		}
		return pagejsp;
	}

	/**
	 * Get all chambres no occupied
	 * 
	 * @param request all chambres
	 * @return all chambre where eleve is null
	 */

	public static String processGetAllChambresNoOccupied(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Chambre> allchambres = new ArrayList<Chambre>();
		allchambres = ChambreDao.getChambresNoOccupied();
		if (allchambres.isEmpty()) {
			request.setAttribute("txterro", "No Chambre founded");
			pagejsp = "/allchambreform.jsp";
		} else {
			request.setAttribute("allchambres", allchambres);
			pagejsp = "/allchambre.jsp";
		}
		return pagejsp;
	}

	/**
	 * Search a chambre by No
	 * 
	 * @param request no of the chambre
	 * @return result page if not null otherwise error alert
	 */
	public static String processGetChambreByNo(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		int nochambre = Integer.parseInt(request.getParameter("nochambre"));
		String foundornot = "La chambre no: " + nochambre + " is not found";
		ArrayList<Chambre> allchambres = new ArrayList<Chambre>();

		Chambre findchambre = ChambreDao.getChambreByNo(nochambre);

		if (findchambre == null) {
			request.setAttribute("txterro", foundornot);
			pagejsp = "/searchchambre.jsp";
		} else {
			allchambres.add(findchambre);
			request.setAttribute("allchambres", allchambres);
			pagejsp = "/allchambre.jsp";
		}

		return pagejsp;
	}

	/**
	 * Search by price superior of price searched
	 * 
	 * @param request price of chambre
	 * @return all chambres with superior price
	 */

	public static String processGetChambreByPrice(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		Float prixchambre = Float.parseFloat(request.getParameter("prixchambre"));
		String foundornot = "";

		ArrayList<Chambre> allchambres = new ArrayList<Chambre>();
		allchambres = ChambreDao.getChambresByPrice(prixchambre);

		if (allchambres.isEmpty()) {
			foundornot = "Aucune chambre trouve a un prix superieur a : " + prixchambre + " CHF";
			request.setAttribute("txterro", foundornot);
			pagejsp = "/searchchambre.jsp";
		} else {
			request.setAttribute("allchambres", allchambres);
			pagejsp = "/allchambre.jsp";
		}

		return pagejsp;
	}

	/**
	 * Get Chambre by num of the eleve
	 * 
	 * @param request num of the eleve
	 * @return all chambres of the eleve
	 */

	public static String processGetChambreByEleveNum(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String numelev = request.getParameter("numelev");
		String foundornot = "";

		ArrayList<Chambre> allchambres = new ArrayList<Chambre>();
		Eleve elevfinded = EleveDao.getEleveByNum(numelev);

		allchambres = ChambreDao.getChambresByNum(numelev);

		if (elevfinded == null) {
			foundornot = "Eleve " + numelev + " not exist";
			pagejsp = "/searchchambre.jsp";
		} else if (allchambres.isEmpty()) {
			foundornot = "Aucune chambre trouve avec cette identifiant la : " + numelev;
			pagejsp = "/searchchambre.jsp";
		} else {
			request.setAttribute("allchambres", allchambres);
			pagejsp = "/allchambre.jsp";
		}
		request.setAttribute("txterro", foundornot);
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
		String updatedornot = "Not updated";
		int no = Integer.parseInt(request.getParameter("nochambre"));
		String nprix = request.getParameter("prixchambre");
		Float newPrix = 0.0f;
		int code = 0;

		if (nprix.equals("")) {
			updatedornot = "Price chambre cannot be null";
		} else {
			newPrix = Float.parseFloat(nprix);
			Chambre chambreToFind = ChambreDao.getChambreByNo(no);

			if (chambreToFind == null) {
				updatedornot = "Erreur : Chambre Inexistant";

			} else if (chambreToFind.getPrix() == newPrix) {
				updatedornot = "Not Update: Same price";
			} else {
				code = ChambreDao.updateChambrePriceByNo(no, newPrix);
				if (code == 1) {
					System.out.println("Code de l'operation : " + code + " no " + no);
					updatedornot = "Le prix de la chambre numero: " + no + " a ete change de " + chambreToFind.getPrix()
							+ " en " + newPrix;
					request.setAttribute("successornot", "success");
				}
			}
		}

		request.setAttribute("txterro", updatedornot);
		pagejsp = "/allchambreform.jsp";
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
		String deleteornot = "Erreur : one stutent is assigned to this chambre";
		int num = Integer.parseInt(request.getParameter("nochambre")); // a partir de chaque formulaire
																		// HTML/XHTML/JSTL/JSP
		Chambre chambreToFind = ChambreDao.getChambreByNo(num);

		if (chambreToFind == null) {
			deleteornot = "Erreur Chambre Inexistant";

		} else {
			int code = ChambreDao.deleteChambreByNo(num);
			System.out.println("Code de l'operation : " + code + " no " + num);
			if (code == 1) {
				deleteornot = "La chambre " + chambreToFind.getNo() + " a ete supprime !!";
				request.setAttribute("successornot", "success");
			}

		}
		request.setAttribute("txterro", deleteornot);
		pagejsp = "/allchambreform.jsp";
		return pagejsp;
	}

}
