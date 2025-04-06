package com.practica.GestionPedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class Principal {

	public static void main(String[] args) {
		SpringApplication.run(Principal.class, args);
		String nombre;
		int edad;
		double credito;
try{


		Scanner sc = new Scanner(System.in);
		ArrayList<Producto> p=new ArrayList<>(1);
		p.add(new Producto("Manzana", 1.99, 30));
		p.add(new Producto("Peras",2.99,15));
		p.add(new Producto("Piña",3.99,10));

		System.out.println("Cuantos clientes quieres crear\n");
		ArrayList<Cliente>c=new ArrayList<>();
		int num=sc.nextInt();
		for(int i=1; i<=num;i++) {
			System.out.println("Datos del Cliente: "+i);
			System.out.print("Nombre: ");
			nombre = sc.next();
			System.out.print("Edad: ");
			edad = sc.nextInt();
			System.out.print("Credito: ");
			credito = sc.nextDouble();
			c.add(new Cliente(nombre, edad, credito));
		}
		ArrayList<Pedido>pd=new ArrayList<>();
		Cliente c1=seleccionar_cliente(c);
		menu(p,c1,pd);





		}catch(InputMismatchException e){
			System.out.println("Error: Debido al ingreso de valores");
		}catch (Exception e){
	System.out.println("Error");
		}


	}
	public static void menu(ArrayList<Producto> p,Cliente c , ArrayList<Pedido> pd)throws InputMismatchException , Exception{
		boolean rt=true;
		do {
			System.out.println("-----------------Menu---------------------");
			System.out.println("Selecciona un número:\n");
			System.out.println("Comprar:  1\n");
			System.out.println("Mostrar Perfil:  2\n");
			System.out.println("Editar Perfil:  3\n");
			System.out.println("Ver Pedidos: 4 \n");
			System.out.println("Salir:   5\n");
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				int numero = sc.nextInt();
				switch (numero) {
					case 1:
						System.out.println("-----------------Menu---------------------");
						System.out.println("Selecciona un producto y la cantidad que deseas\n");
						System.out.println("Manzana:  1\n");
						System.out.println("Peras:  2\n");
						System.out.println("Piña:  3\n");
						System.out.println("Salir:   4\n");
						if (sc.hasNextInt()) {
							int cantidad;
							System.out.print("Producto: ");
							System.out.println(numero = sc.nextInt());
							System.out.println("Cantidad: ");
							System.out.println(cantidad = sc.nextInt());

							double precio_final=p.get(numero-1).calcularprecio(cantidad);
							Producto pr = c.comprar(p.get(numero - 1), precio_final);
							pd.add(new Pedido(c, pr, "2025/04/06"));

							break;
						} else {
							throw new InputMismatchException();

						}
					case 2:
						c.mostrardatos();
						break;

					case 3:
						System.out.print("Que dato quieres cambiar:  ");
						String nombre = sc.next();
						c.actualizardatos(nombre);
						break;
					case 4:
						System.out.print("Elige un pedido por fecha: ");
						String fecha_pedido = sc.next();
						for (Pedido pde : pd) {
							if (pde.getFecha().equalsIgnoreCase(fecha_pedido)) {
								pde.mostrardatos();
							}

						}
						break;


					case 5:
						System.out.println("Saliendo del sistema");
						rt=false;
						break;

					default:
						throw new Exception("Has Elegido otro numero");
				}


			} else {
				throw new InputMismatchException();
			}
		}while(rt);
	}
	public  static Cliente seleccionar_cliente(ArrayList<Cliente> c) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Selecciona al cliente a partir de su nombre");
		String nombre=sc.next();
		for(Cliente cl:c){
			if(cl.getNombre().equalsIgnoreCase(nombre)) {
				return cl;
			}

		}

        return null;
    }

}
