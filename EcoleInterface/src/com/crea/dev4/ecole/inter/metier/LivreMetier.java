package com.crea.dev4.ecole.inter.metier;

import javax.servlet.http.HttpServletRequest;

import com.crea.dev4.ecole.model.beans.Livre;
import com.crea.dev4.ecole.model.dao.LivreDao;

public class LivreMetier {
	/**
	 * Add a new Livre
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
}
