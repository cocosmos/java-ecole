package com.crea.dev4.ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.crea.dev4.ecole.model.beans.Eleve;
import com.crea.dev4.ecole.model.utils.DBAction;

public class EleveDao {

	/**
	 * Récupérer un éléve par son numéro
	 * 
	 * @param num : numero de l'éléve
	 * @return : un Ã©lÃ¨ve retrouvé sinon null s'il n'est pas retrouvée sinon un
	 *         éléve vide avec un age = -1 dans le cas d'une erreur
	 * 
	 */
	public static Eleve getEleveByNum(String num) {
		Eleve e = new Eleve();
		String request = null;
		ResultSet response = null;
		// =1=> connexion é la BD
		DBAction.DBConnexion();
		// =2.1=> préparer notre requéte sql SELECT
		request = "SELECT * FROM eleve WHERE num = \'" + num + "\'";
		// =2.2=> récupérer un statement
		// =2.3=> executer une requéte de selection "num"
//				request = "SELECT * FROM eleve WHERE num = \""+ num + "\"";
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La récupération du résultat dans un objet Eleve
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
		return e;
	}

	/**
	 * 
	 * @param numToFind : le numéro de l'éléve é charger dans la BD
	 * @return : Objet de mapping (wrapper) {Eleve, CodeAction} si Eleve retrouvé :
	 *         (l'objet Eleve, CodeAction = 1) si Eleve non retrouvé : (null,
	 *         CodeAction = -1) si Exception SQL : (null, CodeAction = -2) [Cette
	 *         partie devrait étre développée plus en détail]
	 * 
	 *         l'éléve trouvé, oubien null
	 * 
	 */

