package com.practica.GestionInv;

public class Pedido {
    private Cliente c;
    private Producto p;
    private String fecha;

    public Pedido(Cliente c, Producto p, String fecha) {
        this.c = c;
        this.p = p;
        this.fecha = fecha;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public Producto getP() {
        return p;
    }

    public void setP(Producto p) {
        this.p = p;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void mostrardatos(){
        System.out.println("Cliente: "+c.getNombre());
        System.out.println("Producto: "+p.getNombre());
        System.out.println("Fecha "+fecha);
    }
}
