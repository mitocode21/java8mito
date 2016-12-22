package com.mitocode.methodReference;

import java.util.Arrays;
import java.util.Comparator;

public class MeRefApp {

	public static void referenciarMetodoStatic() {
		System.out.println("Método Referido static");
	}

	public void referenciarMetodoInstanciaObjetoArbitrario() {
		String[] nombres = { "Mito", "Code", "Jaime" };

		/*
		 * Arrays.sort(nombres, new Comparator<String>() {
		 * 
		 * @Override public int compare(String o1, String o2) { return
		 * o1.compareToIgnoreCase(o2); } });
		 */

		// Arrays.sort(nombres, (s1,s2) -> s1.compareToIgnoreCase(s2));
		// System.out.println(Arrays.toString(nombres));

		Arrays.sort(nombres, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(nombres));
	}

	public void referenciarMetodoInstanciaObjetoParticular() {
		System.out.println("Método Referido Instancia de Objeto en particular");
	}

	public void referenciarConstructor() {
		/*
		 * IPersona iper = new IPersona(){
		 * 
		 * @Override public Persona crear(int id, String nombre) { return new
		 * Persona(id, nombre); }
		 * 
		 * }; iper.crear(1, "MitoCode");
		 */

		/*
		 * IPersona iper2 = (x,y)->(new Persona(x,y)); Persona per =
		 * iper2.crear(1, "MitoCode");
		 * System.out.println(per.getId()+" - "+per.getNombre());
		 */

		IPersona iper3 = Persona::new;
		Persona per = iper3.crear(1, "MitoCode");
		System.out.println(per.getId() + " - " + per.getNombre());
	}

	public void operar() {
		// Operacion op = () -> MeRefApp.referenciarMetodoStatic();
		// op.saludar();

		Operacion op2 = MeRefApp::referenciarMetodoStatic;
		op2.saludar();
	}

	public static void main(String[] args) {
		MeRefApp app = new MeRefApp();
		// app.operar();
		// app.referenciarMetodoInstanciaObjetoArbitrario();
		// Operacion op = app::referenciarMetodoInstanciaObjetoParticular;
		// op.saludar();
		app.referenciarConstructor();
	}
}
