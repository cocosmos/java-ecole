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

		
		if (cote.equals("")||titre.equals("")){addornot = "Fields cannot be null ";}
		else if(livreToFind == null) {
			Livre livreNew = new Livre(cote, null, titre, null);
			int code = LivreDao.addLivre(livreNew);
			System.out.println("COde de l'operation : " + code);
			if (code == 1) {
				addornot = "Livre cote: " + cote + " added with success !!";
				request.setAttribute("successornot", "success");
			}
		} else {
			addornot = "Error Livre already exist ";
	
		}
		
		request.setAttribute("txterro", addornot);
		pagejsp = "/addlivre.jsp";
		return pagejsp;

	}

	/**
	 * Get Livre by cote
	 * 
	 * @param request cote of the livre
	 * @return result array to display it in the page all livres and all eleves for
	 *         select
	 */

	public static String processGetLivreByCote(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String cote = request.getParameter("cote");
		String foundornot = "Livre cote : " + cote + " is not found";
		ArrayList<Livre> alllivres = new ArrayList<Livre>();
		ArrayList<Eleve> alleleves = new ArrayList<Eleve>();

		try {
			Livre LivreFinded = LivreDao.getLivreByCote(cote);
			alleleves = EleveDao.getAllEleves();
			if (LivreFinded == null) {
				request.setAttribute("txterro", foundornot);
				pagejsp = "/searchlivre.jsp";
			} else {
				alllivres.add(LivreFinded);
				request.setAttribute("alllivres", alllivres);
				request.setAttribute("allleleves", alleleves);
				pagejsp = "/alllivre.jsp";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("txterro", "ERROR");
			pagejsp = "/alllivreform.jsp";
			e.printStackTrace();
		}

		return pagejsp;
	}

	/**
	 * Get all Livre
	 * 
	 * @param request get all Livre
	 * @return all Livre and all eleves for select
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
				request.setAttribute("txterro", "No Livre founded");
				pagejsp = "/alllivreform.jsp";
			} else {
				request.setAttribute("alllivres", alllivres);
				request.setAttribute("allleleves", alleleves);
				pagejsp = "/alllivre.jsp";
			}
		} catch (SQLException e) {
			request.setAttribute("txterro", "ERROR");
			pagejsp = "/alllivreform.jsp";
			e.printStackTrace();
		}

		return pagejsp;
	}

	/**
	 * Get all Livre Available
	 * 
	 * @param request get all Livre
	 * @return all Livre available and all eleves for select
	 */

	public static String processGetAllLivresAvailable(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Livre> alllivres = new ArrayList<Livre>();
		ArrayList<Eleve> alleleves = new ArrayList<Eleve>();

		try {
			alllivres = LivreDao.getLivresAvailable();
			alleleves = EleveDao.getAllEleves();
			if (alllivres.isEmpty()) {
				request.setAttribute("txterro", "No Livre founded");
				pagejsp = "/alllivreform.jsp";
			} else {
				request.setAttribute("alllivres", alllivres);
				request.setAttribute("allleleves", alleleves);
				pagejsp = "/alllivre.jsp";
			}
		} catch (SQLException e) {
			
			request.setAttribute("txterro", "ERROR");
			pagejsp = "/alllivreform.jsp";
			e.printStackTrace();
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
		ArrayList<Eleve> alleleves = new ArrayList<Eleve>();

		try {
			alleleves = EleveDao.getAllEleves();
			alllivres = LivreDao.getLivresByEleveNum(numelev);
			if (alllivres.isEmpty()) {
				request.setAttribute("txterro", "No Livre founded for eleve no:" + numelev);
				pagejsp = "/searchlivre.jsp";
			} else {
				request.setAttribute("alllivres", alllivres);
				request.setAttribute("allleleves", alleleves);
				pagejsp = "/alllivre.jsp";
			}
		} catch (SQLException e) {
		
			request.setAttribute("txterro", "ERROR");
			pagejsp = "/alllivreform.jsp";
			e.printStackTrace();
		}

		return pagejsp;
	}

	/**
	 * Update Title By Cote
	 * 
	 * @param request cote of Livre and New Title of Livre
	 * @return return message success or error
	 */
	public static String processUpdateLivreTitle(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String updatedornot = "not updated";
		String cote = request.getParameter("cote");
		String newTitle = request.getParameter("titre");
		Livre LivreFinded = LivreDao.getLivreByCote(cote);

		if (newTitle.equals("")) {
			updatedornot= "Field cannot be null";
		} else if (LivreFinded.getTitre().equals(newTitle)) {
			updatedornot = "Same Title - Not Updated";
		} else {
			LivreDao.updateLivreTitreByCote(cote, newTitle);
			updatedornot = "Livre Cote: " + cote + " changed from " + LivreFinded.getTitre() + " to " + newTitle;
			request.setAttribute("successornot", "success");
		}
		pagejsp = "/alllivreform.jsp";
		request.setAttribute("txterro", updatedornot);
		return pagejsp;

	}

	/**
	 * Update Borrower By Cote
	 * 
	 * @param request cote of Livre and New Title of Livre
	 * @return return message success or error
	 */
	public static String processUpdateLivreBorrower(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String updatedornot = "not updated";
		String cote = request.getParameter("cote");
		String newEleve = request.getParameter("numelev");
		Livre LivreFinded = LivreDao.getLivreByCote(cote);


		if (newEleve.equals("")) {
			updatedornot= "Field cannot be null";
		} else if (LivreFinded.getNum() == newEleve) { // Same value
			updatedornot ="Same Borrower - Not Updated";
		
		} else {
			LivreDao.updateLivreNumByCote(cote, newEleve);
			updatedornot = "Livre Cote: " + cote + " assigned to " + newEleve;
			request.setAttribute("successornot", "success");
		}
		request.setAttribute("txterro", updatedornot);
		pagejsp = "/alllivreform.jsp";
		return pagejsp;
	}

	/**
	 * Delete Livre by cote
	 * 
	 * @param request get cote of Livre
	 * @return success if deleted otherwise error code
	 */

	public static String processDeleteLivreByCote(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String deleteornot = "Erreur : one eleve is assigned to this Livre";
		String cote = request.getParameter("cote"); // a partir de chaque formulaire
													// HTML/XHTML/JSTL/JSP
		Livre LivreFinded = LivreDao.getLivreByCote(cote);

		 if (LivreFinded == null) {
			
			deleteornot = "Error Livre not exist";
		} else {
			int code = LivreDao.deleteLivreByNo(cote);
			System.out.println("Code de l'operation : " + code + " cote " + cote);
			if (code == 1) {
				deleteornot = "Livre : " + cote + " is deleted !!";
				request.setAttribute("successornot", "success");
			}
		}
		request.setAttribute("txterro", deleteornot);
		pagejsp = "/alllivreform.jsp";
		return pagejsp;
	}

}
