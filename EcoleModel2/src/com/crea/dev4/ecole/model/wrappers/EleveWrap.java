package com.crea.dev4.ecole.model.wrappers;

import com.crea.dev4.ecole.model.beans.Eleve;

public class EleveWrap {
	private Eleve elv;
	private int codeaction;
	
	//constructeurs
	public EleveWrap(Eleve elv, int codeaction) {
		super();
		this.elv = elv;
		this.codeaction = codeaction;
	}
	public EleveWrap() {
		this(null, 0);
	}
	public Eleve getElv() {
		return elv;
	}
	public void setElv(Eleve elv) {
		this.elv = elv;
	}
	public int getCodeaction() {
		return codeaction;
	}
	public void setCodeaction(int codeaction) {
		this.codeaction = codeaction;
	}

}
