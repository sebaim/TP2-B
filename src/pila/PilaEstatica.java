package pila;

public class PilaEstatica<T> implements PilaInterface<T> {

	private T[] pila;
	private int tope;

	PilaEstatica(int tam) {

		pila = (T[]) new Object[tam];
		tope = 0;
	}

	public boolean empty() {

		if (tope == 0) {

			return true;
		} else {

			return false;
		}
	}

	public T peek() {

		if (tope != 0) {

			return pila[tope-1];
		} else {

			return null;
		}
	}

	public void push(Object dato) {

		if ( tope == pila.length +1) {

			return;

		} else {

			pila[tope] = (T) dato;
			tope++;
		}

	}

	public void vaciar() {

		tope = 0;
	}

	public T pop() {

		if ( tope == 0){
			
			return null;
		}else {
			
			return pila[--tope];
		}
	}

	public static void main(String[] args) {

		PilaEstatica<Integer> pila = new PilaEstatica<Integer>(5);

		pila.push(new Integer(2));
		pila.push(new Integer(4));
		pila.push(new Integer(5));
		pila.push(new Integer(6));
		pila.push(new Integer(7));

		pila.vaciar();
		
		System.out.println(pila.empty());
		System.out.println(pila.pop());
		System.out.println(pila.pop());
		pila.push(new Integer(2));
		System.out.println(pila.pop());
		pila.push(new Integer(20));
		pila.push(new Integer(200));
		pila.push(new Integer(2000));
		System.out.println(pila.peek());

	}

}
