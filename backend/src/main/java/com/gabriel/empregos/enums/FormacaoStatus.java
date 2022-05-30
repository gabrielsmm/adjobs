package com.gabriel.empregos.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FormacaoStatus {
	
	CONCLUIDO(1),
	CURSANDO(2),
	TRANCADO(3);
	
	private int id;

	FormacaoStatus(int id) {
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
