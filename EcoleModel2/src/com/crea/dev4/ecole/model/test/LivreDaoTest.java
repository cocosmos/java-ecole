package com.crea.dev4.ecole.model.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.crea.dev4.ecole.model.beans.Livre;
import com.crea.dev4.ecole.model.dao.LivreDao;

public class LivreDaoTest {

	@Test
	public void testGetLivreByCote() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateLivreTitreByCote() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateLivreNumByCote() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteLivreByNo() {
		fail("Not yet implemented");
	}
	
////	@Test
////	public void testAddLivre() {
////		int insert_false = -2;
////		int insert_true = 1;
////		System.out.println("Test add chambre");
////		assertEquals(insert_false, LivreDao.addLivre(new Livre("ISBN10000", null, "toto", null)));
////		assertEquals(insert_true, LivreDao.addLivre(new Livre("ISBN10004", null, "toto", null)));
////	}
//
//	@Test
//	public void testGetLivreByCote() {
//		System.out.println("Test get livre by cote");
//		Livre l = new Livre();
//		l = LivreDao.getLivreByCote("fff");
//		l.affiche();
//	}
//
//	@Test
//	public void testUpdateLivreNumByCote() {
//		System.out.println("Test update");
//		int l = LivreDao.updateLivreNumByCote("ISBN10003", null);
//		int test = LivreDao.updateLivreNumByCote("ISBN10004", "AGUE001");
//		System.out.println(l + " " + test);
//	}


}
