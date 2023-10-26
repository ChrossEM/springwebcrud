package com.excer.webcrud.util;

public class PageItem {
    private int numero;
    private  boolean actual;

    public PageItem(int numero, boolean actual) {
        this.numero = numero;
        this.actual = actual;
    }

    public int getNuemro() {
        return numero;
    }

    public void setNuemro(int numero) {
        this.numero = numero;
    }

    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }
}
