package com.crea.dev4.ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crea.dev4.ecole.model.beans.Livre;
import com.crea.dev4.ecole.model.utils.DBAction;

public class LivreDao {
	/* GET Functions */
	// get livre by cote
	public static Livre getLivreByCote(String cote) {
		Livre l = new Livre();
		String request = null;
		ResultSet response = null;
		// =1=> connexion � la BD
		DBAction.DBConnexion();
		// =2.1=> préparer notre requ�te sql SELECT
		request = "SELECT * FROM livre WHERE cote = \'" + cote + "\'";
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La récupération du résultat dans un objet Livre
			if (response.next()) {
				l.setCote(response.getString(1));
				l.setNum(response.getString(2));
				l.setTitre(response.getString(3));
				l.setDatepret(response.getDate(4));
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
		int i = 0;

		// =1=> connexion � la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM livre WHERE num = " + num;
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La récupération du résultat dans un objet Livre
			while (response.next()) {
				Livre l = new Livre();
				l.setCote(response.getString(1));
				l.setNum(response.getString(2));
				l.setTitre(response.getString(3));
				l.setDatepret(response.getDate(4));
				l.affiche();
				listeLivres.add(l);
				i++;
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
		int i = 0;

		// =1=> connexion � la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM livre WHERE num is NULL";
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La récupération du résultat dans un objet Livre
			while (response.next()) {
				Livre l = new Livre();
				l.setCote(response.getString(1));
				l.setNum(response.getString(2));
				l.setTitre(response.getString(3));
				l.setDatepret(response.getDate(4));
				l.affiche();
				listeLivres.add(l);
				i++;
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
		int i = 0;

		// =1=> connexion � la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM livre";
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La récupération du résultat dans un objet Livre
			while (response.next()) {
				Livre l = new Livre();
				l.setCote(response.getString(1));
				l.setNum(response.getString(2));
				l.setTitre(response.getString(3));
				l.setDatepret(response.getDate(4));
				l.affiche();
				listeLivres.add(l);
				i++;
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
			if (ex.getErrorCode() == 1062) {// la clé existe déja
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
		request = "UPDATE livre SET num ='" + newNum + "'WHERE cote ='" + cote + "'";
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
		// 1: connexion à la BD
		DBAction.DBConnexion();
		// 2: préparer ma requpete de suppression
		request = "DELETE FROM livre WHERE no ='" + cote + "'";
		try {
			result = DBAction.getStm().executeUpdate(request);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		DBAction.DBClose();

		return result;
	}

}
