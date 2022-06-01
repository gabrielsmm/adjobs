package com.gabriel.empregos.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EstadoCivil {
	
	CASADO(1),
	DIVORCIADO(2),
	SEPARADO(3),
	SOLTEIRO(4),
	VIUVO(5);
	
	private int id;

	EstadoCivil(int id) {
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
