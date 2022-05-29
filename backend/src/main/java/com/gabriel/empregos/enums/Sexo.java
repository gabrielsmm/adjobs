package com.gabriel.empregos.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Sexo {
	
	MASCULINO(1),
	FEMININO(2);
	
	private int id;

	Sexo(int id) {
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
