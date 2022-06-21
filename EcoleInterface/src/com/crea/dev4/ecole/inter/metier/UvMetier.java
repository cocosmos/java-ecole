package com.crea.dev4.ecole.inter.metier;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.crea.dev4.ecole.model.beans.Uv;
import com.crea.dev4.ecole.model.dao.UvDao;

public class UvMetier {
	
	/**
	 * Get an UV by Code
	 * 
	 * @param request code UV
	 * @return result array of UV with only one
	 */
	public static String processGetUvByCode(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String nocode = request.getParameter("nocode");
		String foundornot = "UV code: " + nocode + " is not found";
		ArrayList<Uv> alluv = new ArrayList<Uv>();
		Uv UvFinded = UvDao.getUvByCode(nocode);

		if (UvFinded == null) {
			request.setAttribute("txterro", foundornot);
			pagejsp = "/searchuv.jsp";
		}
		else {
			alluv.add(UvFinded);
			request.setAttribute("alluv", alluv);
			pagejsp = "/alluv.jsp";
		}
		return pagejsp;
	}
	
	
	/**
	 * Get all UV
	 * @param request get all UV
	 * @return all UV
	 */
	
	public static String processGetAllUv(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Uv> alluv = new ArrayList<Uv>();
		alluv = UvDao.getAllUvs();
		
		if(alluv.isEmpty()) {
			request.setAttribute("txterro", "No Uv founded");
			pagejsp = "/alluvform.jsp";
		}else {
			request.setAttribute("alluv", alluv);
			pagejsp = "/alluv.jsp";
		}

		return pagejsp;
	}
	
	/**
	 * Get UV by number of hours superior of parameter
	 * @param request the number of hours superior
	 * @return all UV superior of @param number
	 */
	
	public static String processGetUvByNbhSuperior(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		ArrayList<Uv> alluv = new ArrayList<Uv>();
		int newnbh =Integer.parseInt(request.getParameter("nbhsuperior"));
		alluv = UvDao.getUvsWithHours(newnbh);
		
		if(alluv.isEmpty()) {
			request.setAttribute("txterro", "No Uv founded");
			pagejsp = "/searchuv.jsp";
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
			updatedornot="Error : Nothing in the input";
			
		} else if(UvFinded.getNbh()==newHours) {
			updatedornot= "Same Nbh - Not Updated";
		}
		else {
			UvDao.updateNbhByCode(nocode, newHours);
			updatedornot = "Uv Code: " + nocode + " changed from " + UvFinded.getNbh() + " to "+ newHours;
			request.setAttribute("successornot", "success");
		}
		request.setAttribute("txterro", updatedornot);
		pagejsp = "/alluvform.jsp";
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

		if (newCoord.equals("")) {
			updatedornot="Cannot be null";
			
		} else if(UvFinded.getCoord().equals(newCoord)) {
			updatedornot="Same Coord - Not Updated";
			pagejsp = "/alluvform.jsp";
		}
		else {
			UvDao.updateCoordByCode(nocode, newCoord);
			updatedornot = "Uv Code: " + nocode + " changed from " + UvFinded.getCoord() + " to "+ newCoord;
			request.setAttribute("successornot", "success");
		}
		request.setAttribute("txterro", updatedornot);
		pagejsp = "/alluvform.jsp";
		return pagejsp;
		
	}
	
	/**
	 * Delete UV by code
	 * @param request get code of UV
	 * @return success if deleted otherwise error code
	 */
	
	public static String processDeleteUv(HttpServletRequest request) {
		String pagejsp = "/WEB-INF/error.jsp";
		String deleteornot = "Erreur : there is come inscrit is assigned to this UV";
		String nocode = request.getParameter("nocode"); // a partir de chaque formulaire
																		// HTML/XHTML/JSTL/JSP
		Uv UvFinded = UvDao.getUvByCode(nocode);

		if (UvFinded == null) {
			deleteornot ="Error UV not exist";
			pagejsp = "/alluvform.jsp";
		} else {
			int code = UvDao.deleteUvByCode(nocode);
			System.out.println("Code de l'operation : " + code + " nocode " + nocode);
			if (code == 1) {
				deleteornot = "Uv" + nocode + " is deleted !!";
				request.setAttribute("successornot", "success");
			}
		}
		request.setAttribute("txterro", deleteornot);
		pagejsp = "/alluvform.jsp";
		return pagejsp;
	}
	
}
