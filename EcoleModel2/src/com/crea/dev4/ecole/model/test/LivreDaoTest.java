package com.crea.dev4.ecole.model.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.crea.dev4.ecole.model.beans.Livre;
import com.crea.dev4.ecole.model.dao.LivreDao;


public class LivreDaoTest {

	@Test
	public void testAddLivre()  {
		int insert_false = -2;
		int insert_true = 1;
		System.out.println("Test add chambre");
		assertEquals(insert_false, LivreDao.addLivre(new Livre("ISBN10000", null, "toto", null)));
		assertEquals(insert_true, LivreDao.addLivre(new Livre("ISBN10004", null, "toto", null)));
	}


}
