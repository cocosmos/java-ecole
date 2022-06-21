package com.crea.dev4.ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crea.dev4.ecole.model.beans.Inscrit;
import com.crea.dev4.ecole.model.utils.DBAction;

public class InscritDao {
	/**
	 * Get liste Inscrits
	 * @param num of eleve
	 * @return arraylist of all inscrit where num is the same than the param
	 */
	
	public static ArrayList<Inscrit> getInscritsByEleveNum(String num) {
		ArrayList<Inscrit> listeInscrits = new ArrayList<Inscrit>();
		String request = null;
		ResultSet response = null;
		// =1=> connexion a la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM inscrit WHERE num = '" + num + "'";
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La récupération du résultat dans un objet Livre
			while (response.next()) {
				Inscrit instmp = new Inscrit();
				instmp.setCode(response.getString(1));
				instmp.setNum(response.getString(2));
				instmp.setNote(response.getFloat(3));
				instmp.affiche();
				listeInscrits.add(instmp);
			}
			if (!response.isClosed()) {
				response.close();
			}

		} catch (SQLException l1) {

			l1.printStackTrace();
		}
		return listeInscrits;
	}


	/**
	 * Get all Inscrit
	 * @return arraylist of a total all inscrit
	 */
	public static ArrayList<Inscrit> getAllInscrit() {
		ArrayList<Inscrit> listeInscrit = new ArrayList<Inscrit>();
		String request = null;
		ResultSet response = null;

		// =1=> connexion a la BD
		DBAction.DBConnexion();
		request = "SELECT * FROM inscrit";
		try {
			response = DBAction.getStm().executeQuery(request);
			while (response.next()) {
				Inscrit instmp = new Inscrit();
				instmp.setCode(response.getString(1));
				instmp.setNum(response.getString(2));
				instmp.setNote(response.getFloat(3));
				instmp.affiche();
				listeInscrit.add(instmp);
			}
			if (!response.isClosed()) {
				response.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listeInscrit;
	}

	
	/**
	 * Delete Inscrit
	 * @param code de l'uv
	 * @param num de l'eleve
	 * @return code of error or succes
	 */
	public static int deleteInscritByCodeAndNum(String code, String num) {
		int result = -1;
		String request = null;
		// 1: connexion a la BD
		DBAction.DBConnexion();
		// 2: préparer ma requpete de suppression
		request = "DELETE FROM inscrit WHERE code = '" + code + "' AND num = '" + num + "'";
		try {
			result = DBAction.getStm().executeUpdate(request);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		DBAction.DBClose();

		return result;
	}

}
