package cola;

import lista.Lista;

public class ColaCL<T> implements ColaInterface<T> {

	Lista<T> cola;
	
	public ColaCL(){
		
		cola = new Lista<T>();
	}
	
	@Override
	public boolean empty() {
		
		return cola.empty();
	}

	@Override
	public void offer(T dato) {
		
		cola.push_back(dato);		
	}

	@Override
	public T poll() {
		
		return cola.pop_front();
	}

	@Override
	public T peek() {
		
		return cola.mostrar_primero();
	}

	@Override
	public void vaciar() {
		
		cola.vaciar();
	}
	
	public static void main(String[] args) {

		ColaInterface<Integer> c = new ColaCL<Integer>();
	}

}
