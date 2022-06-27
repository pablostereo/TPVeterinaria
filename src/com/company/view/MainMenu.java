/*package com.company.view;

import com.company.model.Veterinaria;
import com.company.model.Cliente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    static Scanner scanner = new Scanner(System.in);
    Veterinaria vet = new Veterinaria("Petship");

    public void menuMain() {
        int opcion=-1; //Guardaremos la opcion del usuario
        System.out.println("Pet System");
        System.out.println("1. Ingresar");
        System.out.println("2. Registrarse");
        System.out.println("3. Salir");


        try{
            opcion = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Debe ingresar un numero de opcion valida");
            scanner.nextLine();
        }

        scanner.reset();
        switch (opcion) {
            case 1:
                System.out.println("Ingreso");
                //login();

                break;
            case 2:
                System.out.println("Registro");

                menuMain();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("\nIngrese una opcion valida");
                menuMain();
        }


    }

    ///Login
    private void login() {

        Cliente u1 = new Cliente();
        System.out.println("\nIngresar mail ");
        scanner.skip("\n");
        String userName = scanner.nextLine();
        if(!new Cliente().(userName)) {
            System.out.println("\nIngresar password ");
            String password =scanner.nextLine();
            u1 = u1.login(userName,
                    password);
            if (u1!= null) {
                System.out.println("\nSu usuario se ha conectado correctamente\n");
                UserMenu uMenu = new UserMenu(u1);
                uMenu.menu();
            } else {
                System.out.println("\nUsuario o password incorrecto. Volviendo al menu principal.\n");
                this.menuMain();
            }
        }
        else {
            if(userName.equalsIgnoreCase("admin")){
                System.out.println("\nIngresar password de admin");
                String password = scanner.nextLine();
                if (password.equalsIgnoreCase("admin")) {
                    new AdminMenu().menu();
                } else {
                    menuMain();
                }
            }
            else {
                System.out.println("Ese usuario no esta registrado");
                System.out.println("Desea registrarse ?Y/N");
                char c = scanner.next().charAt(0);
                if (c == 'y' || c == 'Y') {
                    regist();
                } else {
                    menuMain();
                }
            }
        }
    }

    ///Registro
    /*private void regist() {
        User u1 = new User();
        System.out.println("\nIngresar nombre de usuario");
        scanner.skip("\n");
        String nameUser = scanner.nextLine();
        if (u1.browsUser(nameUser)) {
            System.out.println("\nIngresar nombre ");
            String name = scanner.nextLine();
            System.out.println("\nIngresar apellido ");
            String surname = scanner.nextLine();
            System.out.println("\nIngresar password ");
            String password = scanner.nextLine();
            System.out.println("\nIngresar mail ");
            String mail = scanner.nextLine();
            System.out.println("\nIngresar nro telefonico ");
            int phone = scanner.nextInt();
            User u2 = new User(nameUser, password, name, surname, mail, phone);
            u2.register(u2);
            System.out.println("\nUsuario registrado correctamente\n\n");
            //char c = scanner.next().charAt(0);
            //if (c == 'y' || c == 'Y') {
            menuMain();
        }
    }*/

package com.company.view;

import com.company.archivo.Archivos;
import com.company.enums.AnimalType;
import com.company.excepciones.ClienteNoEncontrado;
import com.company.model.Animal;
import com.company.model.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    public void clientMenu(String archivo, String nombre) {
        Archivos file = new Archivos();
        ArrayList<Cliente> clientes = file.devolverClientes(archivo);
        Cliente cliente = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("-------BIENVENIDO A LA VETERINARIA " + nombre + "-------");
        System.out.println("Es usted un cliente regitrado? S/N");
        char ask = sc.next().charAt(0);
        int id = 0;
        int contraseña = 0;
        Animal animal = null;
        if(ask == 's' || ask == 'S') {
            System.out.println("Ingrese su ID para buscarlo en el sistema:");
            id = sc.nextInt();
            try {
                if(accederAUsuario(clientes,id) == true) {

                }
            }
            catch (ClienteNoEncontrado e) {
                System.out.println(e.getMessage());
                cliente = cargarCliente(archivo);
                animal = cargarAnimal();
                cliente.addAnimal(animal);
                clientes.add(cliente);
                file.cargarClienteAlFinal(archivo, cliente);
                file.mostrar(archivo);
            }
        }
        else {
            cliente = cargarCliente(archivo);
            animal = cargarAnimal();
            cliente.addAnimal(animal);
            clientes.add(cliente);
            file.cargarClienteAlFinal(archivo, cliente);
        }
    }

    public boolean accederAUsuario(ArrayList<Cliente> lista, int id) throws ClienteNoEncontrado {
        Cliente cliente = null;
        boolean acceder = false;
        for(int i = 0; i < lista.size(); i++) {
            cliente = lista.get(i);
            if(cliente.getId() == id) {
                acceder = true;
            }
        }
        if(acceder == false) {
            throw new ClienteNoEncontrado("No encontrado.", id);
        }
        return acceder;
    }

    public Cliente cargarCliente(String file) {
        Cliente cliente = null;
        Scanner sc=new Scanner(System.in);

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

        sc.close();
        cliente = new Cliente(id,nombre,dni,direccion,telefono,contraseña);
        return cliente;
    }

    public Animal cargarAnimal() {
        Scanner scanner=new Scanner(System.in);
        int aux =0;
        System.out.println("Ingresar nombre del animal: ");
        String nom = scanner.next();
        System.out.println("Que tipo de animal es? ");
        System.out.println("1.Felino");
        System.out.println("2.Canino");
        System.out.println("3.Ave");
        System.out.println("4.Roedor");
        System.out.println("5.Reptil");
        AnimalType type=null;
        while (type==null) {
            System.out.println("Ingrese una opcion:");
            aux= scanner.nextInt();
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
        String raza = scanner.next();

        System.out.println("Esta castrado? S/N");
        char s=scanner.next().charAt(0);
        boolean castrado;
        if (s=='s' ||s=='S'){castrado=true;}
        else {castrado=false;}

        System.out.println("De que color es?");
        String color=scanner.next();

        System.out.println("Que edad tiene?");
        int age= scanner.nextInt();

        System.out.println("De que genero es?");
        String genero=scanner.next();

        scanner.close();

        Animal ani = new Animal(nom,type,raza,castrado,color,age,genero);

        return ani;
    }
}


