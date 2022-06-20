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
}
