package pila;

import lista.Lista;

public class PilaHL<T> extends Lista<T> implements PilaInterface<T> {

	@Override
	public T peek() {
		
		return super.mostrar_primero();
	}

	@Override
	public T pop() {

		T dato = this.pop_front();
		
		return dato;
	}

	@Override
	public void push(T dato) {
		
		this.push_front(dato);
	}

	@Override
	public void vaciar() {

		super.vaciar();
	}

	@Override
	public boolean empty() {

		return super.empty();
	}

	public static void main(String[] args) {

		PilaInterface<Integer> p = new PilaHL<Integer>();
		
		System.out.println(p.empty());
		System.out.println(p.peek());
		System.out.println(p.pop());
		p.push(new Integer(1));
		System.out.println(p.peek());
		p.push(new Integer(10));
		p.push(new Integer(100));
		System.out.println(p.empty());
		System.out.println(p.pop());
		p.push(new Integer(100));
		p.vaciar();
		System.out.println(p.empty());
		System.out.println(p.pop());
		
		
	}

}
