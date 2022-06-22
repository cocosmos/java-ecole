package com.crea.dev4.ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crea.dev4.ecole.model.beans.Chambre;
import com.crea.dev4.ecole.model.utils.DBAction;

public class ChambreDao {

	/**
	 * Get chambre by no of chambre
	 * 
	 * @param no de la chambre
	 * @return chambre trouver
	 */

	public static Chambre getChambreByNo(int no) {
		Chambre c = new Chambre();
		String request = null;
		ResultSet response = null;
		// =1=> connexion à la BD
		DBAction.DBConnexion();
		// =2.1=> preparer notre requete sql SELECT
		request = "SELECT * FROM chambre WHERE no = \'" + no + "\'";
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La recuperation du resultat dans un objet Chmabre
			if (response.next()) {
				c.setNo(response.getInt(1));
				c.setPrix(response.getFloat(2));
				c.affiche();
			} else {
				c = null;
			}
		} catch (SQLException c1) {
			c1.printStackTrace();
		}

		return c;
	}

	/**
	 * Get chambres by num of the eleve
	 * 
	 * @param numEleve
	 * @return ArrayList
	 */
	public static ArrayList<Chambre> getChambresByNum(String numEleve) {
		ArrayList<Chambre> listeChambres = new ArrayList<Chambre>();
		String request = null;
		ResultSet response = null;

		// =1=> connexion a la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM chambre WHERE no IN (SELECT DISTINCT no FROM eleve WHERE num = \'" + numEleve + "\')";

		try {
			response = DBAction.getStm().executeQuery(request);
			while (response.next()) {
				Chambre chamtmp = new Chambre();
				chamtmp.setNo(response.getInt(1));
				chamtmp.setPrix(response.getFloat(2));
				chamtmp.affiche();
				listeChambres.add(chamtmp);

			}
			if (!response.isClosed()) {
				response.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listeChambres;
	}

	// get chambres with price
	public static ArrayList<Chambre> getChambresByPrice(float price) {
		ArrayList<Chambre> listeChambres = new ArrayList<Chambre>();

		String request = null;
		ResultSet response = null;

		// =1=> connexion e la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM chambre WHERE prix > " + price;
		try {
			response = DBAction.getStm().executeQuery(request);
			while (response.next()) {
				Chambre chamtmp = new Chambre();
				chamtmp.setNo(response.getInt(1));
				chamtmp.setPrix(response.getFloat(2));
				listeChambres.add(chamtmp);

			}
			if (!response.isClosed()) {
				response.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listeChambres;
	}

	// get all chambres
	public static ArrayList<Chambre> getAllChambres() {
		ArrayList<Chambre> listeChambres = new ArrayList<Chambre>();
		String request = "SELECT * FROM chambre";

		ResultSet response = null;

		// =1=> connexion e la BD
		DBAction.DBConnexion();

		try {
			response = DBAction.getStm().executeQuery(request);

			while (response.next()) {
				Chambre chamtmp = new Chambre();
				chamtmp.setNo(response.getInt(1));
				chamtmp.setPrix(response.getFloat(2));
				listeChambres.add(chamtmp);

			}

			if (!response.isClosed()) {
				response.close();
			}
		} catch (SQLException e) {
			// listeChambres.add(chamtmp);
			e.printStackTrace();
		}
		return listeChambres;
	}

	public static ArrayList<Chambre> getChambresNoOccupied() {
		ArrayList<Chambre> listeChambres = new ArrayList<Chambre>();
		String request = "SELECT chambre.no, chambre.prix FROM `chambre` LEFT JOIN eleve ON chambre.no=eleve.no WHERE eleve.no IS NULL;";

		ResultSet response = null;

		// =1=> connexion a la BD
		DBAction.DBConnexion();

		try {
			response = DBAction.getStm().executeQuery(request);

			while (response.next()) {
				Chambre chamtmp = new Chambre();
				chamtmp.setNo(response.getInt(1));
				chamtmp.setPrix(response.getFloat(2));
				listeChambres.add(chamtmp);

			}

			if (!response.isClosed()) {
				response.close();
			}
		} catch (SQLException e) {
			// listeChambres.add(chamtmp);
			e.printStackTrace();
		}
		return listeChambres;
	}

	/* ADD functions */
	public static int addChambre(Chambre newChambre) {
		int result = -1;
		String request = null;

		DBAction.DBConnexion();
		request = "INSERT INTO chambre (no, prix)" + " VALUES (" + newChambre.getNo() + "," + newChambre.getPrix()
				+ ") ";
		try {
			result = DBAction.getStm().executeUpdate(request);
		} catch (SQLException ex) {
			if (ex.getErrorCode() == 1062) {// la cle existe deje
				result = -2;
			}
			System.out.println(ex.getMessage());
		}

		DBAction.DBClose();
		return result;
	}

	/* UPDATE functions */

	public static int updateChambrePriceByNo(int no, float newPrice) {
		int result = -1;
		String request = null;
		DBAction.DBConnexion();
		request = "UPDATE chambre SET prix ='" + newPrice + "'WHERE no ='" + no + "'";
		try {
			result = DBAction.getStm().executeUpdate(request);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		DBAction.DBClose();

		return result;
	}

	/* DELETE functions */
	public static int deleteChambreByNo(int noChambre) {
		int result = -1;
		String request = null;
		// 1: connexion à la BD
		DBAction.DBConnexion();
		// 2: préparer ma requpete de suppression
		request = "DELETE FROM chambre WHERE no =" + noChambre + "";
		try {
			result = DBAction.getStm().executeUpdate(request);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		DBAction.DBClose();

		return result;
	}
}
