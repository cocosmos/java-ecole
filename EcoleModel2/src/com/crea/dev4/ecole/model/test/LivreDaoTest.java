package com.crea.dev4.ecole.model.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
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
		assertEquals(insert, LivreDao.addLivre(new Livre("ISBN10008", null, "Un vase dhonneur", null)));
		assertEquals(insert, LivreDao.addLivre(new Livre("ISBN10009", null, "Seul au monde", null)));
		assertEquals(insert, LivreDao.addLivre(new Livre("ISBN100010", null, "Meurtre à la maison blanche", null)));
		assertEquals(insert, LivreDao.addLivre(new Livre("ISBN100011", null, "Double Impact", null)));
		assertEquals(insert, LivreDao.addLivre(new Livre("ISBN100012", null, "Un vase dhonneur", null)));
		assertEquals(insert, LivreDao.updateLivreNumByCote("ISBN10009", "TESTELEVE"));

	}

	@After
	public void testDeleteListeLivreToTest() {
		int delete = 1;
		assertEquals(delete, LivreDao.updateLivreNumByCote("ISBN10009", null));
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
		Livre l_ref =new Livre("ISBN10008",null, "Un vase dhonneur", null);
		Livre l = new Livre();
		l = LivreDao.getLivreByCote("ISBN10008");
	
		assertEquals(l_ref.getCote(), l.getCote());
		assertEquals(l_ref.getTitre(), l.getTitre());
	}

	@Test
	public void testGetLivresByEleveNum() {
		System.out.println("Test get livre by Eleve num");
		ArrayList<Livre> liste =new ArrayList<Livre>();
		liste = LivreDao.getLivresByEleveNum("TESTELEVE");
		for (Livre l :liste) {
			assertEquals("TESTELEVE", l.getNum());
		}
    }

	@Test
	public void testGetLivresAvailable() {
		System.out.println("Test get livres available");
		
		boolean get_false =false;
		ArrayList<Livre> liste =new ArrayList<Livre>();
		Livre l_ref =LivreDao.getLivreByCote("ISBN100010");
		liste = LivreDao.getLivresAvailable();
		
		
		assertEquals(get_false, liste.contains(l_ref));
	}

	@Test
	public void testGetAllLivres() {
		System.out.println("Test get all livres ");
		ArrayList<Livre> liste =new ArrayList<Livre>();
		liste = LivreDao.getAllLivres();
		
		System.out.println(liste);
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
		int insert_false = 0;
		int insert_true = 1;
		System.out.println("Test update title by cote");
		
		assertEquals(insert_false, LivreDao.updateLivreTitreByCote("ISBN10060", null));
		assertEquals(insert_true, LivreDao.updateLivreTitreByCote("ISBN100011", "NEW TITRE"));
		 LivreDao.getLivreByCote("ISBN100011");
		
	}

	@Test
	public void testUpdateLivreNumByCote() {
		int insert_false = 0;
		int insert_true = 1;
		System.out.println("Test update livre num by cote");
		
		assertEquals(insert_false, LivreDao.updateLivreNumByCote("ISBN10060", null));
		assertEquals(insert_true, LivreDao.updateLivreNumByCote("ISBN10008", "TESTELEVE"));
		 LivreDao.getLivreByCote("ISBN10008");
		//Reput to null
		assertEquals(insert_true, LivreDao.updateLivreNumByCote("ISBN10008", null));
	}

	@Test
	public void testDeleteLivreByNo() {
		int delete_true = 1;
		int delete_false = 0;
		assertEquals(delete_true, LivreDao.addLivre(new Livre("ISBN100015", null, "toto", null)));//insert
		assertEquals(delete_false, LivreDao.deleteLivreByNo("ISBN1000111")); //False
		assertEquals(delete_true, LivreDao.deleteLivreByNo("ISBN100015"));//true
	}

}
