package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JsonUtiles {

	public static void grabarCliente(JSONArray array) {
		try {
			FileWriter file = new FileWriter("clientes.json");
			file.write(array.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void grabarMedico(JSONArray array) {
		try {
			FileWriter file = new FileWriter("medicos.json");
			file.write(array.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	public static void pasarMedico(JSONObject obj){ //TODO test agregar medicos a json
		obj.put("id: ", )
	}*/

	public static void grabarMascota(JSONArray array) {
		try {
			FileWriter file = new FileWriter("animales.json");
			file.write(array.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void grabarTurno(JSONArray array) {
		try {
			FileWriter file = new FileWriter("turnos.json");
			file.write(array.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String leer(String archivo)
	{
		String contenido = "";
		try
		{
			contenido = new String(Files.readAllBytes(Paths.get(archivo+".json")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return contenido;
	}
}