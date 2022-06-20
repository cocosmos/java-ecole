package com.crea.dev4.ecole.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
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
		assertEquals(insert, ChambreDao.addChambre(new Chambre(10, 500.50f)));
		assertEquals(insert, ChambreDao.addChambre(new Chambre(11, 300.50f)));
		assertEquals(insert, ChambreDao.addChambre(new Chambre(12, 200.50f)));
		assertEquals(insert, ChambreDao.addChambre(new Chambre(13, 100.50f)));
		assertEquals(insert, ChambreDao.addChambre(new Chambre(14, 50.50f)));
	}

	@After
	public void testDeleteListeEleveToTest() {
		int delete = 1;
		assertEquals(delete, ChambreDao.deleteChambreByNo(10));
		assertEquals(delete, ChambreDao.deleteChambreByNo(11));
		assertEquals(delete, ChambreDao.deleteChambreByNo(12));
		assertEquals(delete, ChambreDao.deleteChambreByNo(13));
		assertEquals(delete, ChambreDao.deleteChambreByNo(14));
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

	@Test
	public void testGetChambresByNum() {
		ArrayList<Chambre> liste = new ArrayList<Chambre>();
		System.out.println("Test get chambre by num :");
		liste = ChambreDao.getChambresByNum("AGUE001");
		for (Chambre c : liste) {
			c.affiche();
			assertEquals("AGUE MAX", c.getPrix());
		}
	}


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
	public void testGetAllChambres() throws SQLException {
		ArrayList<Chambre> liste = new ArrayList<Chambre>();
		System.out.println("Test get all chambres:");
		liste = ChambreDao.getAllChambres();
		for (Chambre c : liste) {
			c.affiche();
		}
	}

	@Test
	public void testGetAllChambresNoOccupied() {
		ArrayList<Chambre> liste = new ArrayList<Chambre>();
		System.out.println("Test get all chambres no occupied:");
		liste = ChambreDao.getChambresNoOccupied();
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
