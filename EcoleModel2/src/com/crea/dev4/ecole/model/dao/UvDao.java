package com.crea.dev4.ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crea.dev4.ecole.model.beans.Uv;
import com.crea.dev4.ecole.model.utils.DBAction;

public class UvDao {
	/* GET Functions */
	// get uv by code
	public static Uv getUvByCode(String code) {
		Uv u = new Uv();
		String request = null;
		ResultSet response = null;
		// =1=> connexion � la BD
		DBAction.DBConnexion();
		// =2.1=> préparer notre requ�te sql SELECT
		request = "SELECT * FROM uv WHERE code = \'" + code + "\'";
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La r�cup�ration du r�sultat dans un objet Chmabre
			if (response.next()) {
				u.setCode(response.getString(1));
				u.setNbh(response.getInt(2));
				u.setCoord(response.getString(3));
				u.affiche();
			} else {
				u = null;
			}
		} catch (SQLException u1) {
			u1.printStackTrace();
		}
		return u;
	}

	// get all UV
	public static ArrayList<Uv> getAllUvs() {
		ArrayList<Uv> listeUvs = new ArrayList<Uv>();
		String request = null;
		ResultSet response = null;
		int i = 0;
		Uv uvtmp = new Uv();
		// =1=> connexion � la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM uv";
		try {
			response = DBAction.getStm().executeQuery(request);
			while (response.next()) {
				uvtmp.setCode(response.getString(1));
				uvtmp.setNbh(response.getInt(2));
				uvtmp.setCoord(response.getString(3));
				uvtmp.affiche();
				i++;
			}
			if (!response.isClosed()) {
				response.close();
			}
		} catch (SQLException e) {
			listeUvs.add(uvtmp);
			e.printStackTrace();
		}
		return listeUvs;
	}

	// get all uvs with number of hours
	public static ArrayList<Uv> getUvsWithHours(int nbh) {
		ArrayList<Uv> listeUvs = new ArrayList<Uv>();
		String request = null;
		ResultSet response = null;
		int i = 0;
		Uv uvtmp = new Uv();
		// =1=> connexion � la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM chambre WHERE prix > " + nbh;
		try {
			response = DBAction.getStm().executeQuery(request);
			while (response.next()) {
				uvtmp.setCode(response.getString(1));
				uvtmp.setNbh(response.getInt(2));
				uvtmp.setCoord(response.getString(3));
				uvtmp.affiche();
				i++;
			}
			if (!response.isClosed()) {
				response.close();
			}
		} catch (SQLException e) {
			listeUvs.add(uvtmp);
			e.printStackTrace();
		}
		return listeUvs;
	}

	/* ADD Functions */
	/*
	 * public static int addUv(Uv newUv) { int result = -1; String request = null;
	 * 
	 * DBAction.DBConnexion(); request = "INSERT INTO uv (code, nbh, coord)" +
	 * " VALUES ('" + newUv.getCode() + "'," + newUv.getNbh() + "'," +
	 * newUv.getCoord() + "') "; try { result =
	 * DBAction.getStm().executeUpdate(request); } catch (SQLException ex) { if
	 * (ex.getErrorCode() == 1062) {// la cl� existe d�j� result = -2; }
	 * System.out.println(ex.getMessage()); }
	 * 
	 * DBAction.DBClose(); return result; }
	 */

	/* UPDATE Functions */
	public static int updateNbhByCode(String code, int newNbh) {
		int result = -1;
		String request = null;
		DBAction.DBConnexion();
		request = "UPDATE uv SET nbh ='" + newNbh + "'WHERE code ='" + code + "'";
		try {
			result = DBAction.getStm().executeUpdate(request);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		DBAction.DBClose();
		return result;
	}

	public static int updateCoordByCode(String code, String newCoord) {
		int result = -1;
		String request = null;
		DBAction.DBConnexion();
		request = "UPDATE uv SET coord ='" + newCoord + "'WHERE code ='" + code + "'";
		try {
			result = DBAction.getStm().executeUpdate(request);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		DBAction.DBClose();
		return result;
	}
	/* DELETE Functions */

	public static int deleteUvByCode(String code) {
		int result = -1;
		String request = null;
		// 1: connexion � la BD
		DBAction.DBConnexion();
		// 2: préparer ma requpete de suppression
		request = "DELETE FROM uv WHERE code ='" + code + "'";
		try {
			result = DBAction.getStm().executeUpdate(request);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		DBAction.DBClose();
		return result;
	}

}
