package com.crea.dev4.ecole.model.wrappers;

import java.util.ArrayList;

import com.crea.dev4.ecole.model.beans.Eleve;

public class EleveLstWrap {
	private ArrayList<Eleve> lstelv;
	private int codeaction;
		
	public EleveLstWrap(ArrayList<Eleve> lstelv, int codeaction) {
		super();
		this.lstelv = lstelv;
		this.codeaction = codeaction;
	}
	public EleveLstWrap() {
		super();
	}
	public ArrayList<Eleve> getLstelv() {
		return lstelv;
	}
	public void setLstelv(ArrayList<Eleve> lstelv) {
		this.lstelv = lstelv;
	}
	public int getCodeaction() {
		return codeaction;
	}
	public void setCodeaction(int codeaction) {
		this.codeaction = codeaction;
	}
	
	
	

}
