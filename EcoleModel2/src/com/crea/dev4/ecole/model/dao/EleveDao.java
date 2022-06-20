package com.crea.dev4.ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.crea.dev4.ecole.model.beans.Eleve;
import com.crea.dev4.ecole.model.utils.DBAction;

public class EleveDao {

	/**
	 * Rï¿½cupï¿½rer un ï¿½lï¿½ve par son numï¿½ro
	 * 
	 * @param num : numero de l'ï¿½lï¿½ve
	 * @return : un Ã©lÃ¨ve retrouvï¿½ sinon null s'il n'est pas retrouvï¿½e sinon
	 *         un ï¿½lï¿½ve vide avec un age = -1 dans le cas d'une erreur
	 * 
	 */
	public static Eleve getEleveByNum(String num) {
		Eleve e = new Eleve();
		String request = null;
		ResultSet response = null;
		// =1=> connexion ï¿½ la BD
		DBAction.DBConnexion();
		// =2.1=> prï¿½parer notre requï¿½te sql SELECT
		request = "SELECT * FROM eleve WHERE num = \'" + num + "\'";
		// =2.2=> rï¿½cupï¿½rer un statement
		// =2.3=> executer une requï¿½te de selection "num"
//				request = "SELECT * FROM eleve WHERE num = \""+ num + "\"";
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La rï¿½cupï¿½ration du rï¿½sultat dans un objet Eleve
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
	 * @param numToFind : le numï¿½ro de l'ï¿½lï¿½ve ï¿½ charger dans la BD
	 * @return : Objet de mapping (wrapper) {Eleve, CodeAction} si Eleve retrouvï¿½
	 *         : (l'objet Eleve, CodeAction = 1) si Eleve non retrouvï¿½ : (null,
	 *         CodeAction = -1) si Exception SQL : (null, CodeAction = -2) [Cette
	 *         partie devrait ï¿½tre dï¿½veloppï¿½e plus en dï¿½tail]
	 * 
	 *         l'ï¿½lï¿½ve trouvï¿½, oubien null
	 * 
	 */

	/*
	 * public static EleveWrap getEleveByNum(String numToFind) { Eleve elevtmp = new
	 * Eleve(); ResultSet rs = null; EleveWrap elvMaptmp = new EleveWrap();
	 * elvMaptmp.setCodeaction(1);// trouvï¿½
	 * 
	 * // Se connecter ï¿½ la BD DBAction.DBConnexion(); // ecrire requete String
	 * requete = "Select * from Eleve where num = \'" + numToFind + "\'"; //
	 * recupï¿½rer un statment + executer une requete try { rs =
	 * DBAction.getStm().executeQuery(requete);
	 * 
	 * if (rs.next()) { // elevtmp.setNum(numToFind);
	 * elevtmp.setNum(rs.getString(1)); elevtmp.setNo(rs.getInt(2));
	 * elevtmp.setNom(rs.getString(3)); elevtmp.setAge(rs.getInt(4));
	 * elevtmp.setAdresse(rs.getString(5)); elvMaptmp.setElv(elevtmp); if
	 * (!rs.isClosed()) { rs.close(); } } else { elvMaptmp.setCodeaction(-1); // le
	 * code -1 est relatif ï¿½ une execution correcte mais ï¿½ un eleve non //
	 * existant } } catch (SQLException e) { elvMaptmp.setCodeaction(-2);// une
	 * erreur SQL e.printStackTrace(); } // rï¿½cupï¿½rer le rï¿½sultat //
	 * vï¿½rifier que le nombre d'uplet = 1 return elvMaptmp; }
	 */
	/***
	 * 
	 * @param nomEleve
	 * @return un nombre d'ï¿½lï¿½ment = 0 ( "nom d'ï¿½lï¿½ve" non existant) un
	 *         nombre d'ï¿½lï¿½ment = 1 et un age = -1 du premier objet de la liste
	 *         retourï¿½e dans le cas d'une erreur SQL [Cette partie devrait ï¿½tre
	 *         dï¿½veloppï¿½e plus en dï¿½tail] sinon la liste des ï¿½lï¿½ve
	 *         correpondant au nom recherchï¿½
	 */
	public static ArrayList<Eleve> getElevesByNom(String nomEleve) {
		ArrayList<Eleve> lstelevtmp = new ArrayList<Eleve>();
		ResultSet rs = null;
		Eleve elevtmp = new Eleve();
		int i = 0;
		// Se connecter ï¿½ la BD
		DBAction.DBConnexion();
		// ecrire requete
		String requete = "Select * from Eleve where nom = \'" + nomEleve + "\'";
		// System.out.println("******* " + requete + "***********");
		// recupï¿½rer un statment + executer une requete
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
		// rï¿½cupï¿½rer le rï¿½sultat
		// vï¿½rifier que le nombre d'uplet = 1
		return lstelevtmp;
	}

	/**
	 * Rï¿½cupï¿½rer les ï¿½lï¿½ves par leurs numï¿½ro de chambre ;
	 * 
	 * @param no_ch : numï¿½ro de chambre
	 * @return : une liste d'ï¿½lï¿½ves retrouvï¿½s sinon null
	 */
	public static ArrayList<Eleve> getEleveByNo(int no) throws SQLException {
		// Création de ma liste d'ï¿½lï¿½ve partageant la mï¿½me chambre
		ArrayList<Eleve> listEleveNo = new ArrayList<Eleve>();

		String req = "SELECT num, no, nom, age, adresse FROM eleve where no = " + no + " ";
		// Connexion
		DBAction.DBConnexion();// System.out.println(req);

		// exécution de la requï¿½te et init
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
	 * Supprimer un ï¿½lï¿½ve par son numï¿½ro
	 * 
	 * @param num : numï¿½ro de l'ï¿½lï¿½ve ï¿½ supprimer
	 * @return : 1 si l'ï¿½lï¿½ve a ï¿½tï¿½ retrouvï¿½ et surpprimï¿½, sinon -1
	 *         oubien le code d'ï¿½rreur s'il y a eu une erreur ï¿½ l'ï¿½chelle de
	 *         la BD
	 */
	public static int deleteEleveBynum(String num) {
		int result = -1;
		// 1: connexion ï¿½ la BD
		DBAction.DBConnexion();
		// 2: prï¿½parer ma requpete de suppression
		String req = "DELETE FROM eleve WHERE num = '" + num + "' ";
		try {
			result = DBAction.getStm().executeUpdate(req);
			System.out.println("Requete executï¿½e");
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
	 * Mettre ï¿½ jour lï¿½adresse dï¿½un ï¿½lï¿½ve identifiï¿½ par son numï¿½ro
	 * 
	 * @param num        : le numï¿½ro de l'ï¿½lï¿½ve
	 * @param newAdresse : la nouvelle adresse ï¿½ mettre ï¿½ jour
	 * @return 1 si mise ï¿½ jour oubien 0 si rien n'a ï¿½tï¿½ mis ï¿½ jour sinon
	 *         -code_erreur s'il y a eu une erreur ï¿½ l'ï¿½chelle de la BD
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
	 * Mettre ï¿½ jour le numï¿½ro dï¿½un ï¿½lï¿½ve identifiï¿½ par son numï¿½ro
	 * 
	 * @param num   : le numï¿½ro de l'ï¿½lï¿½ve
	 * @param newNo : la nouvelle chambre
	 * @return 1 si mise ï¿½ jour oubien 0 oubien code d'ï¿½rreur s'il y a eu une
	 *         erreur ï¿½ l'ï¿½chelle de la BD
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
	 * Ajouter un nouvel ï¿½lï¿½ve
	 * 
	 * @param new_eleve : le nouvel elï¿½ve ï¿½ jouter
	 * @return 1 si ajout 0 sinon oubien le code d'ï¿½rreur s'il y a eu une erreur
	 *         ï¿½ l'ï¿½chelle de la B
	 */
	public static int addEleve(Eleve new_eleve) {
		int result = -1;
		DBAction.DBConnexion();

		String req = "INSERT INTO eleve (num, no, nom, age, adresse)" + " VALUES ('" + new_eleve.getNum() + "',NULL,'"
				+ new_eleve.getNom() + "'," + new_eleve.getAge() + ",'" + new_eleve.getAdresse() + "') ";
		try {
			result = DBAction.getStm().executeUpdate(req);
		} catch (SQLException ex) {
			if (ex.getErrorCode() == 1062) {// la clï¿½ existe dï¿½jï¿½
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
	 * Rï¿½cupï¿½rer un ensemble dï¿½ï¿½lï¿½ve qui ont la mï¿½me date de naissance
	 * 
	 * @param d : date de naissance
	 * @return liste des ï¿½lï¿½ve oubien null si aucun ï¿½lï¿½ve ne correspond ï¿½
	 *         la date de naissance
	 */
	public static ArrayList<Eleve> getLstElevesByDateNaissance(int anneeNaissance) throws SQLException {
		ArrayList<Eleve> listEleveAnneeNaissance = new ArrayList<Eleve>();
		// on recupere l'annï¿½e en cours
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);

		// Variable ï¿½ passer en paramï¿½tre dans la requï¿½te pour avoir les
		// ï¿½lï¿½ves d'une
		// tranche d'age:
		// Je fais la diffï¿½rence entre l'annï¿½e en cours et l'annï¿½e passï¿½e en
		// paramï¿½tre
		// de la fonction.
		int anneeNaissanceEleves = year - anneeNaissance;
		String req = "SELECT num, no, nom, age, adresse FROM eleve WHERE age =" + anneeNaissanceEleves + " ";
		// Connexion
		DBAction.DBConnexion();
		// exï¿½cution de la requï¿½te et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));

		while (DBAction.getRes().next()) {
			// int i = 0;
			// Instanciation de mon objet Eleve
			Eleve elevTemp = new Eleve();
			// Creation de l'objet eleveTemp ï¿½ travers le ResultSet BD
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
	 * Rï¿½cupï¿½rer la liste de tout les ï¿½lï¿½ves
	 * 
	 * @return la liste de tout les ï¿½lï¿½ves
	 */
	public static ArrayList<Eleve> getAllEleves() throws SQLException {
		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();

		String req = "SELECT num, no, nom, age, adresse FROM eleve ";
		// Connexion
		DBAction.DBConnexion();
		// exï¿½cution de la requï¿½te et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));

		while (DBAction.getRes().next()) {
			// int i = 0;
			// Instanciation de mon objet Eleve
			Eleve elevTemp = new Eleve();
			// Creation de l'objet eleveTemp ï¿½ travers le ResultSet BD
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
