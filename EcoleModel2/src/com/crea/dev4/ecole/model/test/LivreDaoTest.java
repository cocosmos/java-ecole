package com.crea.dev4.ecole.model.test;

import org.junit.Test;

import com.crea.dev4.ecole.model.beans.Livre;
import com.crea.dev4.ecole.model.dao.LivreDao;

public class LivreDaoTest {

//	@Test
//	public void testAddLivre() {
//		int insert_false = -2;
//		int insert_true = 1;
//		System.out.println("Test add chambre");
//		assertEquals(insert_false, LivreDao.addLivre(new Livre("ISBN10000", null, "toto", null)));
//		assertEquals(insert_true, LivreDao.addLivre(new Livre("ISBN10004", null, "toto", null)));
//	}

	@Test
	public void testGetLivreByCote() {
		System.out.println("Test get livre by cote");
		Livre l = new Livre();
		l = LivreDao.getLivreByCote("fff");
		l.affiche();
	}

//	@Test
//	public void testUpdateLivreNumByCote() {
//		System.out.println("Test update");
//		LocalDateTime dateTime = LocalDateTime.now();
//		java.sql.Timestamp sqlDate = java.sql.Timestamp.valueOf(dateTime);
//		System.out.println(sqlDate);
//	}

}
