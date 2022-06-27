package com.company.view;

import com.company.Veterinaria;
import com.company.enums.AnimalType;
import com.company.model.Animal;
import com.company.model.Cliente;
import com.company.model.Medico;
import com.company.model.Turno;

import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientMenu {

    Cliente cliente;
    Veterinaria vet;
    static Scanner scanner = new Scanner(System.in);


    public void clientMenu() {
        int opcion=-1; //Guardaremos la opcion del usuario
        ///System.out.println("Pet System");
        System.out.println("1. Ver mascotas");
        System.out.println("2. Agregar mascota");
        System.out.println("3. Sacar turno");
        System.out.println("4. Salir");


        try{
            opcion = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Debe ingresar un numero de opcion valida");
            scanner.nextLine();
        }

        scanner.reset();
        switch (opcion) {
            case 1:
                System.out.println("Lista animales");
                cliente.listaMascotas();
                break;
            case 2:
                System.out.println("Agregar mascota");
                agregarMascota();
                break;
            case 3:
                System.out.println("Sacar turno");
                sacarTurno();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("\nIngrese una opcion valida");
                clientMenu();
        }


    }

    public void agregarMascota(){
        Scanner scanner=new Scanner(System.in);
        int aux =0;
        System.out.println("Ingresar nombre del animal: ");
        String nom = scanner.nextLine();
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
        scanner.skip("\n");
        String raza = scanner.nextLine();
        System.out.println("Esta castrado? S/N");
        char s=scanner.next().charAt(0);
        boolean castrado;
        if (s=='s' ||s=='s'){castrado=true;}
        else {castrado=false;}
        System.out.println("De que color es?");
        scanner.skip("\n");
        String color=scanner.nextLine();
        System.out.println("Que edad tiene?");
        int age= scanner.nextInt();
        System.out.println("De que genero es?");
        scanner.skip("\n");
        String genero=scanner.nextLine();
        scanner.close();
        Animal ani = new Animal(nom,type,raza,castrado,color,age,genero);
        cliente.addAnimal(ani);
    }
    public Animal selecionarAnimal(){
        Animal a1;
        int aux;
        cliente.listaMascotas();
        if(cliente.getMascotas().size()>1) {
            System.out.println("Que mascota desea seleccionar?");
            aux=scanner.nextInt()-1;
            a1=cliente.getMascotas().get(aux);
        }//TODO agregar excepcion si no existe mascota
        else{a1=cliente.getMascotas().get(0);}
        return a1;
    }
    public Medico seleccionarMedico(){
        Medico m;
        int aux;
        vet.mostrarMedicos();
        System.out.println("Por que veterinario desea ser atendido? Seleccione por numero de id: ");
        scanner.skip("\n");
        aux= scanner.nextInt()-1;
        m=vet.getMedicList().get(aux);
        return m;
    }
    public void sacarTurno(){
        Animal a=selecionarAnimal();
        Medico m=seleccionarMedico();
        LocalDate date;
        System.out.println("Para que fecha desea el turno?");
        String fecha = scanner.nextLine();
        date= LocalDate.parse(fecha);
        Turno t = new Turno(a,m,cliente,date);
    }

}


