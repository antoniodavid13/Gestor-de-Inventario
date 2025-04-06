package com.practica.GestionInv;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {

    private String nombre;
    private int edad;
    private double credito;

    public Cliente(String nombre, int edad, double credito)throws Exception {
        this.nombre = nombre;
        if(edad>18){
            this.edad = edad;

        }else{
            throw new Exception("El menor por lo tanto no puede comprar");

        }
        this.credito = credito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }
    public Producto comprar(Producto p,double numero){
        if(credito<numero){
            System.out.println("No tienes el suficiente credito para comprar los productos");
        }else{
            credito-=numero;
            return p;

        }
        return null;
    }
    public void mostrardatos() {
        System.out.println("Nombre: "+nombre);
        System.out.println("Edad: "+edad);
        System.out.println("Credito: "+credito);


    }

    public void actualizardatos(String nombre) throws InputMismatchException{
        Scanner sc=new Scanner(System.in);
        boolean t;
        do{
            t=true;
            switch (nombre.toLowerCase()){
                case "nombre":
                    System.out.println("Introduce un nuevo nombre: ");
                        String nuevo_nombre=sc.next();
                        this.nombre=nuevo_nombre;
                        break;
                case "edad" :
                    System.out.println("Introduce una nueva edad: ");
                    if(sc.hasNextInt()){
                        int nueva_edad=sc.nextInt();
                        this.edad=nueva_edad;
                        break;

                    }else{
                        throw new InputMismatchException();
                    }
                case "credito":
                    System.out.println("Introduce un nuevo credito");
                        if(sc.hasNextDouble()){
                            double credito_nuevo=sc.nextDouble();
                            this.credito=credito_nuevo;

                        }else{
                            throw new InputMismatchException();
                        }
                        break;
                default:
                    System.out.println("No has elegido una de las opciones, intentelo de nuevo");
                    t=false;
                    break;

            }
        }while(!t);


    }








}
