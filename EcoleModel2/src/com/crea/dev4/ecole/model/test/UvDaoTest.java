package com.crea.dev4.ecole.model.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crea.dev4.ecole.model.beans.Uv;
import com.crea.dev4.ecole.model.dao.UvDao;

/**
 * Uv DAO test
 * 
 * @author mipam
 *
 */

public class UvDaoTest {
	@Before
	public void testAddListeUvToTest() {
		int insert = 1;

		assertEquals(insert, UvDao.addUv(new Uv("JAVA_Grp2", 25, "TAHA")));
		assertEquals(insert, UvDao.addUv(new Uv("JAVA_Grp3", 20, "RIDENE")));
		assertEquals(insert, UvDao.addUv(new Uv("JAVA_Grp4", 30, "TAHA")));
		assertEquals(insert, UvDao.addUv(new Uv("JAVA_Grp5", 60, "TAHA")));

	}

	@After
	public void testDeleteListeUvToTest() {
		int delete = 1;
		assertEquals(delete, UvDao.deleteUvByCode("JAVA_Grp2"));
		assertEquals(delete, UvDao.deleteUvByCode("JAVA_Grp3"));
		assertEquals(delete, UvDao.deleteUvByCode("JAVA_Grp4"));
		assertEquals(delete, UvDao.deleteUvByCode("JAVA_Grp5"));

	}

	@Test
	public void testGetUvByCode() {
		System.out.println("Test get UV by code");
		Uv u_ref = new Uv("JAVA_Grp2", 25, "TAHA");
		Uv u = new Uv();
		u = UvDao.getUvByCode("JAVA_Grp2");

		assertEquals(u_ref.getCode(), u.getCode());
		assertEquals(u_ref.getNbh(), u.getNbh());
		assertEquals(u_ref.getCoord(), u.getCoord());
	}

	@Test
	public void testGetAllUvs() {
		System.out.println("Test get all UV");
		ArrayList<Uv> liste = new ArrayList<Uv>();
		liste = UvDao.getAllUvs();
		System.out.println(liste);
	}

	@Test
	public void testGetUvsWithHours() {
		System.out.println("Test get all UV > number of hours");
		ArrayList<Uv> liste = new ArrayList<Uv>();
		liste = UvDao.getUvsWithHours(50);
		System.out.println(liste);
		for (Uv u : liste) {

			assertEquals(60, u.getNbh());
		}
	}

	@Test
	public void testUpdateNbhByCode() {
		int update_false = -1;
		int update_true = 1;
		assertEquals(update_false, UvDao.updateNbhByCode("JAVA_Grp2", -20));
		assertEquals(update_true, UvDao.updateNbhByCode("JAVA_Grp2", 40));
	}

	@Test
	public void testUpdateCoordByCode() {
		int update_false = -1;
		int update_true = 1;
		assertEquals(update_false, UvDao.updateCoordByCode("JAVA_Grp2", null));
		assertEquals(update_true, UvDao.updateCoordByCode("JAVA_Grp2", "M. Ridene"));
	}

	@Test
	public void testDeleteUvByCode() {
		int delete_true = 1;
		int delete_false = 0;

		assertEquals(delete_true, UvDao.addUv(new Uv("JAVA_Grp55", 46, "Toto")));// insert

		assertEquals(delete_false, UvDao.deleteUvByCode("JAVA_Grp5555")); // False
		assertEquals(delete_true, UvDao.deleteUvByCode("JAVA_Grp55"));// true
	}

}
