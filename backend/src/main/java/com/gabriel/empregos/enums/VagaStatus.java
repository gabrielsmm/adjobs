package com.gabriel.empregos.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VagaStatus {
	
	ATIVA(1),
	CANCELADA(2);
	
	private int id;

	VagaStatus(int id) {
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
