package com.crea.dev4.ecole.model.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crea.dev4.ecole.model.beans.Eleve;
import com.crea.dev4.ecole.model.dao.EleveDao;

public class EleveDaoTest {

	@Before
	public void testAddListeEleveToTest() {
		int insert = 1;
		assertEquals(insert, EleveDao.addEleve(new Eleve("AGUE0010", 0, "AGUE MAX", 40, "18 Rue Labat 75018 Paris")));
		assertEquals(insert, EleveDao.addEleve(new Eleve("AGUE0020", 0, "AGUE MAX", 42, "19 Rue Le Monde Paris")));
		assertEquals(insert, EleveDao
				.addEleve(new Eleve("KAMTO0050", 0, "KAMTO Diog�ne", 50, "54 Rue des Ebisoires 78300 Poissy")));
		assertEquals(insert, EleveDao
				.addEleve(new Eleve("LAURENCY0040", 0, "LAURENCY Patrick", 52, "79 Rue des Poules 75015 Paris")));
		assertEquals(insert,
				EleveDao.addEleve(new Eleve("TABIS0030", 0, "Ghislaine TABIS", 30, "12 Rue du louvre 75013 Paris")));
		assertEquals(insert, EleveDao
				.addEleve(new Eleve("TAHAE0020", 0, "TAHA RIDENE", 30, "12 Rue des Chantiers 78000 Versailles")));
	}

	@After
	public void testDeleteListeEleveToTest() {
		int delete = 1;
		assertEquals(delete, EleveDao.deleteEleveBynum("AGUE0010"));
		assertEquals(delete, EleveDao.deleteEleveBynum("AGUE0020"));
		assertEquals(delete, EleveDao.deleteEleveBynum("KAMTO0050"));
		assertEquals(delete, EleveDao.deleteEleveBynum("LAURENCY0040"));
		assertEquals(delete, EleveDao.deleteEleveBynum("TABIS0030"));
		assertEquals(delete, EleveDao.deleteEleveBynum("TAHAE0020"));
		System.out.println("Eleve Supprim� ou pas : " + delete);
	}

	@Test
	public void testGetEleveByNum() {
		Eleve e_ref = new Eleve("AGUE001", 0, "AGUE MAX", 40, "18 Rue Labat 75018 Paris");// "AGUE001", 1, "AGUE MAX",
		Eleve e = new Eleve();
		e = EleveDao.getEleveByNum("AGUE001");
		e.affiche();
		assertEquals(e_ref.getAge(), e.getAge());
		assertEquals(e_ref.getAdresse(), e.getAdresse());
		assertEquals(e_ref.getNom(), e.getNom());
	}

	@Test
	public void testGetElevesByNom() {
		ArrayList<Eleve> liste = new ArrayList<Eleve>();
		liste = EleveDao.getElevesByNom("AGUE MAX");
		for (Eleve e : liste) {
			e.affiche();
			assertEquals("AGUE MAX", e.getNom());
		}
	}

	@Test
	public void testGetElevesByNumChambre() throws SQLException {
		ArrayList<Eleve> liste = new ArrayList<Eleve>();
		liste = EleveDao.getEleveByNo(0);
		for (Eleve e : liste) {
			e.affiche();
			assertEquals(0, e.getNo());
		}
	}

	@Test
	public void testDeleteEleveBynum() {
		int nb = EleveDao.deleteEleveBynum("NOEXISTING");
		assertEquals(0, nb);
		int insert = 1;
		assertEquals(insert,
				EleveDao.addEleve(new Eleve("VIRGINIE008", 0, "VIRGINIE LANZ", 22, "18 Rue des acacias Geneve")));
		nb = EleveDao.deleteEleveBynum("VIRGINIE008");
		assertEquals(1, nb);
	}

	@Test
	public void testUpdateEleveAdresseBynum() throws SQLException {
		int update_false = -2;
		int update_true = 1;

		assertEquals(update_false, EleveDao.updateEleveAdresseBynum("AGUE009", "18 Rue des acacias Geneve"));
		assertEquals(update_true, EleveDao.updateEleveAdresseBynum("AGUE001", "18 Rue des acacias Geneve"));
	}

	@Test
	public void testAddEleve() {
		int insert_false = -2;
		int insert_true = 1;
		int delete_true = 1;

		assertEquals(insert_false,
				EleveDao.addEleve(new Eleve("AGUE001", 0, "AGUE MAX", 40, "18 Rue Labat 75018 Paris")));
		assertEquals(insert_true,
				EleveDao.addEleve(new Eleve("MARINA003", 0, "MARINA EL JOUHARI", 23, "18 Rue des acacias Geneve")));
		assertEquals(delete_true, EleveDao.deleteEleveBynum("MARINA003"));
	}

	@Test
	public void testGetLstElevesByDateNaissance() throws SQLException {
		ArrayList<Eleve> liste = new ArrayList<Eleve>();

		liste = EleveDao.getLstElevesByDateNaissance(1992);
		for (Eleve e : liste) {
			e.affiche();
			assertEquals(30, e.getAge());
		}
	}

	@Test
	public void testGetAllEleves() throws SQLException {
		ArrayList<Eleve> liste = new ArrayList<Eleve>();
		System.out.println("Test get all eleves:");
		liste = EleveDao.getAllEleves();
		for (Eleve e : liste) {
			e.affiche();
		}
	}

	@Test
	public void testUpdateEleveNumChambreBynum() {
		int update_false = 0;
		int update_true = 1;
		System.out.println("Test update chambre eleve:");
		assertEquals(update_false, EleveDao.updateEleveNumChambreBynum("AGUE009", 8));
		assertEquals(update_true, EleveDao.updateEleveNumChambreBynum("AGUE001", 9));
	}
//	@Test
//	public void testUpdateEleveNumChambreBynum() {
//		int update_false = 0;
//		int update_true = -1452; // TODO Check on chambre database
//
//		assertEquals(update_false, EleveDao.updateEleveNumChambreBynum("AGUE009", 0));
//		assertEquals(update_true, EleveDao.updateEleveNumChambreBynum("AGUE001", 22));
//	}

}
