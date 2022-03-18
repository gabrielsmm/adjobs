package com.gabriel.empregos.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoUsuario {
	
	ADMINISTRADOR(1), //0
	EMPRESA(2), //1
	CANDIDATO(3); //2
	
	private int id;

	TipoUsuario(int id) {
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
