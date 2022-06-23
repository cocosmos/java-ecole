package com.crea.dev4.ecole.model.beans;

/**
 * Chambre Beans
 * 
 * @author mipam
 *
 */

public class Chambre {
	/**
	 * Attributs
	 */
	private Integer no;
	private float prix;

	/**
	 * Constructors
	 * 
	 * @param no   of chambre
	 * @param prix of chambre
	 */
	public Chambre(int no, float prix) {
		super();
		this.no = no;
		this.prix = prix;
	}

	/**
	 * Chambre Base
	 */
	public Chambre() {
		this(0, 0.0f);
	}

	/**
	 * get No
	 * 
	 * @return no
	 */
	public int getNo() {
		return no;
	}

	/**
	 * Set No
	 * 
	 * @param no of chambre
	 */
	public void setNo(int no) {
		this.no = no;
	}

	/**
	 * Get prix
	 * 
	 * @return prix
	 */

	public float getPrix() {
		return prix;
	}

	/**
	 * Chambre Set Prix
	 * 
	 * @param prix of cahmbre
	 */
	public void setPrix(float prix) {
		this.prix = prix;
	}

	/**
	 * Affiche Chambre
	 */
	public void affiche() {
		System.out.print("no " + no + " prix " + prix + "\n");
	}

	public String toString() {
		return "no " + no + " prix " + prix;
	}

}
