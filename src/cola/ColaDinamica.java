package cola;

import lista.Lista;

public class ColaDinamica<T> implements ColaInterface<T> {

	private Lista<T> cola;

	public ColaDinamica() {

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
	public T peek() {

		return cola.ver_primero();
	}

	@Override
	public T poll() {

		return cola.pop_front();
	}

	@Override
	public void vaciar() {

		cola.vaciar();
	}

	public static void main(String[] args) {

		ColaDinamica<Integer> c = new ColaDinamica<Integer>();

		System.out.println(c.empty());
		// System.out.println(c.peek());
		c.offer(new Integer(1));
		c.offer(new Integer(2));
		c.offer(new Integer(3));
		System.out.println(c.peek());
		System.out.println(c.poll());
		c.offer(new Integer(4));
		System.out.println(c.peek());
		System.out.println(c.poll());
		System.out.println(c.poll());
		System.out.println(c.poll());
		System.out.println(c.poll());

	}
}
