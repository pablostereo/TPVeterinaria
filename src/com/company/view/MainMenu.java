package com.company.view;

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
   /* private void login() {

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
        }*/
    }


