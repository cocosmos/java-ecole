package com.crea.dev4.ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crea.dev4.ecole.model.beans.Inscrit;
import com.crea.dev4.ecole.model.utils.DBAction;

public class InscritDao {
	/* GET Functions */
	// Get liste Inscrits
	public static ArrayList<Inscrit> getInscritsByEleveNum(String num) {
		ArrayList<Inscrit> listeInscrits = new ArrayList<Inscrit>();
		String request = null;
		ResultSet response = null;
		int i = 0;
		Inscrit instmp = new Inscrit();
		// =1=> connexion � la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM inscrit WHERE num = " + num;
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La récupération du résultat dans un objet Livre
			while (response.next()) {
				instmp.setCode(response.getString(1));
				instmp.setNum(response.getString(2));
				instmp.setNote(response.getFloat(3));
				instmp.affiche();
				i++;
			}
			if (!response.isClosed()) {
				response.close();
			}

		} catch (SQLException l1) {
			listeInscrits.add(instmp);
			l1.printStackTrace();
		}
		return listeInscrits;
	}

	// get all Inscrit
	public static ArrayList<Inscrit> getAllInscrit() {
		ArrayList<Inscrit> listeInscrit = new ArrayList<Inscrit>();
		String request = null;
		ResultSet response = null;
		int i = 0;
		Inscrit instmp = new Inscrit();
		// =1=> connexion à la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM inscrit";
		try {
			response = DBAction.getStm().executeQuery(request);
			while (response.next()) {
				instmp.setCode(response.getString(1));
				instmp.setNum(response.getString(2));
				instmp.setNote(response.getFloat(3));
				instmp.affiche();
				i++;
			}
			if (!response.isClosed()) {
				response.close();
			}
		} catch (SQLException e) {
			listeInscrit.add(instmp);
			e.printStackTrace();
		}
		return listeInscrit;
	}

	/* Delete Inscrit */
	public static int deleteInscritByCodeAndNum(String code, String num) {
		int result = -1;
		String request = null;
		// 1: connexion � la BD
		DBAction.DBConnexion();
		// 2: préparer ma requpete de suppression
		request = "DELETE FROM inscrit WHERE code = '"+code+"' AND num = '"+num+"'";
		try {
			result = DBAction.getStm().executeUpdate(request);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		DBAction.DBClose();

		return result;
	}

}
