package com.company;

import com.company.model.Cliente;
import com.company.model.Perro;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
	Veterinaria vet = new Veterinaria("Tito");

	vet.addMedico("Perez","123","Loros");
	vet.addMedico("Lopez","456","Ropes");
	Cliente c1 = new Cliente(1,"Pablo","36382901","Belgrano 4716","4751111");
	Perro p1 = new Perro("Firulais",4,"Problemas renales","Bulldog",true);
	c1.addAnimal(p1);
	vet.agrCliente(c1);
	vet.addCliente("Julieta","40987654","Belgrano 3214","4751654");
	vet.addCliente("Juan","12456789","Rivadavia 4716","4456712");

	vet.mostrarClientes();
    }
}
