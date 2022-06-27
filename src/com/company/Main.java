package com.company;

import com.company.enums.AnimalType;
import com.company.model.Cliente;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
	Veterinaria vet = new Veterinaria("Tito");


	vet.addMedico("Perez","45674152","123","Perros");
	vet.addMedico("Lopez","20658456","456","Gatos");
	//c1.addAnimal(p1);
	//vet.agrCliente(c1);
	vet.addCliente("Julieta","40987654","Belgrano 3214","4751654");
	vet.addCliente("Juan","12456789","Rivadavia 4716","4456712");
	//vet.mostrarMedicos();
	vet.agregarAnimal(vet.getClientList().get(0),"Pepe",AnimalType.CANINO,"Pitbul",true,"Blanco",4,"Macho");
	//vet.agregarMascota();
	//vet.mostrarClientes();
	vet.sacarTurno();
	vet.mostrarTurnos();

    }
}
