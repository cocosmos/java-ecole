package com.crea.dev4.ecole.inter.metier;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.crea.dev4.ecole.model.beans.Uv;

import com.crea.dev4.ecole.model.dao.UvDao;

public class UvMetier {
	
	/**
	 * Get all UV
	 * @param request get all Uv
	 * @return all uv
	 */
	
	public static String processGetAllUv(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Uv> alluv = new ArrayList<Uv>();
		alluv = UvDao.getAllUvs();

		request.setAttribute("alluv", alluv);
		pagejsp = "/alluv.jsp";
		return pagejsp;
	}
}
