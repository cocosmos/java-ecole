package com.crea.dev4.ecole.inter.metier;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.crea.dev4.ecole.model.beans.Eleve;
import com.crea.dev4.ecole.model.beans.Inscrit;
import com.crea.dev4.ecole.model.beans.Uv;
import com.crea.dev4.ecole.model.dao.EleveDao;
import com.crea.dev4.ecole.model.dao.InscritDao;
import com.crea.dev4.ecole.model.dao.UvDao;

public class InscritMetier {
	/**
	 * Get all Inscrits
	 * 
	 * @param request get all Inscrits
	 * @return all and all eleves for select
	 * @throws SQLException
	 */

	public static String processGetAllInscrits(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Inscrit> allinscrits = new ArrayList<Inscrit>();

		allinscrits = InscritDao.getAllInscrit();

		if (allinscrits.isEmpty()) {
			request.setAttribute("txtconfirmation", "No Inscrits founded");
			pagejsp = "/allinscritsform.jsp";
		} else {
			request.setAttribute("allinscrits", allinscrits);
			pagejsp = "/allinscrits.jsp";
		}

		return pagejsp;
	}

	/**
	 * Get inscrits by Eleve Num
	 * 
	 * @param request num of the eleve
	 * @return page with all inscrits of the eleve
	 */

	public static String processGetInscritsByEleveNum(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Inscrit> allinscrits = new ArrayList<Inscrit>();
		String num = request.getParameter("numelev");

		allinscrits = InscritDao.getInscritsByEleveNum(num);

		if (allinscrits.isEmpty()) {
			request.setAttribute("txtconfirmation", "No Inscrits founded");
			pagejsp = "/alleleveform.jsp";
		} else {
			request.setAttribute("allinscrits", allinscrits);
			pagejsp = "/allinscrits.jsp";
		}

		return pagejsp;
	}

	/**
	 * Delete Inscrits by Code of UV and Num
	 * 
	 * @param request code of uv and num of eleve
	 * @return confirmation
	 */

	public static String processDeleteInscritByCodeAndNum(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String deleteornot = "Error";
		String code = request.getParameter("code"); // a partir de chaque formulaire
		String num = request.getParameter("numelev");

		Eleve elevFinded = EleveDao.getEleveByNum(num);
		Uv UvFinded = UvDao.getUvByCode(code);

		if (elevFinded != null && UvFinded != null) {
			int codeSucces = InscritDao.deleteInscritByCodeAndNum(code, num);
			System.out.println("Code de l'operation : " + codeSucces + " code " + code + " num " + num);
			if (codeSucces == 1) {
				deleteornot = "Inscrits : \n code: " + code + " num: " + num + " is deleted !!";
			}
		}

		request.setAttribute("txtconfirmation", deleteornot);
		pagejsp = "/allinscritsform.jsp";

		return pagejsp;
	}
}
