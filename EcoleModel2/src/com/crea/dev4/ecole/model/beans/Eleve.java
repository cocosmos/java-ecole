package com.crea.dev4.ecole.model.beans;

/**
 * 
 * @author mipam
 * 
 *         Bean Eleve
 *
 */

public class Eleve {
	/**
	 * Attributs
	 */

	private String num;
	private Integer no;
	private String nom;
	private int age;
	private String adresse;

	/**
	 * Constructeurs
	 * 
	 * @param num
	 * @param no
	 * @param nom
	 * @param age
	 * @param adresse
	 */
	public Eleve(String num, Integer no, String nom, int age, String adresse) {
		super();
		this.num = num;
		this.no = no;
		this.nom = nom;
		this.age = age;
		this.adresse = adresse;
	}

	public Eleve() {
		this("", null, "", 0, "");
	}

	/**
	 * Accesseurs
	 * 
	 * @return num
	 */
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void affiche() {
		System.out.print("num " + num + " no " + no + " nom " + nom + " age " + age + " adresse " + adresse + "\n");
	}
}
