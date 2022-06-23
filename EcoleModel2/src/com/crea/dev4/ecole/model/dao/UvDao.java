package com.crea.dev4.ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crea.dev4.ecole.model.beans.Uv;
import com.crea.dev4.ecole.model.utils.DBAction;

/**
 * Uv Dao
 * 
 * @author mipam
 *
 */

public class UvDao {

	/**
	 * Get Uv by code
	 * 
	 * @param code of uv
	 * @return the UV
	 */
	public static Uv getUvByCode(String code) {
		Uv u = new Uv();
		String request = null;
		ResultSet response = null;
		// =1=> connexion a la BD
		DBAction.DBConnexion();
		// =2.1=> préparer notre requete sql SELECT
		request = "SELECT * FROM uv WHERE code = \'" + code + "\'";
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La recuperation du resultat dans un objet UV
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

	/**
	 * Get all UV
	 * 
	 * @return an arraylist of all UV
	 */
	public static ArrayList<Uv> getAllUvs() {
		ArrayList<Uv> listeUvs = new ArrayList<Uv>();
		String request = null;
		ResultSet response = null;

		// =1=> connexion � la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM uv";
		try {
			response = DBAction.getStm().executeQuery(request);
			while (response.next()) {
				Uv uvtmp = new Uv();
				uvtmp.setCode(response.getString(1));
				uvtmp.setNbh(response.getInt(2));
				uvtmp.setCoord(response.getString(3));
				uvtmp.affiche();
				listeUvs.add(uvtmp);

			}
			if (!response.isClosed()) {
				response.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listeUvs;
	}

	/**
	 * Get UV by number of hours superior
	 * 
	 * @param nbh you want to test
	 * @return an arraylist of Uv
	 */
	public static ArrayList<Uv> getUvsWithHours(int nbh) {
		ArrayList<Uv> listeUvs = new ArrayList<Uv>();
		String request = null;
		ResultSet response = null;

		// =1=> connexion a la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM uv WHERE nbh > " + nbh;
		try {
			response = DBAction.getStm().executeQuery(request);
			while (response.next()) {
				Uv uvtmp = new Uv();
				uvtmp.setCode(response.getString(1));
				uvtmp.setNbh(response.getInt(2));
				uvtmp.setCoord(response.getString(3));
				uvtmp.affiche();
				listeUvs.add(uvtmp);

			}
			if (!response.isClosed()) {
				response.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listeUvs;
	}

	/**
	 * Add Functions optional
	 * 
	 * @param newUv
	 * @return success or not
	 */
	public static int addUv(Uv newUv) {
		int result = -1;
		String request = null;

		DBAction.DBConnexion();
		request = "INSERT INTO uv (code, nbh, coord)" + " VALUES ('" + newUv.getCode() + "'," + newUv.getNbh() + ",'"
				+ newUv.getCoord() + "') ";
		try {
			result = DBAction.getStm().executeUpdate(request);
		} catch (SQLException ex) {
			if (ex.getErrorCode() == 1062) {
				System.out.println(ex.getMessage());
			}
		}

		DBAction.DBClose();
		return result;
	}

	/**
	 * Update NBH Functions
	 * 
	 * @param code   of UV
	 * @param newNbh (new number of hours for UV)
	 * @return success or error
	 */
	public static int updateNbhByCode(String code, int newNbh) {
		int result = -1;
		String request = null;
		DBAction.DBConnexion();
		if (newNbh > 0) {
			request = "UPDATE uv SET nbh ='" + newNbh + "'WHERE code ='" + code + "'";
			try {
				result = DBAction.getStm().executeUpdate(request);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		DBAction.DBClose();
		return result;
	}

	/**
	 * Update coord by code
	 * 
	 * @param code     of the uv
	 * @param newCoord for the uv
	 * @return success or error
	 */
	public static int updateCoordByCode(String code, String newCoord) {
		int result = -1;
		String request = null;
		DBAction.DBConnexion();
		if (newCoord != null) {
			request = "UPDATE uv SET coord ='" + newCoord + "'WHERE code ='" + code + "'";
			try {
				result = DBAction.getStm().executeUpdate(request);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		DBAction.DBClose();
		return result;
	}

	/**
	 * Delete Uv by Code
	 * 
	 * @param code of Uv
	 * @return success or error
	 */

	public static int deleteUvByCode(String code) {
		int result = -1;
		String request = null;
		// 1: connexion a la BD
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