	/*
	 * public static EleveWrap getEleveByNum(String numToFind) { Eleve elevtmp = new
	 * Eleve(); ResultSet rs = null; EleveWrap elvMaptmp = new EleveWrap();
	 * elvMaptmp.setCodeaction(1);// trouvé
	 * 
	 * // Se connecter é la BD DBAction.DBConnexion(); // ecrire requete String
	 * requete = "Select * from Eleve where num = \'" + numToFind + "\'"; //
	 * recupérer un statment + executer une requete try { rs =
	 * DBAction.getStm().executeQuery(requete);
	 * 
	 * if (rs.next()) { // elevtmp.setNum(numToFind);
	 * elevtmp.setNum(rs.getString(1)); elevtmp.setNo(rs.getInt(2));
	 * elevtmp.setNom(rs.getString(3)); elevtmp.setAge(rs.getInt(4));
	 * elevtmp.setAdresse(rs.getString(5)); elvMaptmp.setElv(elevtmp); if
	 * (!rs.isClosed()) { rs.close(); } } else { elvMaptmp.setCodeaction(-1); // le
	 * code -1 est relatif é une execution correcte mais é un eleve non // existant
	 * } } catch (SQLException e) { elvMaptmp.setCodeaction(-2);// une erreur SQL
	 * e.printStackTrace(); } // récupérer le résultat // vérifier que le nombre
	 * d'uplet = 1 return elvMaptmp; }
	 */
	/***
	 * 
	 * @param nomEleve
	 * @return un nombre d'élément = 0 ( "nom d'éléve" non existant) un nombre
	 *         d'élément = 1 et un age = -1 du premier objet de la liste retourée
	 *         dans le cas d'une erreur SQL [Cette partie devrait étre développée
	 *         plus en détail] sinon la liste des éléve correpondant au nom
	 *         recherché
	 */
	public static ArrayList<Eleve> getElevesByNom(String nomEleve) {
		ArrayList<Eleve> lstelevtmp = new ArrayList<Eleve>();
		ResultSet rs = null;
		Eleve elevtmp = new Eleve();
		int i = 0;
		// Se connecter é la BD
		DBAction.DBConnexion();
		// ecrire requete
		String requete = "Select * from Eleve where nom = \'" + nomEleve + "\'";
		// System.out.println("******* " + requete + "***********");
		// recupérer un statment + executer une requete
		try {
			rs = DBAction.getStm().executeQuery(requete);
			while (rs.next()) {
				elevtmp.setNum(rs.getString(1));
				elevtmp.setNo(rs.getInt(2));
				elevtmp.setNom(rs.getString(3));
				elevtmp.setAge(rs.getInt(4));
				elevtmp.setAdresse(rs.getString(5));
				lstelevtmp.add(elevtmp);
				i++;
			}
			if (!rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			elevtmp.setAge(-1);
			lstelevtmp.add(elevtmp);
			e.printStackTrace();
		}
		// récupérer le résultat
		// vérifier que le nombre d'uplet = 1
		return lstelevtmp;
	}

	/**
	 * Récupérer les éléves par leurs numéro de chambre ;
	 * 
	 * @param no_ch : numéro de chambre
	 * @return : une liste d'éléves retrouvés sinon null
	 */
	public static ArrayList<Eleve> getEleveByNo(int no) throws SQLException {
		// Création de ma liste d'éléve partageant la méme chambre
		ArrayList<Eleve> listEleveNo = new ArrayList<Eleve>();

		String req = "SELECT num, no, nom, age, adresse FROM eleve where no = " + no + " ";
		// Connexion
		DBAction.DBConnexion();// System.out.println(req);

		// exécution de la requéte et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));

		// Creation de l'objet eleveTemp à travers le ResultSet BD
		while (DBAction.getRes().next()) {
			Eleve elevTemp = new Eleve();
			// Creation de l'objet eleveTemp à travers le ResultSet BD
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
	 * Supprimer un éléve par son numéro
	 * 
	 * @param num : numéro de l'éléve é supprimer
	 * @return : 1 si l'éléve a été retrouvé et surpprimé, sinon -1 oubien le code
	 *         d'érreur s'il y a eu une erreur é l'échelle de la BD
	 */
	public static int deleteEleveBynum(String num) {
		int result = -1;
		// 1: connexion é la BD
		DBAction.DBConnexion();
		// 2: préparer ma requpete de suppression
		String req = "DELETE FROM eleve WHERE num = '" + num + "' ";
		try {
			result = DBAction.getStm().executeUpdate(req);
			System.out.println("Requete executée");
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
	 * Mettre é jour léadresse déun éléve identifié par son numéro
	 * 
	 * @param num        : le numéro de l'éléve
	 * @param newAdresse : la nouvelle adresse é mettre é jour
	 * @return 1 si mise é jour oubien 0 si rien n'a été mis é jour sinon
	 *         -code_erreur s'il y a eu une erreur é l'échelle de la BD
	 */
	public static int updateEleveAdresseBynum(String num, String newAdresse) throws SQLException {
		int result = -1;
		DBAction.DBConnexion();
		String req = "UPDATE eleve SET adresse = '" + newAdresse + "' WHERE num ='" + num + "' ";
		result = DBAction.getStm().executeUpdate(req);
		// System.out.println("Requete executee");
		DBAction.DBClose();
		return result;
	}

	/**
	 * Mettre é jour le numéro déun éléve identifié par son numéro
	 * 
	 * @param num   : le numéro de l'éléve
	 * @param newNo : la nouvelle chambre
	 * @return 1 si mise é jour oubien 0 oubien code d'érreur s'il y a eu une erreur
	 *         é l'échelle de la BD
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
	 * Ajouter un nouvel éléve
	 * 
	 * @param new_eleve : le nouvel eléve é jouter
	 * @return 1 si ajout 0 sinon oubien le code d'érreur s'il y a eu une erreur é
	 *         l'échelle de la B
	 */
	public static int addEleve(Eleve new_eleve) {
		int result = -1;
		DBAction.DBConnexion();

		String req = "INSERT INTO eleve (num, no, nom, age, adresse)" + " VALUES ('" + new_eleve.getNum() + "',NULL,'"
				+ new_eleve.getNom() + "'," + new_eleve.getAge() + ",'" + new_eleve.getAdresse() + "') ";
		try {
			result = DBAction.getStm().executeUpdate(req);
		} catch (SQLException ex) {
			if (ex.getErrorCode() == 1062) {// la clé existe déjé
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
	 * Récupérer un ensemble dééléve qui ont la méme date de naissance
	 * 
	 * @param d : date de naissance
	 * @return liste des éléve oubien null si aucun éléve ne correspond é la date de
	 *         naissance
	 */
	public static ArrayList<Eleve> getLstElevesByDateNaissance(int anneeNaissance) throws SQLException {
		ArrayList<Eleve> listEleveAnneeNaissance = new ArrayList<Eleve>();
		// on recupere l'année en cours
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);

		// Variable é passer en paramétre dans la requéte pour avoir les
		// éléves d'une
		// tranche d'age:
		// Je fais la différence entre l'année en cours et l'année passée en
		// paramétre
		// de la fonction.
		int anneeNaissanceEleves = year - anneeNaissance;
		String req = "SELECT num, no, nom, age, adresse FROM eleve WHERE age =" + anneeNaissanceEleves + " ";
		// Connexion
		DBAction.DBConnexion();
		// exécution de la requéte et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));

		while (DBAction.getRes().next()) {
			// int i = 0;
			// Instanciation de mon objet Eleve
			Eleve elevTemp = new Eleve();
			// Creation de l'objet eleveTemp é travers le ResultSet BD
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
	 * Récupérer la liste de tout les éléves
	 * 
	 * @return la liste de tout les éléves
	 */
	public static ArrayList<Eleve> getAllEleves() throws SQLException {
		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();

		String req = "SELECT num, no, nom, age, adresse FROM eleve ";
		// Connexion
		DBAction.DBConnexion();
		// exécution de la requéte et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));

		while (DBAction.getRes().next()) {
			// int i = 0;
			// Instanciation de mon objet Eleve
			Eleve elevTemp = new Eleve();
			// Creation de l'objet eleveTemp é travers le ResultSet BD
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
