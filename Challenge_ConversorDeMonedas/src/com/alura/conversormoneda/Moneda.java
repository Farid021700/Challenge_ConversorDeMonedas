package com.alura.conversormoneda;

public enum Moneda {

    USD("USD", "Dólar estadounidense"),
    ARS("ARS", "Peso argentino"),
    BOB("BOB", "Boliviano boliviano"),
    BRL("BRL", "Real brasileño"),
    CLP("CLP", "Peso chileno"),
    COP("COP", "Peso colombiano");

    private final String codigo;
    private final String nombre;

    Moneda(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
}
