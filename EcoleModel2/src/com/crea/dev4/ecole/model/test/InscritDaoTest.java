package com.crea.dev4.ecole.model.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crea.dev4.ecole.model.beans.Eleve;
import com.crea.dev4.ecole.model.beans.Inscrit;
import com.crea.dev4.ecole.model.beans.Uv;
import com.crea.dev4.ecole.model.dao.EleveDao;
import com.crea.dev4.ecole.model.dao.InscritDao;
import com.crea.dev4.ecole.model.dao.UvDao;

/**
 * Inscrit Dao Test
 * 
 * @author mipam
 *
 */

public class InscritDaoTest {
	@Before
	public void testAddListeInscritToTest() {
		int insert = 1;
		assertEquals(insert,
				EleveDao.addEleve(new Eleve("TABIS0030", 0, "Ghislaine TABIS", 30, "12 Rue du louvre 75013 Paris")));
		assertEquals(insert, EleveDao
				.addEleve(new Eleve("TAHAE0020", 0, "TAHA RIDENE", 30, "12 Rue des Chantiers 78000 Versailles")));
		assertEquals(insert, UvDao.addUv(new Uv("JAVA_Grp4", 30, "TAHA")));
		assertEquals(insert, UvDao.addUv(new Uv("JAVA_Grp5", 60, "TAHA")));

		assertEquals(insert, InscritDao.addInscrit(new Inscrit("JAVA_Grp5", "TABIS0030", 15)));
		assertEquals(insert, InscritDao.addInscrit(new Inscrit("JAVA_Grp4", "TAHAE0020", 15)));

	}

	@After
	public void testDeleteListeInscritToTest() {
		int delete = 1;
		assertEquals(delete, InscritDao.deleteInscritByCodeAndNum("JAVA_Grp5", "TABIS0030"));
		assertEquals(delete, InscritDao.deleteInscritByCodeAndNum("JAVA_Grp4", "TAHAE0020"));
		assertEquals(delete, EleveDao.deleteEleveBynum("TABIS0030"));
		assertEquals(delete, EleveDao.deleteEleveBynum("TAHAE0020"));
		assertEquals(delete, UvDao.deleteUvByCode("JAVA_Grp4"));
		assertEquals(delete, UvDao.deleteUvByCode("JAVA_Grp5"));

	}

	@Test
	public void testGetInscritsByEleveNum() {
		System.out.println("Test get inscrit by eleve num");
		Inscrit i_ref = new Inscrit("JAVA_Grp5", "TABIS0030", 20);

		ArrayList<Inscrit> liste = new ArrayList<Inscrit>();
		liste = InscritDao.getInscritsByEleveNum("TABIS0030");
		for (Inscrit i : liste) {
			assertEquals(i_ref.getCode(), i.getCode());
			assertEquals(i_ref.getNum(), i.getNum());
			assertEquals(i_ref.getNote(), i.getNote(), i.getNote());
		}
	}

	@Test
	public void testGetAllInscrit() {
		System.out.println("Test get all inscrit");
		ArrayList<Inscrit> liste = new ArrayList<Inscrit>();
		for (Inscrit i : liste) {
			i.affiche();
		}
	}

	@Test
	public void testDeleteInscritByCodeAndNum() {
		int istrue = 1;
		int isfalse = 0;
		assertEquals(istrue, InscritDao.addInscrit(new Inscrit("JAVA_Grp5", "TAHAE0020", 15)));
		assertEquals(istrue, InscritDao.deleteInscritByCodeAndNum("JAVA_Grp5", "TAHAE0020"));
		assertEquals(isfalse, InscritDao.deleteInscritByCodeAndNum("JAVA_Grp5", null));
	}

}
