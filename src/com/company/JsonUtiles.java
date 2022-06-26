package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.company.model.*;
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
	public static void pasarCliente(JSONArray arr, Cliente cli) throws JSONException {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id: ", cli.getId());
			obj.put("nombre: ", cli.getNombre());
			obj.put("dni: ", cli.getDni());
			obj.put("direccion: ", cli.getDireccion());
			obj.put("telefono: ", cli.getTelefono());
			obj.put("mascotas: ", cli.getMascotas());

			arr.put(obj);
			grabarCliente(arr);
		} catch (JSONException ex) {
			System.out.println(ex);
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

	public static void pasarMedico(JSONArray arr, Medico med) throws JSONException {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id: ", med.getId());
			obj.put("nombre: ", med.getNombre());
			obj.put("matricula: ", med.getMatricula());
			obj.put("especializacion: ", med.getEspecializacion());
			arr.put(obj);
			grabarMedico(arr);
		} catch (JSONException ex) {
			System.out.println(ex);
		}
	}

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
	public static void pasarMascota(JSONArray arr, Animal ani) throws JSONException {
		JSONObject obj = new JSONObject();

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