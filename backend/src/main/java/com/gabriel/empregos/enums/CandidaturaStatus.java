package com.gabriel.empregos.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CandidaturaStatus {
	
	RECEBIDO(1),
	REVISADO(2),
	PRESELECIONADO(3),
	FINALISTA(4),
	CANCELADO(5);
	
	private int id;

	CandidaturaStatus(int id) {
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
