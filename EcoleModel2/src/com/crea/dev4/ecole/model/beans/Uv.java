package com.crea.dev4.ecole.model.beans;

public class Uv {
 private String code;
 private int nbh;
 private String coord;
 
 
public Uv(String code, int nbh, String coord) {
	super();
	this.code = code;
	this.nbh = nbh;
	this.coord = coord;
}
public Uv () {
	this("",0,"");
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public int getNbh() {
	return nbh;
}
public void setNbh(int nbh) {
	this.nbh = nbh;
}
public String getCoord() {
	return coord;
}
public void setCoord(String coord) {
	this.coord = coord;
}

public void affiche() {
	System.out.print("code "+ code + " nbh "+ nbh+ " coord "+coord+ "\n");
}
public String toString() {
	return "code "+ code + " nbh "+ nbh+ " coord "+coord;
}
 
}
