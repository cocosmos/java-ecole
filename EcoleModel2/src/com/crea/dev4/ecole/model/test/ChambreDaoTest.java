package com.crea.dev4.ecole.model.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crea.dev4.ecole.model.beans.Chambre;
import com.crea.dev4.ecole.model.beans.Eleve;
import com.crea.dev4.ecole.model.dao.ChambreDao;
import com.crea.dev4.ecole.model.dao.EleveDao;

/**
 * ChambreDao TEST
 * 
 * @author mipam
 *
 */

public class ChambreDaoTest {

	@Before
	public void testAddListeChambreToTest() {
		int insert = 1;
		assertEquals(insert, EleveDao.addEleve(new Eleve("TESTELEVE", 0, "ELEVE TEST", 40, "Adresse")));
		assertEquals(insert, ChambreDao.addChambre(new Chambre(10, 500.50f)));
		assertEquals(insert, ChambreDao.addChambre(new Chambre(11, 300.50f)));
		assertEquals(insert, ChambreDao.addChambre(new Chambre(12, 200.50f)));
		assertEquals(insert, ChambreDao.addChambre(new Chambre(13, 100.50f)));
		assertEquals(insert, ChambreDao.addChambre(new Chambre(14, 50.50f)));
		assertEquals(insert, EleveDao.updateEleveNumChambreBynum("TESTELEVE", 10));
	}

	@After
	public void testDeleteListeChambreToTest() {
		int delete = 1;
		assertEquals(delete, EleveDao.deleteEleveBynum("TESTELEVE"));
		assertEquals(delete, ChambreDao.deleteChambreByNo(10));
		assertEquals(delete, ChambreDao.deleteChambreByNo(11));
		assertEquals(delete, ChambreDao.deleteChambreByNo(12));
		assertEquals(delete, ChambreDao.deleteChambreByNo(13));
		assertEquals(delete, ChambreDao.deleteChambreByNo(14));

		// System.out.println("Chambre Supprimé ou pas : " + delete);
	}

	@Test
	public void testGetChambreByNo() {
		Chambre c_ref = new Chambre(12, 200.50f);
		System.out.println("Test get chambre by no :");
		Chambre c = new Chambre();
		c = ChambreDao.getChambreByNo(12);

		// c.affiche();
		assertEquals(c_ref.getNo(), c.getNo());
		assertEquals(c_ref.getPrix(), c.getPrix(), c.getPrix());
	}

	@Test
	public void testGetChambresByNum() {
		ArrayList<Chambre> liste = new ArrayList<Chambre>();
		System.out.println("Test get chambre by num :");
		liste = ChambreDao.getChambresByNum("TESTELEVE");
		for (Chambre c : liste) {
			c.affiche();
			assertEquals(10, c.getNo());
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
		assertEquals(insert_false, ChambreDao.addChambre(new Chambre(12, 500.50f)));
		assertEquals(insert_true, ChambreDao.addChambre(new Chambre(70, 500.50f)));
		assertEquals(insert_true, ChambreDao.deleteChambreByNo(70));

	}

	@Test
	public void testUpdateChambrePriceByNo() {
		int insert_false = 0;
		int insert_true = 1;
		System.out.println("Test update chambre");
		assertEquals(insert_false, ChambreDao.updateChambrePriceByNo(11111, 22.50f));
		assertEquals(insert_true, ChambreDao.updateChambrePriceByNo(12, 100.50f));

	}

	@Test
	public void testDeleteChambreByNo() {
		int nb = ChambreDao.deleteChambreByNo(0);
		int delete = 1;
		assertEquals(0, nb);
		assertEquals(delete, ChambreDao.addChambre(new Chambre(25, 500.50f)));
		nb = ChambreDao.deleteChambreByNo(25);
		assertEquals(1, nb);
	}

}
