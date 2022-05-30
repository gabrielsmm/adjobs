package com.gabriel.empregos.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FormacaoNivel {
	
	FUNDAMENTAL(1),
	MEDIO(2),
	EXTRACURRICULAR(3),
	TECNICO(4),
	SUPERIOR(5),
	ESPECIALIZACAO(6),
	MESTRADO(7),
	DOUTORADO(8);
	
	private int id;

	FormacaoNivel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    @JsonValue
    public int toValue() {
        return ordinal();
    }
	
}
