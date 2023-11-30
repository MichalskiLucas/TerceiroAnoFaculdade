package com.example.financial.enums;

import lombok.Data;

public enum TipoRegistroENUM {
    DESPESA("Despesa"),
    RECEITA("Receita");

    public final String value;

    private TipoRegistroENUM(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

