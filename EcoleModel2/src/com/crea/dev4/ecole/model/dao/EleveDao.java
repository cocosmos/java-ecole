package com.crea.dev4.ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.crea.dev4.ecole.model.beans.Eleve;
import com.crea.dev4.ecole.model.utils.DBAction;

public class EleveDao {

	/**
	 * Recuperer un eleve par son numero
	 * 
	 * @param num : numero de l'eleve
	 * @return : un élève retrouve sinon null s'il n'est pas retrouvee sinon un
	 *         eleve vide avec un age = -1 dans le cas d'une erreur
	 * 
	 */
	public static Eleve getEleveByNum(String num) {
		Eleve e = new Eleve();
		String request = null;
		ResultSet response = null;
		// =1=> connexion e la BD
		DBAction.DBConnexion();
		// =2.1=> preparer notre requete sql SELECT
		request = "SELECT * FROM eleve WHERE num = \'" + num + "\'";
		// =2.2=> recuperer un statement
		// =2.3=> executer une requete de selection "num"
//				request = "SELECT * FROM eleve WHERE num = \""+ num + "\"";
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La recuperation du resultat dans un objet Eleve
			if (response.next()) {
				e.setNum(response.getString(1));
				e.setNo(response.getInt(2));
				e.setNom(response.getString(3));
				e.setAge(response.getInt(4));
				e.setAdresse(response.getString(5));
				e.affiche();
			} else {
				e = null;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			e.setAge(-1);
		}
		// Fermeture de la connexion
		DBAction.DBClose();
		return e;
	}

