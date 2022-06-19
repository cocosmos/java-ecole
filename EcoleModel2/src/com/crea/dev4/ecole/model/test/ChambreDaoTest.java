package com.crea.dev4.ecole.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crea.dev4.ecole.model.beans.Chambre;
import com.crea.dev4.ecole.model.dao.ChambreDao;

public class ChambreDaoTest {

	@Before
	public void testAddListeEleveToTest() {
		int insert = 1;
		assertEquals(insert, ChambreDao.addChambre(new Chambre(1, 500.50f)));
		assertEquals(insert, ChambreDao.addChambre(new Chambre(2, 300.50f)));
		assertEquals(insert, ChambreDao.addChambre(new Chambre(3, 200.50f)));
		assertEquals(insert, ChambreDao.addChambre(new Chambre(4, 100.50f)));
		assertEquals(insert, ChambreDao.addChambre(new Chambre(5, 50.50f)));
	}

	@After
	public void testDeleteListeEleveToTest() {
		int delete = 1;
		assertEquals(delete, ChambreDao.deleteChambreByNo(1));
		assertEquals(delete, ChambreDao.deleteChambreByNo(2));
		assertEquals(delete, ChambreDao.deleteChambreByNo(3));
		assertEquals(delete, ChambreDao.deleteChambreByNo(4));
		assertEquals(delete, ChambreDao.deleteChambreByNo(5));
		// System.out.println("Chambre Supprimé ou pas : " + delete);
	}

	@Test
	public void testGetChambreByNo() {
		Chambre c_ref = new Chambre(1, 500.50f);
		System.out.println("Test get chambre by no :");
		Chambre c = new Chambre();
		c = ChambreDao.getChambreByNo(1);

		// c.affiche();
		assertEquals(c_ref.getNo(), c.getNo());
		assertEquals(c_ref.getPrix(), c.getPrix(), c.getPrix());
	}

//	@Test
//	public void testGetChambresByNum() {
//		ArrayList<Chambre> liste = new ArrayList<Chambre>();
//		liste = ChambreDao.getChambresByNum(1);
//		for (Eleve e : liste) {
//			e.affiche();
//			assertEquals("AGUE MAX", e.getNom());
//		}
//	}

//	@Test
//	public void testGetChambresNoOccupied() {
//		ArrayList<Chambre> liste = new ArrayList<Eleve>();
//		liste = EleveDao.getElevesByNom("AGUE MAX");
//		for (Eleve e : liste) {
//			e.affiche();
//			assertEquals("AGUE MAX", e.getNom());
//		}
//	}

	@Test
	public void testGetChambresWithPrice() {
		ArrayList<Chambre> liste = new ArrayList<Chambre>();
		float price = 300f;
		System.out.println("Test get chambre with price > " + price + " :");
		liste = ChambreDao.getChambresByPrice(price);
		for (Chambre c : liste) {
			c.affiche();
			assertEquals(price, c.getPrix(), c.getPrix());
		}
	}

	@Test
	public void testGetAllChambres() {
		ArrayList<Chambre> liste = new ArrayList<Chambre>();
		System.out.println("Test get all chambres:");
		liste = ChambreDao.getAllChambres();
		for (Chambre c : liste) {
			c.affiche();
		}
	}

	@Test
	public void testAddChambre() {
		int insert_false = -2;
		int insert_true = 1;
		System.out.println("Test add chambre");
		assertEquals(insert_false, ChambreDao.addChambre(new Chambre(1, 500.50f)));
		assertEquals(insert_true, ChambreDao.addChambre(new Chambre(6, 500.50f)));
	}

	@Test
	public void testUpdateChambreNoEleveByNum() {
		System.out.println("Test update chambre");

	}

	@Test
	public void testUpdateChambrePriceByNo() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteChambreByNo() {
		fail("Not yet implemented");
	}

}
