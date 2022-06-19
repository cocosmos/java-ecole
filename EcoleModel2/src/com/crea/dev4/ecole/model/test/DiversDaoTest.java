package com.crea.dev4.ecole.model.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.crea.dev4.ecole.model.dao.EleveDao;

public class DiversDaoTest {

	@Test
	public void testUpdateEleveNumChambreBynum() {
		int update_false = 0;
		int update_true = -1452; // TODO Check on chambre database

		assertEquals(update_false, EleveDao.updateEleveNumChambreBynum("AGUE009", 0));
		assertEquals(update_true, EleveDao.updateEleveNumChambreBynum("AGUE001", 22));
	}

}
