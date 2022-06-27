
package com.company.view;

import com.company.archivo.Archivos;
import com.company.enums.AnimalType;
import com.company.excepciones.ClienteNoEncontrado;
import com.company.excepciones.ContraseñaIncorrecta;
import com.company.json.JsonUtiles;
import com.company.model.Animal;
import com.company.model.Cliente;
import com.company.model.Veterinaria;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuIteraccion {
    public MenuIteraccion() {
    }

    public void clientMenu(String archivo, String nombre, String medicos) {
        Archivos file = new Archivos();
        ArrayList<Cliente> clientes = file.devolverClientes(archivo);
        Cliente cliente = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("-------BIENVENIDO A LA VETERINARIA " + nombre + "-------");
        System.out.println("¿Es usted un cliente regitrado? S/N");
        char ask = sc.next().charAt(0);
        int id;
        int contraseña;
        String nom = "";
        Animal animal = null;
        if (ask != 's' && ask != 'S') {
            cliente = this.cargarCliente(archivo);
            animal = this.cargarAnimal();
            cliente.addAnimal(animal);
            clientes.add(cliente);
            file.cargarClienteAlFinal(archivo, cliente);
        } else {
            System.out.println("Ingrese su ID para buscarlo en el sistema:");
            id = sc.nextInt();

            try {
                if (this.accederAUsuario(clientes, id)) {
                    cliente = this.devolverPorID(clientes, id);

                    do {
                        do {
                            System.out.println("Ingrese su contraseña:");
                            contraseña = sc.nextInt();

                            try {
                                if (this.ComprobarContraseña(cliente, contraseña)) {
                                    animal = this.cargarAnimal();
                                    file.agregarAnimales(archivo, id, animal);
                                }
                            } catch (ContraseñaIncorrecta var15) {
                                System.out.println(var15.getMessage());
                                System.out.println("¿Quiere probar nuevamente con el ingreso de la contraseña?");
                                ask = sc.next().charAt(0);
                            }
                        } while(ask == 's');
                    } while(ask == 'S');
                }
            } catch (ClienteNoEncontrado var16) {
                System.out.println(var16.getMessage());
                cliente = this.cargarCliente(archivo);
                animal = this.cargarAnimal();
                cliente.addAnimal(animal);
                clientes.add(cliente);
                file.cargarClienteAlFinal(archivo, cliente);
                file.mostrar(archivo);
            }
        }

        new JsonUtiles();
        Veterinaria vet = new Veterinaria(nombre);
        System.out.println("Ingrese el nombre de su mascota para revisar:");
        nom = sc.next();
        System.out.println("Veterinarios disponibles:");
        System.out.println(JsonUtiles.leer(medicos));
        vet.sacarTurno(cliente, nom);
        sc.close();
    }

    public boolean accederAUsuario(ArrayList<Cliente> lista, int id) throws ClienteNoEncontrado {
        Cliente cliente = null;
        boolean acceder = false;

        for(int i = 0; i < lista.size(); ++i) {
            cliente = (Cliente)lista.get(i);
            if (cliente.getId() == id) {
                acceder = true;
            }
        }

        if (!acceder) {
            throw new ClienteNoEncontrado("No encontrado.", id);
        } else {
            return acceder;
        }
    }

    public Cliente cargarCliente(String file) {
        Cliente cliente = null;
        Scanner sc = new Scanner(System.in);
        Archivos archivos = new Archivos();
        int id = archivos.devolverUltimoID(file) + 1;
        System.out.println("Se le ha asignaso un ID único, es: " + id);
        System.out.println("Ingrese su nombre y apellido:");
        String nombre = sc.next();
        System.out.println("Ingrese su DNI:");
        String dni = sc.next();
        System.out.println("Ingrese su dirección:");
        String direccion = sc.next();
        System.out.println("Ingrese su teléfono:");
        String telefono = sc.next();
        System.out.println("Ingrese su contraseña:");
        int contraseña = sc.nextInt();
        cliente = new Cliente(id, nombre, dni, direccion, telefono, contraseña);
        return cliente;
    }

    public Animal cargarAnimal() {
        int aux;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar nombre del animal: ");
        String nombre = sc.next();
        System.out.println("Que tipo de animal es? ");
        System.out.println("1.Felino");
        System.out.println("2.Canino");
        System.out.println("3.Ave");
        System.out.println("4.Roedor");
        System.out.println("5.Reptil");
        AnimalType type = null;

        while(type == null) {
            System.out.println("Ingrese una opcion:");
            aux = sc.nextInt();
            if (aux == 1) {
                type = AnimalType.FELINO;
            } else if (aux == 2) {
                type = AnimalType.CANINO;
            } else if (aux == 3) {
                type = AnimalType.AVE;
            } else if (aux == 4) {
                type = AnimalType.ROEDOR;
            } else if (aux == 5) {
                type = AnimalType.REPTIL;
            } else {
                System.out.println("Opcion no valida");
            }
        }

        System.out.println("Raza o tipo?");
        String raza = sc.next();
        System.out.println("Esta castrado? S/N");
        char s = sc.next().charAt(0);
        boolean castrado;
        if (s != 's' && s != 's') {
            castrado = false;
        } else {
            castrado = true;
        }

        System.out.println("De que color es?");
        String color = sc.next();
        System.out.println("Que edad tiene?");
        int age = sc.nextInt();
        System.out.println("De que genero es?");
        String genero = sc.next();
        Animal ani = new Animal(nombre, type, raza, castrado, color, age, genero);
        return ani;
    }

    public Cliente devolverPorID(ArrayList<Cliente> lista, int id) {
        Cliente cliente = null;
        Cliente aux = null;

        for(int i = 0; i < lista.size(); ++i) {
            cliente = (Cliente)lista.get(i);
            if (cliente.getId() == id) {
                ;
            }
        }

        return cliente;
    }

    public boolean ComprobarContraseña(Cliente cliente, int contraseña) throws ContraseñaIncorrecta {
        boolean acceder = false;
        if (cliente.getContraseña() == contraseña) {
            acceder = true;
            System.out.println(acceder);
            return acceder;
        } else {
            throw new ContraseñaIncorrecta("Contraseña Incorrecta.");
        }
    }
}
