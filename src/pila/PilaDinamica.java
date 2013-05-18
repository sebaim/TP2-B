package pila;

import lista.Lista;

public class PilaDinamica<T> implements PilaInterface<T> {

	private Lista<T> pila;

	PilaDinamica(){
		
		pila = new Lista<T>();
	}
	
	@Override
	public boolean empty() {
		
		return pila.empty();
	}

	@Override
	public T peek() {

		return pila.ver_ultimo();
	}

	@Override
	public T pop() {

		return pila.pop_back();
	}

	@Override
	public void push(T dato) {
		
		pila.push_back(dato);
	}

	@Override
	public void vaciar() {
		
		pila.vaciar();
	}

	public static void main(String[] args) {

		PilaDinamica<Integer> p = new PilaDinamica<Integer>();
		
		System.out.println(p.peek());
		p.push(new Integer(5));
		System.out.println(p.peek());
		p.push(new Integer(50));
		p.push(new Integer(500));
		p.push(new Integer(5000));
		p.push(new Integer(4));
		System.out.println(p.peek());
		System.out.println(p.pop());
		System.out.println(p.peek());
		
	}
}
