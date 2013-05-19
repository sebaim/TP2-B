package cola;

import lista.Lista;

public class ColaHL<T> extends Lista<T> implements ColaInterface<T> {

	@Override
	public boolean empty(){
		
		return super.empty();
	}
	
	@Override
	public void vaciar(){
		
		super.vaciar();
	}
	
	@Override
	public void offer(T dato) {
		
		push_back(dato);		
	}

	@Override
	public T poll() {
		
		return pop_front();
	}

	@Override
	public T peek() {
		
		return mostrar_primero();
	}
	
	
	public static void main(String[] args) {

		ColaInterface<Integer> c = new ColaHL<Integer>();
	}

}
