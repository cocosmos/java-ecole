package com.crea.dev4.ecole.inter.metier;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


import com.crea.dev4.ecole.model.beans.Uv;

import com.crea.dev4.ecole.model.dao.UvDao;

public class UvMetier {
	
	/**
	 * Get all UV
	 * @param request get all UV
	 * @return all UV
	 */
	
	public static String processGetAllUv(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Uv> alluv = new ArrayList<Uv>();
		alluv = UvDao.getAllUvs();
		
		if(alluv== null) {
			request.setAttribute("txtconfirmation", "No Uv founded");
			pagejsp = "/alluvform.jsp";
		}else {
			request.setAttribute("alluv", alluv);
			pagejsp = "/alluv.jsp";
		}

		return pagejsp;
	}
	
	/**
	 * Update Number of hours by UV
	 * @param request code of UV and NBH
	 * @return Return message for change
	 */
	
	public static String processUpdateUvNbh(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String updatedornot = "not updated";
		String nocode = request.getParameter("nocode");
		int newHours = Integer.parseInt(request.getParameter("nbh"));
		Uv UvFinded = UvDao.getUvByCode(nocode);

		if (newHours==0) {
			request.setAttribute("txtconfirmation", "Error : Nothing in the input");
			pagejsp = "/alluvform.jsp";
			
		} else if(UvFinded.getNbh()==newHours) {
			request.setAttribute("txtconfirmation", "Same Nbh - Not Updated");
			pagejsp = "/alluvform.jsp";
		}
		else {
			UvDao.updateNbhByCode(nocode, newHours);
			updatedornot = "Uv Code: " + nocode + " changed from " + UvFinded.getNbh() + " to "+ newHours;
			request.setAttribute("txtconfirmation", updatedornot);
			pagejsp = "/alluvform.jsp";
		}
		return pagejsp;

	}
	
	/**
	 * Update Coord By code
	 * @param request code of UV and New Coord of UV
	 * @return return message success or error
	 */
	public static String processUpdateUvCoord(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String updatedornot = "not updated";
		String nocode = request.getParameter("nocode");
		String newCoord = request.getParameter("coord");
		Uv UvFinded = UvDao.getUvByCode(nocode);

		if (newCoord==null) {
			request.setAttribute("txtconfirmation", "Error");
			pagejsp = "/alluvform.jsp";
			
		} else if(UvFinded.getCoord().equals(newCoord)) {
			request.setAttribute("txtconfirmation", "Same Coord - Not Updated");
			pagejsp = "/alluvform.jsp";
		}
		else {
			UvDao.updateCoordByCode(nocode, newCoord);
			updatedornot = "Uv Code: " + nocode + " changed from " + UvFinded.getCoord() + " to "+ newCoord;
			request.setAttribute("txtconfirmation", updatedornot);
			pagejsp = "/alluvform.jsp";
		}
		return pagejsp;
		
	}
	public static String processDeleteUv(HttpServletRequest request) {}
	
	
	
	
	
	
}
