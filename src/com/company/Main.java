package com.company;

import com.company.view.MenuIteraccion;

public class Main {
	static final String file = "files.bin";

	public Main() {
	}

	public static void main(String[] args) {
		MenuIteraccion menu = new MenuIteraccion();
		menu.clientMenu("files.bin", "EL TEMPLO", "medicos.json");
	}
}
