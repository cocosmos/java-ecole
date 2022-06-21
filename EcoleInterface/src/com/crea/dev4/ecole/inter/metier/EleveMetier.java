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
	 * Add an Eleve by num code
	 * 
	 * @param request num eleve
	 * @return success or error
	 */

	public static String processAddEleve(HttpServletRequest request) {

		String pagejsp = "/WEB-INF/error.jsp";
		String addornot = "Not added";
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
			System.out.println("COde de l'operation : " + code);
			if (code == 1) {
				addornot = "Student " + elnew.getNom() + " added with success !!";
			}
			request.setAttribute("txterro", addornot);
			pagejsp = "/addeleve.jsp";
		} else {
			request.setAttribute("txterro", "Erreur Eleve Existant");
			pagejsp = "/addeleve.jsp";
		}
		return pagejsp;
	}

	/**
	 * Get Eleve by Num
	 * 
	 * @param request the num of eleve
	 * @return an array to use the page all eleves
	 */

	public static String processGetEleveBynum(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String numelev = request.getParameter("numelev");
		String foundornot = "L'eleve (" + numelev + ")not found";
		ArrayList<Eleve> alleleves = new ArrayList<Eleve>();
		ArrayList<Chambre> allchambres = new ArrayList<Chambre>();
		Eleve erecup = EleveDao.getEleveByNum(numelev);

		if (erecup == null) {
			request.setAttribute("txterro", foundornot);
			pagejsp = "/searcheleve.jsp";

		} else if (erecup.getNum().equals(numelev)) {
			allchambres = ChambreDao.getAllChambres();
			alleleves.add(erecup);
			request.setAttribute("allchambres", allchambres);
			request.setAttribute("allelevs", alleleves);
			pagejsp = "/alleleves.jsp";
		}
		return pagejsp;
	}

	/**
	 * Get All eleves
	 * 
	 * @param request all eleves and chambres
	 * @return page of eleves
	 */
	public static String processGetAllEleves(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Eleve> allelevs = new ArrayList<Eleve>();
		ArrayList<Chambre> allchambres = new ArrayList<Chambre>();
		try {
			allelevs = EleveDao.getAllEleves();
			allchambres = ChambreDao.getAllChambres();
			if (allelevs.isEmpty()) {
				request.setAttribute("txtconfirmation", "No Eleve founded");
				pagejsp = "/alleleveform.jsp";
			} else {
				request.setAttribute("allchambres", allchambres);
				request.setAttribute("allelevs", allelevs);
				pagejsp = "/alleleves.jsp";
			}
		} catch (SQLException e) {
			request.setAttribute("txtconfirmation", "ERROR");
			pagejsp = "/alleleveform.jsp";
			e.printStackTrace();
		}

		return pagejsp;
	}

	/**
	 * Get Eleves by Chambre by num chambre
	 * 
	 * @param request
	 * @return
	 */

	public static String processGetElevesByChambreNo(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		int numchamb = Integer.parseInt(request.getParameter("numchamb"));
		ArrayList<Eleve> allelevs = new ArrayList<Eleve>();
		ArrayList<Chambre> allchambres = new ArrayList<Chambre>();
		String foundornot = "";
		try {
			allelevs = EleveDao.getEleveByNo(numchamb);
			allchambres = ChambreDao.getAllChambres();
			if (allelevs.isEmpty()) {
				request.setAttribute("txtconfirmation", "No Eleve founded");
				pagejsp = "/alleleveform.jsp";
			} else {
				request.setAttribute("allchambres", allchambres);
				request.setAttribute("allelevs", allelevs);
				pagejsp = "/alleleves.jsp";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pagejsp;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String processGetElevesByDateNaissance(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		int year = Integer.parseInt(request.getParameter("iddate"));
		ArrayList<Eleve> elevbyyear = new ArrayList<Eleve>();

		String foundornot = "";
		try {
			elevbyyear = EleveDao.getLstElevesByDateNaissance(year);

			if (elevbyyear.isEmpty()) {
				foundornot = "Aucun eleve trouve par annee de naissance(" + year + ")";
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
			foundornot = "Aucun eleve trouve par nom (" + nomElev + ")";
		} else {
			for (Eleve e : elevbynom) {
				foundornot += "L'eleve (" + e.getNum() + ", " + e.getNom() + ", " + e.getAge() + ") is found <br><br>";
			}
		}

		request.setAttribute("txtresult", foundornot);
		pagejsp = "/foundornot.jsp";
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
			request.setAttribute("txtconfirmationall", "Erreur Eleve Inexistant");
			pagejsp = "/alleleveform.jsp";
		} else if (elevToFind.getAdresse().equals(newAdress)) {
			request.setAttribute("txtconfirmationall", "Adresse inchange");
			pagejsp = "/alleleveform.jsp";
		} else {

			try {
				code = EleveDao.updateEleveAdresseBynum(num, newAdress);
				updatedornot = "L'adresse de l'eleve numero " + num + " a ete change de " + elevToFind.getAdresse()
						+ " en " + newAdress;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Code de l'operation : " + code);
				e.printStackTrace();
			}
			request.setAttribute("txtconfirmationall", updatedornot);
			pagejsp = "/alleleveform.jsp";
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

		} else if (elevToFind.getNo() == newChambre) {
			request.setAttribute("txtconfirmationall", "Meme chambre");
			pagejsp = "/alleleveform.jsp";
		} else {

			code = EleveDao.updateEleveNumChambreBynum(num, chambreExist.getNo());
			updatedornot = "L'eleve numero " + num + " a change de la chambre no:" + elevToFind.getNo() + " en no:"
					+ newChambre;
			request.setAttribute("txtconfirmationall", updatedornot);
			pagejsp = "/alleleveform.jsp";
		}
		return pagejsp;

	}

	/**
	 * Delete one eleve
	 * 
	 * @param request
	 * @return
	 */
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
			System.out.println("Code de l'operation : " + code);
			if (code == 1) {
				deleteornot = "L'eleve " + elevToFind.getNom() + " numero :" + num + " a ete supprime !!";
			}
			request.setAttribute("txtconfirmationall", deleteornot);
			pagejsp = "/alleleveform.jsp";
		}
		return pagejsp;
	}

}
