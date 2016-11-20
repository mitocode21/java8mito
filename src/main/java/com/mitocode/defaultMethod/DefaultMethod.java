package com.mitocode.defaultMethod;

public class DefaultMethod implements PersonaA, PersonaB{

	@Override
	public void caminar() {		
		System.out.println("Hola Coders");
	}	
		
	@Override
	public void hablar() {
		//PersonaB.super.hablar();
		System.out.println("Suscribanse Coders");
	}
	
	/*@Override
	public void hablar() {
		PersonaB.super.hablar();
	
	}*/

	public static void main(String[] args) {
		DefaultMethod app = new DefaultMethod();
		app.hablar();
	}
	
}
