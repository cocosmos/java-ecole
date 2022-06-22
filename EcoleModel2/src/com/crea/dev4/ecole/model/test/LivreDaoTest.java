package com.crea.dev4.ecole.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crea.dev4.ecole.model.beans.Eleve;
import com.crea.dev4.ecole.model.beans.Livre;
import com.crea.dev4.ecole.model.dao.EleveDao;
import com.crea.dev4.ecole.model.dao.LivreDao;

public class LivreDaoTest {
	@Before
	public void testAddListeLivreToTest() {
		int insert = 1;
		assertEquals(insert, EleveDao.addEleve(new Eleve("TESTELEVE", 0, "ELEVE TEST", 40, "Adresse")));
		assertEquals(insert, LivreDao.addLivre(new Livre("ISBN10008", "", "Un vase d'honneur", null)));
		assertEquals(insert, LivreDao.addLivre(new Livre("ISBN10009", "", "Seul au monde", null)));
		assertEquals(insert, LivreDao.addLivre(new Livre("ISBN100010", "", "Meurtre à la maison blanche", null)));
		assertEquals(insert, LivreDao.addLivre(new Livre("ISBN100011", "", "Double Impact", null)));
		assertEquals(insert, LivreDao.addLivre(new Livre("ISBN100012", "", "Un vase d'honneur", null)));

	}

	@After
	public void testDeleteListeLivreToTest() {
		int delete = 1;
		assertEquals(delete, EleveDao.deleteEleveBynum("TESTELEVE"));
		assertEquals(delete, LivreDao.deleteLivreByNo("ISBN10008"));
		assertEquals(delete, LivreDao.deleteLivreByNo("ISBN10009"));
		assertEquals(delete, LivreDao.deleteLivreByNo("ISBN100010"));
		assertEquals(delete, LivreDao.deleteLivreByNo("ISBN100011"));
		assertEquals(delete, LivreDao.deleteLivreByNo("ISBN100012"));
	}

	@Test
	public void testGetLivreByCote() {
		System.out.println("Test get livre by cote");
		Livre l = new Livre();
		l = LivreDao.getLivreByCote("fff");
		l.affiche();
	}

	@Test
	public void testGetLivresByEleveNum() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLivresAvailable() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllLivres() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddLivre() {
		int insert_false = -2;
		int insert_true = 1;
		System.out.println("Test add Livre");
		assertEquals(insert_false, LivreDao.addLivre(new Livre("ISBN10000", null, "toto", null)));
		assertEquals(insert_true, LivreDao.addLivre(new Livre("ISBN10005", null, "toto", null)));
		assertEquals(insert_true, LivreDao.deleteLivreByNo("ISBN10005"));
	}

	@Test
	public void testUpdateLivreTitreByCote() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateLivreNumByCote() {
		System.out.println("Test update");
		int l = LivreDao.updateLivreNumByCote("ISBN10003", null);
		int test = LivreDao.updateLivreNumByCote("ISBN10004", "AGUE001");
		System.out.println(l + " " + test);
	}

	@Test
	public void testDeleteLivreByNo() {
		fail("Not yet implemented");
	}

}