	/***
	 * 
	 * @param nomEleve
	 * @return un nombre d'element = 0 ( "nom d'eleve" non existant) un nombre
	 *         d'element = 1 et un age = -1 du premier objet de la liste retouree
	 *         dans le cas d'une erreur SQL [Cette partie devrait etre developpee
	 *         plus en detail] sinon la liste des eleve correpondant au nom
	 *         recherche
	 */
	public static ArrayList<Eleve> getElevesByNom(String nomEleve) {
		ArrayList<Eleve> lstelevtmp = new ArrayList<Eleve>();
		ResultSet rs = null;
		Eleve elevtmp = new Eleve();

		// Se connecter e la BD
		DBAction.DBConnexion();
		// ecrire requete
		String requete = "Select * from Eleve where nom = \'" + nomEleve + "\'";
		// System.out.println("******* " + requete + "***********");
		// recuperer un statment + executer une requete
		try {
			rs = DBAction.getStm().executeQuery(requete);
			while (rs.next()) {
				elevtmp.setNum(rs.getString(1));
				elevtmp.setNo(rs.getInt(2));
				elevtmp.setNom(rs.getString(3));
				elevtmp.setAge(rs.getInt(4));
				elevtmp.setAdresse(rs.getString(5));
				lstelevtmp.add(elevtmp);

			}
			if (!rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			elevtmp.setAge(-1);
			lstelevtmp.add(elevtmp);
			e.printStackTrace();
		}
		// recuperer le resultat
		// verifier que le nombre d'uplet = 1
		// Fermeture de la connexion
		DBAction.DBClose();
		return lstelevtmp;
	}

	/**
	 * Recuperer les eleves par leurs numero de chambre ;
	 * 
	 * @param no_ch : numero de chambre
	 * @return : une liste d'eleves retrouves sinon null
	 */
	public static ArrayList<Eleve> getEleveByNo(int no) throws SQLException {
		// Creation de ma liste d'eleve partageant la meme chambre
		ArrayList<Eleve> listEleveNo = new ArrayList<Eleve>();

		String req = "SELECT num, no, nom, age, adresse FROM eleve where no = " + no + " ";
		// Connexion
		DBAction.DBConnexion();// System.out.println(req);

		// execution de la requete et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));

		// Creation de l'objet eleveTemp e travers le ResultSet BD
		while (DBAction.getRes().next()) {
			Eleve elevTemp = new Eleve();
			// Creation de l'objet eleveTemp e travers le ResultSet BD
			elevTemp.setNum(DBAction.getRes().getString(1));
			elevTemp.setNo(DBAction.getRes().getInt(2));
			elevTemp.setNom(DBAction.getRes().getString(3));
			elevTemp.setAge(DBAction.getRes().getInt(4));
			elevTemp.setAdresse(DBAction.getRes().getString(5));
			listEleveNo.add(elevTemp);
		}

		// Fermeture de la connexion
		DBAction.DBClose();
		// Retourner l'objet ElevTemp
		return listEleveNo;
	}

	/**
	 * Supprimer un eleve par son numero
	 * 
	 * @param num : numero de l'eleve e supprimer
	 * @return : 1 si l'eleve a ete retrouve et surpprime, sinon -1 oubien le code
	 *         d'erreur s'il y a eu une erreur e l'echelle de la BD
	 */
	public static int deleteEleveBynum(String num) {
		int result = -1;
		// 1: connexion e la BD
		DBAction.DBConnexion();
		// 2: preparer ma requpete de suppression
		String req = "DELETE FROM eleve WHERE num = '" + num + "' ";
		try {
			result = DBAction.getStm().executeUpdate(req);
			System.out.println("Requete executee");
		} catch (SQLException ex) {
			result = -ex.getErrorCode();
			System.out.println(ex.getMessage());
		}
		// System.out.println("[" + req + "] Suppression : Valeur de result = " +
		// result);
		DBAction.DBClose();
		return result;
	}

	/**
	 * Mettre e jour leadresse deun eleve identifie par son numero
	 * 
	 * @param num        : le numero de l'eleve
	 * @param newAdresse : la nouvelle adresse e mettre e jour
	 * @return 1 si mise e jour oubien 0 si rien n'a ete mis e jour sinon
	 *         -code_erreur s'il y a eu une erreur e l'echelle de la BD
	 */
	public static int updateEleveAdresseBynum(String num, String newAdresse) {
		int result = -1;
		DBAction.DBConnexion();
		String req = "UPDATE eleve SET adresse = '" + newAdresse + "' WHERE num ='" + num + "' ";
		try {
			result = DBAction.getStm().executeUpdate(req);
			System.out.println("Requete executee");
		} catch (SQLException ex) {
			result = -ex.getErrorCode();
		}

		DBAction.DBClose();
		return result;
	}

	/**
	 * Mettre e jour le numero deun eleve identifie par son numero
	 * 
	 * @param num   : le numero de l'eleve
	 * @param newNo : la nouvelle chambre
	 * @return 1 si mise e jour oubien 0 oubien code d'erreur s'il y a eu une erreur
	 *         e l'echelle de la BD
	 */
	public static int updateEleveNumChambreBynum(String num, int newNo) {
		int result = -1;
		DBAction.DBConnexion();

		String req = "UPDATE eleve SET no = " + newNo + " WHERE num ='" + num + "' ";
		try {
			result = DBAction.getStm().executeUpdate(req);
			System.out.println("Requete executee");
		} catch (SQLException ex) {
			result = -ex.getErrorCode();
		}
		DBAction.DBClose();
		return result;
	}

	/**
	 * Ajouter un nouvel eleve
	 * 
	 * @param new_eleve : le nouvel eleve e jouter
	 * @return 1 si ajout 0 sinon oubien le code d'erreur s'il y a eu une erreur e
	 *         l'echelle de la B
	 */
	public static int addEleve(Eleve new_eleve) {
		int result = -1;
		DBAction.DBConnexion();

		String req = "INSERT INTO eleve (num, no, nom, age, adresse)" + " VALUES ('" + new_eleve.getNum() + "',NULL,'"
				+ new_eleve.getNom() + "'," + new_eleve.getAge() + ",'" + new_eleve.getAdresse() + "') ";
		try {
			result = DBAction.getStm().executeUpdate(req);
		} catch (SQLException ex) {
			if (ex.getErrorCode() == 1062) {// la cle existe deje
				result = -2;
			}
			System.out.println(ex.getMessage());
		}
		// System.out.println("["+req+"] Valeur de result == "+result);
		// System.out.println(req);
		DBAction.DBClose();
		return result;
	}

	/**
	 * Recuperer un ensemble deeleve qui ont la meme date de naissance
	 * 
	 * @param d : date de naissance
	 * @return liste des eleve oubien null si aucun eleve ne correspond e la date de
	 *         naissance
	 */
	public static ArrayList<Eleve> getLstElevesByDateNaissance(int anneeNaissance) throws SQLException {
		ArrayList<Eleve> listEleveAnneeNaissance = new ArrayList<Eleve>();
		// on recupere l'annee en cours
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);

		// Variable e passer en parametre dans la requete pour avoir les
		// eleves d'une
		// tranche d'age:
		// Je fais la difference entre l'annee en cours et l'annee passee en
		// parametre
		// de la fonction.
		int anneeNaissanceEleves = year - anneeNaissance;
		String req = "SELECT num, no, nom, age, adresse FROM eleve WHERE age =" + anneeNaissanceEleves + " ";
		// Connexion
		DBAction.DBConnexion();
		// execution de la requete et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));

		while (DBAction.getRes().next()) {
			// int i = 0;
			// Instanciation de mon objet Eleve
			Eleve elevTemp = new Eleve();
			// Creation de l'objet eleveTemp e travers le ResultSet BD
			elevTemp.setNum(DBAction.getRes().getString(1));
			elevTemp.setNo(DBAction.getRes().getInt(2));
			elevTemp.setNom(DBAction.getRes().getString(3));
			elevTemp.setAge(DBAction.getRes().getInt(4));
			elevTemp.setAdresse(DBAction.getRes().getString(5));
			listEleveAnneeNaissance.add(elevTemp);
			// i = i + 1;
		}
		// Fermeture de la connexion
		DBAction.DBClose();
		return listEleveAnneeNaissance;
	}

	/**
	 * Recuperer la liste de tout les eleves
	 * 
	 * @return la liste de tout les eleves
	 */
	public static ArrayList<Eleve> getAllEleves() throws SQLException {
		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();

		String req = "SELECT num, no, nom, age, adresse FROM eleve ";
		// Connexion
		DBAction.DBConnexion();
		// execution de la requete et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));

		while (DBAction.getRes().next()) {
			// int i = 0;
			// Instanciation de mon objet Eleve
			Eleve elevTemp = new Eleve();
			// Creation de l'objet eleveTemp a travers le ResultSet BD
			elevTemp.setNum(DBAction.getRes().getString(1));
			elevTemp.setNo(DBAction.getRes().getInt(2));
			elevTemp.setNom(DBAction.getRes().getString(3));
			elevTemp.setAge(DBAction.getRes().getInt(4));
			elevTemp.setAdresse(DBAction.getRes().getString(5));
			listEleve.add(elevTemp);
			// i = i + 1;
		}
		// Fermeture de la connexion
		DBAction.DBClose();
		return listEleve;
	}
}
