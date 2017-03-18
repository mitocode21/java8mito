package com.mitocode.rxjava;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;

public class RxApp {

	private List<Integer> lista1;
	private List<Integer> lista2;

	public RxApp() {
		lista1 = new ArrayList<>();
		lista2 = new ArrayList<>();
		this.llenarListas();
	}

	public void llenarListas() {
		for (int i = 0; i < 10000; i++) {
			lista1.add(i);
			lista2.add(i);
		}
	}

	public void buscar() {
		Observable<Integer> obs1 = Observable.from(lista1);
		Observable<Integer> obs2 = Observable.from(lista2);
		
		/*Observable.merge(obs1, obs2).subscribe(new Action1<Integer>(){

			@Override
			public void call(Integer numero) {
				if(numero == 1){
					System.out.println(numero);
				}
			}			
		});*/
		
		Observable.merge(obs1, obs2).filter(x->x==1).subscribe(System.out::println);
		Observable.merge(obs1, obs2).filter(x->x==1).subscribe(x -> {
			if(x == 1){
				System.out.println(x);
			}
		});
	}

	public static void main(String[] args) {
		/*
		 * List<String> lista = new ArrayList<>(); lista.add("Mito");
		 * lista.add("Code"); lista.add("MitoCode");
		 * 
		 * Observable<String> obs = Observable.from(lista); obs.subscribe(new
		 * Action1<String>(){
		 * 
		 * @Override public void call(String elemento) {
		 * System.out.println(elemento); }
		 * 
		 * });
		 */
		
		RxApp app = new RxApp();
		app.buscar();

	}
}
