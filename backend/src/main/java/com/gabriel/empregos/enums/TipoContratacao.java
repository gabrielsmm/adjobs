package com.gabriel.empregos.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoContratacao {
	
	TEMPORARIO(1),
	PARCIAL(2),
	ESTAGIO(3),
	JOVEM_APRENDIZ(4),
	TERCEIRIZADO(5),
	HOME_OFFICE(6),
	INTERMITENTE(7);
	
	private int id;

	TipoContratacao(int id) {
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
