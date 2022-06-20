package com.crea.dev4.ecole.inter.metier;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.crea.dev4.ecole.model.beans.Chambre;
import com.crea.dev4.ecole.model.beans.Eleve;
import com.crea.dev4.ecole.model.dao.ChambreDao;
import com.crea.dev4.ecole.model.dao.EleveDao;

public class EleveMetier {

	/**
	 * Add an Eleve
	 * 
	 * @param request
	 * @return
	 */

	public static String processAddEleve(HttpServletRequest request) {

		String pagejsp = "/WEB-INF/error.jsp";
		String addornot = "not added";
		String num = request.getParameter("numelev"); // a partir de chaque formulaire HTML/XHTML/JSTL/JSP

		Eleve elevToFind = EleveDao.getEleveByNum(num);

		if (elevToFind == null) {
			String nom = request.getParameter("nomelev"); // a partir de chaque formulaire HTML/XHTML/JSTL/JSP
			int age = Integer.parseInt(request.getParameter("agelev")); // a partir de chaque formulaire
																		// HTML/XHTML/JSTL/JSP
			String adresse = request.getParameter("adresselev"); // a partir de chaque formulaire
																	// HTML/XHTML/JSTL/JSP
			Eleve elnew = new Eleve(num, 0, nom, age, adresse);
			int code = EleveDao.addEleve(elnew);
			System.out.println("COde de l'opération : " + code);
			if (code == 1) {
				addornot = "Student " + elnew.getNom() + " added with success !!";
			}
			request.setAttribute("txtconfirmationsearch", addornot);
			pagejsp = "/confirmation.jsp";
		} else {
			request.setAttribute("txterro", "Erreur Eleve Existant");
			pagejsp = "/addeleve.jsp";
		}
		return pagejsp;
	}

	public static String processGetEleveBynum(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String numelev = request.getParameter("numelev");
		String foundornot = "L'eleve (" + numelev + ")not found";
		Eleve erecup = EleveDao.getEleveByNum(numelev);
		if (erecup != null && erecup.getNum().equals(numelev)) {
			foundornot = "L'eleve (" + erecup.getNum() + "," + erecup.getNom() + ") is found";
		}
		request.setAttribute("txtresult", foundornot);
		pagejsp = "/foundornot.jsp";
		return pagejsp;
	}

