package com.gabriel.empregos.enums;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoContratacao {
	
	TEMPO_INDETERMINADO(0),
	TEMPORARIO(1),
	PARCIAL(2),
	ESTAGIO(3),
	JOVEM_APRENDIZ(4),
	TRAINEE(5),
	TERCEIRIZADO(6),
	HOME_OFFICE(7),
	INTERMITENTE(8);
	
	private int id;
	private static final Map<Integer,TipoContratacao> ENUM_MAP;

	TipoContratacao(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    static {
        Map<Integer,TipoContratacao> map = new ConcurrentHashMap<Integer, TipoContratacao>();
        for (TipoContratacao instance : TipoContratacao.values()) {
            map.put(instance.getId(),instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }
    
    public static TipoContratacao get(int tipo) {
        return ENUM_MAP.get(tipo);
    }
    
    @JsonValue
    public int toValue() {
        return ordinal();
    }
	
}
