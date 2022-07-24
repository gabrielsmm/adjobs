package com.gabriel.empregos.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CandidaturaStatus {
	
	RECEBIDO(0),
	REVISADO(1),
	PRESELECIONADO(2),
	FINALISTA(3),
	CANCELADO(4),
	DESCONHECIDO(5);
	
	private Integer id;

	CandidaturaStatus(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public static CandidaturaStatus getById(Integer id) {
        for(CandidaturaStatus e : values()) {
            if(e.id.equals(id)) return e;
        }
        return DESCONHECIDO;
    }
    
    @JsonValue
    public int toValue() {
        return ordinal();
    }
	
}