	public static String processGetElevesByChambreNo(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		int numchamb = Integer.parseInt(request.getParameter("numchamb"));
		ArrayList<Eleve> elevbychambre = new ArrayList<Eleve>();

		String foundornot = "";
		try {
			elevbychambre = EleveDao.getEleveByNo(numchamb);

			if (elevbychambre.isEmpty()) {
				foundornot = "Aucun élève trouvé dans la chambre (" + numchamb + ")";
			} else {
				for (Eleve e : elevbychambre) {
					foundornot += "L'eleve (" + e.getNum() + ", " + e.getNom() + ") is found <br><br>";
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		request.setAttribute("txtresult", foundornot);
		pagejsp = "/foundornot.jsp";
		return pagejsp;
	}

	public static String processGetElevesByDateNaissance(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		int year = Integer.parseInt(request.getParameter("iddate"));
		ArrayList<Eleve> elevbyyear = new ArrayList<Eleve>();

		String foundornot = "";
		try {
			elevbyyear = EleveDao.getLstElevesByDateNaissance(year);

			if (elevbyyear.isEmpty()) {
				foundornot = "Aucun élève trouvé par année de naissance(" + year + ")";
			} else {
				for (Eleve e : elevbyyear) {
					foundornot += "L'eleve (" + e.getNum() + ", " + e.getNom() + ", " + e.getAge()
							+ ") is found <br><br>";
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		request.setAttribute("txtresult", foundornot);
		pagejsp = "/foundornot.jsp";
		return pagejsp;
	}

	public static String processGetElevesByNom(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String nomElev = request.getParameter("nomeleve");
		ArrayList<Eleve> elevbynom = new ArrayList<Eleve>();

		String foundornot = "";
		elevbynom = EleveDao.getElevesByNom(nomElev);

		if (elevbynom.isEmpty()) {
			foundornot = "Aucun élève trouvé par nom (" + nomElev + ")";
		} else {
			for (Eleve e : elevbynom) {
				foundornot += "L'eleve (" + e.getNum() + ", " + e.getNom() + ", " + e.getAge() + ") is found <br><br>";
			}
		}

		request.setAttribute("txtresult", foundornot);
		pagejsp = "/foundornot.jsp";
		return pagejsp;
	}

	public static String processDeleteEleve(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String deleteornot = "not deleted";
		String num = request.getParameter("numelev"); // a partir de chaque formulaire HTML/XHTML/JSTL/JSP

		Eleve elevToFind = EleveDao.getEleveByNum(num);

		if (elevToFind == null) {
			request.setAttribute("txterro", "Erreur Eleve Inexistant");
			pagejsp = "/deleteeleve.jsp";
		} else {
			int code = EleveDao.deleteEleveBynum(num);
			System.out.println("Code de l'opération : " + code);
			if (code == 1) {
				deleteornot = "L'élève " + elevToFind.getNom() + " numéro :" + num + " a été supprimé !!";
			}
			request.setAttribute("txtconfirmationsearch", deleteornot);
			pagejsp = "/confirmation.jsp";
		}
		return pagejsp;
	}

	/**
	 * Get All eleves
	 * 
	 * @param request
	 * @return page jsp
	 */
	public static String processGetAllEleves(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Eleve> allelevs = new ArrayList<Eleve>();
		try {
			allelevs = EleveDao.getAllEleves();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("allelevs", allelevs);
		pagejsp = "/alleleves.jsp";
		return pagejsp;
	}

	/**
	 * Update adresse of un eleve
	 * 
	 * @param request
	 * @return page jsp
	 */
	public static String processUpdateEleve(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String updatedornot = "not updated";
		String num = request.getParameter("numelev");
		String newAdress = request.getParameter("adresselev");
		int code = 0;

		Eleve elevToFind = EleveDao.getEleveByNum(num);

		if (elevToFind == null) {
			request.setAttribute("txtconfirmation", "Erreur Eleve Inexistant");
			pagejsp = "/allelevesform.jsp";
		} else {

			try {
				code = EleveDao.updateEleveAdresseBynum(num, newAdress);
				updatedornot = "L'adresse de l'élève numéro " + num + " a été changé de " + elevToFind.getAdresse()
						+ " en " + newAdress;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Code de l'opération : " + code);
				e.printStackTrace();
			}
			request.setAttribute("txtconfirmation", updatedornot);
			pagejsp = "/allelevesform.jsp";
		}
		return pagejsp;

	}

	public static String processUpdateChambreByEleve(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String updatedornot = "not updated";
		String num = request.getParameter("numelev");
		int newChambre = Integer.parseInt(request.getParameter("nochambre"));
		int code = 0;

		Eleve elevToFind = EleveDao.getEleveByNum(num);

		Chambre chambreExist = ChambreDao.getChambreByNo(newChambre);

		System.out.println("no chambre: " + chambreExist);

		if (chambreExist == null) {
			request.setAttribute("txtconfirmationall", "Erreur Chambre inexistante");
			pagejsp = "/alleleveform.jsp";
		} else {

			code = EleveDao.updateEleveNumChambreBynum(num, chambreExist.getNo());
			updatedornot = "L'élève numéro " + num + " a changé de la chambre n°" + elevToFind.getNo() + " en n°"
					+ newChambre;
			request.setAttribute("txtconfirmationall", updatedornot);
			pagejsp = "/alleleveform.jsp";
		}
		return pagejsp;

	}

	// To develop other cases

}
