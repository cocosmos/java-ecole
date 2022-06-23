package com.crea.dev4.ecole.model.beans;

public class Chambre {
	// Attributs
	private Integer no;
	private float prix;
	// private String num;

	// Constructeurs
	public Chambre(int no, float prix) {
		super();
		this.no = no;
		this.prix = prix;
		// this.num = num;

	}

	public Chambre() {
		this(0, 0.0f);
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	/*
	 * public String getNum() { return num; }
	 * 
	 * public void setNum(String num) { this.num = num; }
	 */

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public void affiche() {
		System.out.print("no " + no + " prix " + prix + "\n");
	}

	public String toString() {
		return "no " + no + " prix " + prix;
	}

}
