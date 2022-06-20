package com.crea.dev4.ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.crea.dev4.ecole.model.beans.Eleve;
import com.crea.dev4.ecole.model.utils.DBAction;

public class EleveDao {

	/**
	 * R�cup�rer un �l�ve par son num�ro
	 * 
	 * @param num : numero de l'�l�ve
	 * @return : un élève retrouv� sinon null s'il n'est pas retrouv�e sinon
	 *         un �l�ve vide avec un age = -1 dans le cas d'une erreur
	 * 
	 */
	public static Eleve getEleveByNum(String num) {
		Eleve e = new Eleve();
		String request = null;
		ResultSet response = null;
		// =1=> connexion � la BD
		DBAction.DBConnexion();
		// =2.1=> pr�parer notre requ�te sql SELECT
		request = "SELECT * FROM eleve WHERE num = \'" + num + "\'";
		// =2.2=> r�cup�rer un statement
		// =2.3=> executer une requ�te de selection "num"
//				request = "SELECT * FROM eleve WHERE num = \""+ num + "\"";
		try {
			response = DBAction.getStm().executeQuery(request);
			// 3==> La r�cup�ration du r�sultat dans un objet Eleve
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
	 * @param numToFind : le num�ro de l'�l�ve � charger dans la BD
	 * @return : Objet de mapping (wrapper) {Eleve, CodeAction} si Eleve retrouv�
	 *         : (l'objet Eleve, CodeAction = 1) si Eleve non retrouv� : (null,
	 *         CodeAction = -1) si Exception SQL : (null, CodeAction = -2) [Cette
	 *         partie devrait �tre d�velopp�e plus en d�tail]
	 * 
	 *         l'�l�ve trouv�, oubien null
	 * 
	 */

	/*
	 * public static EleveWrap getEleveByNum(String numToFind) { Eleve elevtmp = new
	 * Eleve(); ResultSet rs = null; EleveWrap elvMaptmp = new EleveWrap();
	 * elvMaptmp.setCodeaction(1);// trouv�
	 * 
	 * // Se connecter � la BD DBAction.DBConnexion(); // ecrire requete String
	 * requete = "Select * from Eleve where num = \'" + numToFind + "\'"; //
	 * recup�rer un statment + executer une requete try { rs =
	 * DBAction.getStm().executeQuery(requete);
	 * 
	 * if (rs.next()) { // elevtmp.setNum(numToFind);
	 * elevtmp.setNum(rs.getString(1)); elevtmp.setNo(rs.getInt(2));
	 * elevtmp.setNom(rs.getString(3)); elevtmp.setAge(rs.getInt(4));
	 * elevtmp.setAdresse(rs.getString(5)); elvMaptmp.setElv(elevtmp); if
	 * (!rs.isClosed()) { rs.close(); } } else { elvMaptmp.setCodeaction(-1); // le
	 * code -1 est relatif � une execution correcte mais � un eleve non //
	 * existant } } catch (SQLException e) { elvMaptmp.setCodeaction(-2);// une
	 * erreur SQL e.printStackTrace(); } // r�cup�rer le r�sultat //
	 * v�rifier que le nombre d'uplet = 1 return elvMaptmp; }
	 */
	/***
	 * 
	 * @param nomEleve
	 * @return un nombre d'�l�ment = 0 ( "nom d'�l�ve" non existant) un
	 *         nombre d'�l�ment = 1 et un age = -1 du premier objet de la liste
	 *         retour�e dans le cas d'une erreur SQL [Cette partie devrait �tre
	 *         d�velopp�e plus en d�tail] sinon la liste des �l�ve
	 *         correpondant au nom recherch�
	 */
	public static ArrayList<Eleve> getElevesByNom(String nomEleve) {
		ArrayList<Eleve> lstelevtmp = new ArrayList<Eleve>();
		ResultSet rs = null;
		Eleve elevtmp = new Eleve();
		int i = 0;
		// Se connecter � la BD
		DBAction.DBConnexion();
		// ecrire requete
		String requete = "Select * from Eleve where nom = \'" + nomEleve + "\'";
		// System.out.println("******* " + requete + "***********");
		// recup�rer un statment + executer une requete
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
		// r�cup�rer le r�sultat
		// v�rifier que le nombre d'uplet = 1
		return lstelevtmp;
	}

	/**
	 * R�cup�rer les �l�ves par leurs num�ro de chambre ;
	 * 
	 * @param no_ch : num�ro de chambre
	 * @return : une liste d'�l�ves retrouv�s sinon null
	 */
	public static ArrayList<Eleve> getEleveByNo(int no) throws SQLException {
		// Cr�ation de ma liste d'�l�ve partageant la m�me chambre
		ArrayList<Eleve> listEleveNo = new ArrayList<Eleve>();

		String req = "SELECT num, no, nom, age, adresse FROM eleve where no = " + no + " ";
		// Connexion
		DBAction.DBConnexion();// System.out.println(req);

		// ex�cution de la requ�te et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));

		// Creation de l'objet eleveTemp � travers le ResultSet BD
		while (DBAction.getRes().next()) {
			Eleve elevTemp = new Eleve();
			// Creation de l'objet eleveTemp � travers le ResultSet BD
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
	 * Supprimer un �l�ve par son num�ro
	 * 
	 * @param num : num�ro de l'�l�ve � supprimer
	 * @return : 1 si l'�l�ve a �t� retrouv� et surpprim�, sinon -1
	 *         oubien le code d'�rreur s'il y a eu une erreur � l'�chelle de
	 *         la BD
	 */
	public static int deleteEleveBynum(String num) {
		int result = -1;
		// 1: connexion � la BD
		DBAction.DBConnexion();
		// 2: pr�parer ma requpete de suppression
		String req = "DELETE FROM eleve WHERE num = '" + num + "' ";
		try {
			result = DBAction.getStm().executeUpdate(req);
			System.out.println("Requete execut�e");
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
	 * Mettre � jour l�adresse d�un �l�ve identifi� par son num�ro
	 * 
	 * @param num        : le num�ro de l'�l�ve
	 * @param newAdresse : la nouvelle adresse � mettre � jour
	 * @return 1 si mise � jour oubien 0 si rien n'a �t� mis � jour sinon
	 *         -code_erreur s'il y a eu une erreur � l'�chelle de la BD
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
	 * Mettre � jour le num�ro d�un �l�ve identifi� par son num�ro
	 * 
	 * @param num   : le num�ro de l'�l�ve
	 * @param newNo : la nouvelle chambre
	 * @return 1 si mise � jour oubien 0 oubien code d'�rreur s'il y a eu une
	 *         erreur � l'�chelle de la BD
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
	 * Ajouter un nouvel �l�ve
	 * 
	 * @param new_eleve : le nouvel el�ve � jouter
	 * @return 1 si ajout 0 sinon oubien le code d'�rreur s'il y a eu une erreur
	 *         � l'�chelle de la B
	 */
	public static int addEleve(Eleve new_eleve) {
		int result = -1;
		DBAction.DBConnexion();

		String req = "INSERT INTO eleve (num, no, nom, age, adresse)" + " VALUES ('" + new_eleve.getNum() + "',NULL,'"
				+ new_eleve.getNom() + "'," + new_eleve.getAge() + ",'" + new_eleve.getAdresse() + "') ";
		try {
			result = DBAction.getStm().executeUpdate(req);
		} catch (SQLException ex) {
			if (ex.getErrorCode() == 1062) {// la cl� existe d�j�
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
	 * R�cup�rer un ensemble d��l�ve qui ont la m�me date de naissance
	 * 
	 * @param d : date de naissance
	 * @return liste des �l�ve oubien null si aucun �l�ve ne correspond �
	 *         la date de naissance
	 */
	public static ArrayList<Eleve> getLstElevesByDateNaissance(int anneeNaissance) throws SQLException {
		ArrayList<Eleve> listEleveAnneeNaissance = new ArrayList<Eleve>();
		// on recupere l'ann�e en cours
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);

		// Variable � passer en param�tre dans la requ�te pour avoir les
		// �l�ves d'une
		// tranche d'age:
		// Je fais la diff�rence entre l'ann�e en cours et l'ann�e pass�e en
		// param�tre
		// de la fonction.
		int anneeNaissanceEleves = year - anneeNaissance;
		String req = "SELECT num, no, nom, age, adresse FROM eleve WHERE age =" + anneeNaissanceEleves + " ";
		// Connexion
		DBAction.DBConnexion();
		// ex�cution de la requ�te et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));

		while (DBAction.getRes().next()) {
			// int i = 0;
			// Instanciation de mon objet Eleve
			Eleve elevTemp = new Eleve();
			// Creation de l'objet eleveTemp � travers le ResultSet BD
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
	 * R�cup�rer la liste de tout les �l�ves
	 * 
	 * @return la liste de tout les �l�ves
	 */
	public static ArrayList<Eleve> getAllEleves() throws SQLException {
		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();

		String req = "SELECT num, no, nom, age, adresse FROM eleve ";
		// Connexion
		DBAction.DBConnexion();
		// ex�cution de la requ�te et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));

		while (DBAction.getRes().next()) {
			// int i = 0;
			// Instanciation de mon objet Eleve
			Eleve elevTemp = new Eleve();
			// Creation de l'objet eleveTemp � travers le ResultSet BD
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
