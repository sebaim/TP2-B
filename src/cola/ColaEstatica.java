package cola;

public class ColaEstatica<T> implements ColaInterface<T> {

	private T[] vCola;
	private int frente;
	private int cola;

	public ColaEstatica(int tam) {

		vCola = (T[]) new Object[tam];
		frente = 0;
		cola = tam - 1;
	}

	@Override
	public boolean empty() {

		return this.frente == (this.cola + 1) % vCola.length;
	}

	@Override
	public void offer(T dato) {

		if (!this.llena()) {
			this.cola = (this.cola + 1) % vCola.length;
			this.vCola[this.cola] = dato;
		}
	}

	@Override
	public T peek() {

		if (!this.empty()) {

			return this.vCola[this.frente];

		} else

			return null;
	}

	@Override
	public T poll() {

		if (!this.empty()) {

			T res = this.vCola[this.frente];
			this.frente = (this.frente + 1) % vCola.length;

			return res;
		} else

			return null;
	}

	@Override
	public void vaciar() {

		this.frente = 0;
		this.cola = this.vCola.length - 1;
	}

	public boolean llena() {

		return this.frente == (this.cola + 2) % vCola.length;
	}

	public static void main(String[] args) {

	}
}
