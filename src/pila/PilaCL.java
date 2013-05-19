package pila;

import lista.Lista;

public class PilaCL<T> implements PilaInterface<T>{

	private Lista<T> pila;
	
	public PilaCL(){
		
		pila = new Lista<T>();
	}

	@Override
	public boolean empty() {
	
		return pila.empty();
	}

	@Override
	public T peek() {
		
		return pila.mostrar_primero();
	}

	@Override
	public void vaciar() {
		
		pila.vaciar();
	}

	@Override
	public T pop() {
		
		T dato = pila.pop_front();
		
		return dato;
	}

	@Override
	public void push(T dato) {
		
		pila.push_front(dato);		
	}

	public static void main(String[] args) {


		PilaInterface<Integer> p = new PilaCL<Integer>();
		
		System.out.println(p.empty());
		System.out.println(p.peek());
		System.out.println(p.pop());
		p.push(new Integer(1));
		p.push(new Integer(10));
		p.push(new Integer(100));
		System.out.println(p.pop());
		p.push(new Integer(1000));
		System.out.println(p.pop());
		System.out.println(p.pop());
		System.out.println(p.pop());
		System.out.println(p.pop());
		
	}

}
