package com.crea.dev4.ecole.model.beans;

public class Inscrit {
	private String code;
	private String num;
	private float note;
	
	public Inscrit(String code, String num, float note) {
		super();
		this.code = code;
		this.num = num;
		this.note = note;
	}
	public Inscrit() {
		this("", "", 0.0f);
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	public void affiche() {
		System.out.print("code "+ code + " num "+ num + " note "+ note );
	}
	
	

}
