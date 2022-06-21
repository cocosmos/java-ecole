package com.crea.dev4.ecole.inter.metier;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.crea.dev4.ecole.model.beans.Eleve;
import com.crea.dev4.ecole.model.beans.Livre;
import com.crea.dev4.ecole.model.dao.EleveDao;
import com.crea.dev4.ecole.model.dao.LivreDao;

public class LivreMetier {
	/**
	 * Add a new Livre
	 * 
	 * @param request a new cote of livre and title
	 * @return success or error
	 */
	public static String processAddLivre(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String addornot = "not added";
		String cote = request.getParameter("cote");
		String titre = request.getParameter("titre");
		Livre livreToFind = LivreDao.getLivreByCote(cote);

		if (livreToFind == null) {
			Livre livreNew = new Livre(cote, null, titre, null);
			int code = LivreDao.addLivre(livreNew);
			System.out.println("COde de l'operation : " + code);
			if (code == 1) {
				addornot = "Livre cote: " + cote + " added with success !!";
				request.setAttribute("txterro", addornot);
				pagejsp = "/addlivre.jsp";
			}
		} else {
			request.setAttribute("txterro", "Error Livre already exist ");
			pagejsp = "/addlivre.jsp";
		}

		return pagejsp;

	}

	/**
	 * Get Livre by cote
	 * 
	 * @param request cote of the livre
	 * @return result array to display it in the page all livres
	 */

	public static String processGetLivreByCote(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String cote = request.getParameter("cote");
		String foundornot = "Livre cote : " + cote + " is not found";
		ArrayList<Livre> alllivres = new ArrayList<Livre>();
		Livre LivreFinded = LivreDao.getLivreByCote(cote);

		if (LivreFinded == null) {
			request.setAttribute("txterro", foundornot);
			pagejsp = "/searchlivre.jsp";
		} else {
			alllivres.add(LivreFinded);
			request.setAttribute("alllivres", alllivres);
			pagejsp = "/alllivre.jsp";
		}
		return pagejsp;
	}

	/**
	 * Get all Livre
	 * 
	 * @param request get all Livre
	 * @return all Livre
	 * @throws SQLException
	 */

	public static String processGetAllLivres(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Livre> alllivres = new ArrayList<Livre>();
		ArrayList<Eleve> alleleves = new ArrayList<Eleve>();

		try {
			alllivres = LivreDao.getAllLivres();
			alleleves = EleveDao.getAllEleves();
			if (alllivres.isEmpty()) {
				request.setAttribute("txtconfirmation", "No Livre founded");
				pagejsp = "/alllivreform.jsp";
			} else {
				request.setAttribute("alllivres", alllivres);
				request.setAttribute("allleleves", alleleves);
				pagejsp = "/alllivre.jsp";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pagejsp;
	}

	/**
	 * Get all Livre Available
	 * 
	 * @param request get all Livre
	 * @return all Livre available
	 */

	public static String processGetAllLivresAvailable(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Livre> alllivres = new ArrayList<Livre>();
		alllivres = LivreDao.getLivresAvailable();

		if (alllivres.isEmpty()) {
			request.setAttribute("txtconfirmation", "No Livre founded");
			pagejsp = "/alllivreform.jsp";
		} else {
			request.setAttribute("alllivres", alllivres);
			pagejsp = "/alllivre.jsp";
		}

		return pagejsp;
	}

	/**
	 * Get all Livre Shared to an eleve
	 * 
	 * @param request num of eleve
	 * @return all Livre with num = @param num
	 */

	public static String processGetLivresSharedToEleve(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String numelev = request.getParameter("numelev");
		ArrayList<Livre> alllivres = new ArrayList<Livre>();

		alllivres = LivreDao.getLivresByEleveNum(numelev);
		if (alllivres.isEmpty()) {
			request.setAttribute("txterro", "No Livre founded for elve no:" + numelev);
			pagejsp = "/searchlivre.jsp";
		} else {
			request.setAttribute("alllivres", alllivres);
			pagejsp = "/alllivre.jsp";
		}

		return pagejsp;
	}

}
