package com.gabriel.empregos.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EstadoCivil {
	
	SOLTEIRO(1),
	CASADO(2),
	VIUVO(3);
	
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
