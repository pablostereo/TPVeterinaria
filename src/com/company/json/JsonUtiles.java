package com.company.json;

import com.company.model.Medico;
import com.company.model.Turno;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class JsonUtiles {
	public JsonUtiles() {
	}

	public static void grabarMedico(JSONArray array) {
		try {
			FileWriter file = new FileWriter("medicos.json");
			file.write(array.toString());
			file.flush();
			file.close();
		} catch (IOException var2) {
			var2.printStackTrace();
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
		} catch (JSONException var4) {
			System.out.println(var4);
		}

	}

	public static void grabarTurno(JSONArray array) {
		try {
			FileWriter file = new FileWriter("turnos.json");
			file.write(array.toString());
			file.flush();
			file.close();
		} catch (IOException var2) {
			var2.printStackTrace();
		}

	}

	public static String leer(String archivo) {
		String contenido = "";

		try {
			contenido = new String(Files.readAllBytes(Paths.get(archivo)));
		} catch (IOException var3) {
			var3.printStackTrace();
		}

		return contenido;
	}

	public static void pasarTurno(JSONArray arr, Turno tur) throws JSONException {
		JSONObject obj = new JSONObject();

		try {
			obj.put("mascota: ", tur.getMascota());
			obj.put("medico: ", tur.getMedico());
			obj.put("cliente: ", tur.getCliente());
			obj.put("informe: ", tur.getInforme());
			obj.put("fecha: ", tur.getFecha());
			arr.put(obj);
			grabarTurno(arr);
		} catch (JSONException var4) {
			System.out.println(var4);
		}

	}
}
