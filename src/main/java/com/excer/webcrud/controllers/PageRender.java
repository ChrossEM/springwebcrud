package com.excer.webcrud.controllers;

import com.excer.webcrud.util.PageItem;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageRender<T> {
    private String url;
    private Page<T> page;
    private int TotalPaginas;
    private int numElementosPorPagina;
    private int paginaActual;
    private List<PageItem> paginas;

    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        this.paginas = new ArrayList<PageItem>();

        numElementosPorPagina = page.getSize();
        TotalPaginas = page.getTotalPages();
        paginaActual = page.getNumber() + 1;
        int desde, hasta;

        if (TotalPaginas <= numElementosPorPagina) {
            desde = 1;
            hasta = TotalPaginas;
        } else {
            if (paginaActual <= numElementosPorPagina/2) {
                desde = 1;
                hasta = TotalPaginas;
            } else if (paginaActual >= TotalPaginas - numElementosPorPagina) {
                desde = TotalPaginas - numElementosPorPagina + 1;
                hasta = numElementosPorPagina;
            } else {
                desde = paginaActual - numElementosPorPagina/2;
                hasta = numElementosPorPagina;
            }
        }

        for (int i = 0; i < hasta; i++) {
            paginas.add(new PageItem(desde + i, paginaActual == desde + i));
        }
    }

    public String getUrl() {
        return url;
    }

    public int getTotalPaginas() {
        return TotalPaginas;
    }

    public void setTotalPaginas(int TotalPaginas) {
        TotalPaginas = TotalPaginas;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(int paginaActual) {
        this.paginaActual = paginaActual;
    }

    public List<PageItem> getPaginas() {
        return paginas;
    }

    public void setPaginas(List<PageItem> paginas) {
        this.paginas = paginas;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isFirst(){
        return page.isFirst();
    }
    public boolean isLast(){
        return page.isLast();
    }
    public boolean isHasNext(){
        return page.hasNext();
    }
    public boolean isHasPrevious(){
        return page.hasPrevious();
    }
}
