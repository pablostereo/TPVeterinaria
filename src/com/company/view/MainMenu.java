package com.company.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    static Scanner scanner = new Scanner(System.in);


    public void menuMain() {
        int s;
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
                //regist();
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

}
