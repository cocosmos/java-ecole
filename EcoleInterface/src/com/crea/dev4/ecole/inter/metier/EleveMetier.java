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
			int age = Integer.parseInt(request.getParameter("agelev")); // a partir de chaque formulaire										// HTML/XHTML/JSTL/JSP
			String adresse = request.getParameter("adresselev"); // a partir de chaque formulaire
			//Check if null
			if(nom !=null && adresse!=null && age!=0) {
				Eleve elnew = new Eleve(num, 0, nom, age, adresse);
				int code = EleveDao.addEleve(elnew);
				System.out.println("COde de l'operation : " + code);
				if (code == 1) {
					addornot = "Student " + elnew.getNom() + " added with success !!";
					request.setAttribute("successornot", "success");
				}
			} else {
				addornot = "Please write all field";
			}
		} else {
			addornot = "Eleve exist already";
		}
		request.setAttribute("txterro", addornot);
		
		pagejsp = "/addeleve.jsp";
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
		String foundornot = "L'eleve (" + numelev + ") not found";
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
	 * @return page of eleves with array of all chambres to edit it
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
	 * @param request no of chambre 
	 * @return all eleves int this particular chambre with array of all chambres to edit it
	 */

	public static String processGetElevesByChambreNo(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		int numchamb = Integer.parseInt(request.getParameter("numchamb"));
		ArrayList<Eleve> allelevs = new ArrayList<Eleve>();
		ArrayList<Chambre> allchambres = new ArrayList<Chambre>();
		try {
			allelevs = EleveDao.getEleveByNo(numchamb);
			allchambres = ChambreDao.getAllChambres();
			if (allelevs.isEmpty()) {
				request.setAttribute("txterro", "No Eleve founded");
				pagejsp = "/searcheleve.jsp";
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
	 *  Get All Eleves by datebirth
	 * @param request date of birth 
	 * @return all eleve with the same date of birth with array of all chambres to edit it
	 */
	public static String processGetElevesByDateNaissance(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		int year = Integer.parseInt(request.getParameter("iddate"));
		ArrayList<Eleve> allelevs = new ArrayList<Eleve>();
		ArrayList<Chambre> allchambres = new ArrayList<Chambre>();
		String foundornot = "";
		try {
			allelevs = EleveDao.getLstElevesByDateNaissance(year);
			allchambres = ChambreDao.getAllChambres();
			if (allelevs.isEmpty()) {
				foundornot = "Aucun eleve trouve par annee de naissance(" + year + ")";
				request.setAttribute("txterro", foundornot);
				pagejsp = "/searcheleve.jsp";
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
	 * Get Eleves by nom 
	 * @param request the name of the eleve
	 * @return all eleves with the same name with an array of all chambres to edit it
	 */

	public static String processGetElevesByNom(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String nomElev = request.getParameter("nomeleve");
		ArrayList<Eleve> allelevs = new ArrayList<Eleve>();
		ArrayList<Chambre> allchambres = new ArrayList<Chambre>();

		String foundornot = "";
		
		allelevs = EleveDao.getElevesByNom(nomElev);
		allchambres = ChambreDao.getAllChambres();

		if (allelevs.isEmpty()) {
			foundornot = "Aucun eleve trouve par nom (" + nomElev + ")";
			request.setAttribute("txterro", foundornot);
			pagejsp = "/searcheleve.jsp";
		} else {
			request.setAttribute("allchambres", allchambres);
			request.setAttribute("allelevs", allelevs);
			pagejsp = "/alleleves.jsp";
		}

		return pagejsp;
	}

	/**
	 * Update adresse of un eleve
	 * 
	 * @param request num of eleve and new adress
	 * @return a message if success or not
	 */
	public static String processUpdateEleve(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String updatedornot = "not updated";
		String num = request.getParameter("numelev");
		String newAdress = request.getParameter("adresselev");
		int code = 0;

		Eleve elevToFind = EleveDao.getEleveByNum(num);

		if (elevToFind == null) {
			updatedornot= "Erreur Eleve Inexistant";
		} else if (elevToFind.getAdresse().equals(newAdress)) {
			updatedornot="Adresse inchange";
		} else if(newAdress=="") {
			updatedornot= "Ne peut etre null";
		}else {
			try {
				code = EleveDao.updateEleveAdresseBynum(num, newAdress);
				updatedornot = "L'adresse de l'eleve numero " + num + " a ete change de " + elevToFind.getAdresse()
						+ " en " + newAdress;
				request.setAttribute("successornot", "success");
			} catch (SQLException e) {
				
				System.out.println("Code de l'operation : " + code);
				e.printStackTrace();
			};
			
		}
		request.setAttribute("txterro", updatedornot);
		pagejsp = "/alleleveform.jsp";
		return pagejsp;

	}
	/**
	 * Update chambre for one eleve
	 * @param request new chambre no and num of eleve
	 * @return success or error
	 * TODO
	 */

	public static String processUpdateChambreByEleve(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String updatedornot = "not updated";
		String num = request.getParameter("numelev");
		int code = 0;
		int newChambre = Integer.parseInt(request.getParameter("nochambre"));
	
		Eleve elevToFind = EleveDao.getEleveByNum(num);
		Chambre chambreExist = ChambreDao.getChambreByNo(newChambre);
		
		if (chambreExist == null) {
			updatedornot = "Erreur Chambre inexistante";
			
		} else if (elevToFind.getNo() == newChambre) {
			updatedornot ="Meme chambre";
			
		} else {
			code = EleveDao.updateEleveNumChambreBynum(num, chambreExist.getNo());
			updatedornot = "L'eleve numero " + num + " a change de la chambre no:" + elevToFind.getNo() + " en no:"
					+ newChambre;
			request.setAttribute("successornot", "success");
		}
		System.out.println("code chambre: " + code);
		request.setAttribute("txterro", updatedornot);
		pagejsp = "/alleleveform.jsp";
		return pagejsp;

	}

	/**
	 * Delete one eleve by his num
	 * 
	 * @param request num of the eleve
	 * @return success or not on the form all eleves
	 */
	public static String processDeleteEleve(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String deleteornot = "Not deleted, eleve in another table";
		String num = request.getParameter("numelev"); // a partir de chaque formulaire HTML/XHTML/JSTL/JSP
		
		Eleve elevToFind = EleveDao.getEleveByNum(num);

		if (elevToFind == null) {
			request.setAttribute("txterro", "Erreur Eleve Inexistant");
		} else {
			int code = EleveDao.deleteEleveBynum(num);
			System.out.println("Code de l'operation : " + code);
			if (code == 1) {
				deleteornot = "L'eleve " + elevToFind.getNom() + " numero :" + num + " a ete supprime !!";
				request.setAttribute("successornot", "success");
			}
		}
		request.setAttribute("txterro", deleteornot);
		pagejsp = "/alleleveform.jsp";
		return pagejsp;
	}

}
