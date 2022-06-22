package com.crea.dev4.ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.crea.dev4.ecole.model.beans.Livre;
import com.crea.dev4.ecole.model.utils.DBAction;

public class LivreDao {
	/**
	 * Formatter of datetime reusable
	 */
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");

	// get livre by cote
	public static Livre getLivreByCote(String cote) {
		Livre l = new Livre();
		String request = null;
		ResultSet response = null;
		// =1=> connexion è la BD
		DBAction.DBConnexion();
		// =2.1=> preparer notre requète sql SELECT
		request = "SELECT * FROM livre WHERE cote = \'" + cote + "\'";
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La recuperation du resultat dans un objet Livre
			if (response.next()) {
				l.setCote(response.getString(1));
				l.setNum(response.getString(2));
				l.setTitre(response.getString(3));
				if (response.getString(4) != null) {
					l.setDatepret(LocalDateTime.parse(response.getString(4), formatter));
				} else {
					l.setDatepret(null);
				}

				l.affiche();
			} else {
				l = null;
			}
		} catch (SQLException l1) {
			l1.printStackTrace();
		}
		return l;
	}

	// Get liste livres
	public static ArrayList<Livre> getLivresByEleveNum(String num) {
		ArrayList<Livre> listeLivres = new ArrayList<Livre>();
		String request = null;
		ResultSet response = null;

		// =1=> connexion è la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM livre WHERE num = '" + num + "'";
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La recuperation du resultat dans un objet Livre
			while (response.next()) {
				Livre l = new Livre();
				l.setCote(response.getString(1));
				l.setNum(response.getString(2));
				l.setTitre(response.getString(3));
				if (response.getString(4) != null) {
					l.setDatepret(LocalDateTime.parse(response.getString(4), formatter));
				} else {
					l.setDatepret(null);
				}
				l.affiche();
				listeLivres.add(l);

			}
			if (!response.isClosed()) {
				response.close();
			}

		} catch (SQLException l1) {

			l1.printStackTrace();
		}
		return listeLivres;
	}

	// Get liste livres available
	public static ArrayList<Livre> getLivresAvailable() {
		ArrayList<Livre> listeLivres = new ArrayList<Livre>();
		String request = null;
		ResultSet response = null;

		// =1=> connexion è la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM livre WHERE num is NULL";
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La recuperation du resultat dans un objet Livre
			while (response.next()) {
				Livre l = new Livre();
				l.setCote(response.getString(1));
				l.setNum(response.getString(2));
				l.setTitre(response.getString(3));
				if (response.getString(4) != null) {
					l.setDatepret(LocalDateTime.parse(response.getString(4), formatter));
				} else {
					l.setDatepret(null);
				}
				l.affiche();
				listeLivres.add(l);

			}
			if (!response.isClosed()) {
				response.close();
			}

		} catch (SQLException l1) {

			l1.printStackTrace();
		}
		return listeLivres;
	}

	// Get all livres
	public static ArrayList<Livre> getAllLivres() {
		ArrayList<Livre> listeLivres = new ArrayList<Livre>();
		String request = null;
		ResultSet response = null;

		// =1=> connexion à la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM livre";
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La recuperation du resultat dans un objet Livre
			while (response.next()) {
				Livre l = new Livre();
				l.setCote(response.getString(1));
				l.setNum(response.getString(2));
				l.setTitre(response.getString(3));
				if (response.getString(4) != null) {
					l.setDatepret(LocalDateTime.parse(response.getString(4), formatter));
				} else {
					l.setDatepret(null);
				}
				l.affiche();
				listeLivres.add(l);

			}
			if (!response.isClosed()) {
				response.close();
			}

		} catch (SQLException l1) {

			l1.printStackTrace();
		}
		return listeLivres;
	}

	/* ADD Functions */
	public static int addLivre(Livre newLivre) {
		int result = -1;
		String request = null;

		DBAction.DBConnexion();
		request = "INSERT INTO livre (cote, titre) VALUES ('" + newLivre.getCote() + "','" + newLivre.getTitre()
				+ "') ";
		try {
			result = DBAction.getStm().executeUpdate(request);
		} catch (SQLException ex) {
			if (ex.getErrorCode() == 1062) {// la cle existe deja
				result = -2;
			}
			System.out.println(ex.getMessage());
		}

		DBAction.DBClose();
		return result;
	}

	/* UPDATE Functions */
	public static int updateLivreTitreByCote(String cote, String newTitre) {
		int result = -1;
		String request = null;
		DBAction.DBConnexion();
		request = "UPDATE livre SET titre ='" + newTitre + "'WHERE cote ='" + cote + "'";
		try {
			result = DBAction.getStm().executeUpdate(request);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		DBAction.DBClose();

		return result;
	}

	// Update num by num and livre by cote
	public static int updateLivreNumByCote(String cote, String newNum) {
		int result = -1;
		String request = null;
		DBAction.DBConnexion();
		LocalDateTime dateTime = LocalDateTime.now();
		java.sql.Timestamp sqlDate = java.sql.Timestamp.valueOf(dateTime);

		if (newNum == null) { // rends son emprunt
			request = "UPDATE livre SET num = NULL, datepret = NULL WHERE cote ='" + cote + "'";
		} else {// emprunte ou change d'umprinter
			request = "UPDATE livre SET num = '" + newNum + "', datepret = '" + sqlDate + "' WHERE cote ='" + cote
					+ "'";
		}
		try {
			result = DBAction.getStm().executeUpdate(request);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		DBAction.DBClose();

		return result;
	}

	/* DELETE Functions */
	public static int deleteLivreByNo(String cote) {
		int result = -1;
		String request = null;
		// 1: connexion Ã  la BD
		DBAction.DBConnexion();
		// 2: preparer ma requpete de suppression
		request = "DELETE FROM livre WHERE cote ='" + cote + "'";
		try {
			result = DBAction.getStm().executeUpdate(request);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		DBAction.DBClose();

		return result;
	}

}
