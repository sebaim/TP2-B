package lista;

public class Lista<T> {

	private Nodo<T> primero;
	private Nodo<T> ultimo;

	public Lista() {

		primero = null;
		ultimo = null;
	}

	/*
	 * Inserta un elemento al final.
	 */
	public void push_back(T dato) {

		Nodo<T> nuevo = new Nodo<T>();
		nuevo.setData(dato);
		nuevo.setSiguiente(null);

		// Si la lista está vacía
		if (primero == null) {

			primero = nuevo;
			ultimo = nuevo;

		} else {
			// La lista no está vacía

			ultimo.setSiguiente(nuevo);
			ultimo = nuevo;
		}
	}

	/*
	 * Elimina un elmento del final
	 */
	public T pop_back() {

		// Sin elementos en la lista
		if (primero == null) {

			return null;
		}

		// Si hay un solo elemento en la lista
		if (primero == ultimo) {

			T retorno = primero.getData();
			primero = null;
			ultimo = null;
			return retorno;
		}

		// Caso donde se tiene mas de un elemento en la lista

		Nodo<T> aux = primero;
		Nodo<T> anteUltimo = aux;

		// Posiciono a la variable "aux" en el anteúltimo de la lista
		while (aux != null && aux.getSiguiente() != null) {

			anteUltimo = aux;
			aux = aux.getSiguiente();
		}

		T retorno = anteUltimo.getSiguiente().getData();
		anteUltimo.setSiguiente(null);
		ultimo = anteUltimo;
		return retorno;
	}

	/*
	 * Inserta un elemento al comienzo.
	 */
	public void push_front(T dato) {

		Nodo<T> nuevo = new Nodo<T>();
		nuevo.setData(dato);

		// Si la lista está vacia
		if (primero == null) {

			nuevo.setSiguiente(null);
			primero = nuevo;
			ultimo = nuevo;

			return;
		}

		// La lista tiene un elemento
		if (primero == ultimo) {

			primero = nuevo;
			nuevo.setSiguiente(ultimo);

			return;
		}

		// La lista tiene mas de un elemento
		nuevo.setSiguiente(primero);
		primero = nuevo;

	}

	/*
	 * Borra un elemento al comienzo.
	 */
	public T pop_front() {

		// Si la lista está vacía
		if (primero == null) {

			return null;
		}

		// Si la lista tiene un elemento
		if (primero == ultimo) {

			ultimo = null;
			T retorno = primero.getData();
			primero = null;
			return retorno;
		}

		// La lista tiene mas de un elemento
		T retorno = primero.getData();
		primero = primero.getSiguiente();
		return retorno;
	}

	// /*
	// * Elimina un elemento de un valor determinado.
	// */
	// public boolean remove(T dato) {
	//
	// Nodo<T> aux = lista;
	// Nodo<T> ultimo = aux;
	//
	// while (aux != null && aux.getSiguiente() != null
	// && !dato.equals(aux.getData())) {
	//
	// ultimo = aux;
	// aux = aux.getSiguiente();
	// }
	//
	// // Lista vacia
	// if (lista == null) {
	//
	// return false;
	// }
	//
	// // Se llego al final de lista sin encontrarlo
	// if (aux == null) {
	//
	// return false;
	// }
	//
	// // Se encontro el dato
	// if (dato.equals(aux.getData())) {
	//
	// // si es el primero de la lista
	// if (ultimo == aux) {
	//
	// lista = ultimo.getSiguiente();
	// } else {
	// ultimo.setSiguiente(aux.getSiguiente());
	// }
	// return true;
	// }
	//
	// return false;
	// }
	//
	// /*
	// * invierte el orden de los elementos en la lista
	// */
	// // public void reverse(){
	// //
	// //
	// // }
	//
	// // insert(posición, dato )//insertar
	//
	// /*
	// * Eliminar por posición
	// */
	// // public boolean erase(int pos){
	// //
	// // Nodo<T> aux = lista;
	// // Nodo<T> anterior = aux;
	// // int i = 1;
	// //
	// // while ( aux != null && i < pos){
	// //
	// // i++;
	// // anterior = aux;
	// // aux = aux.getSiguiente();
	// // }
	// //
	// // if ( i == pos && aux != null){
	// //
	// // anterior.setSiguiente(aux.getSiguiente());
	// // return true;
	// // }
	// //
	// // return false;
	// // }

	/*
	 * Pregunta si la lista esta vacia.
	 */
	public boolean empty() {

		return (this.primero == null);
	}

	/*
	 * Busca un dato en la lista y devuelve su primera aparición
	 */
	public int buscar(T dato) {

		// Si la lista esta vacia
		if (this.empty()) {

			return -1;
		}

		Nodo<T> aux = primero;
		int i = 1;

		// Busca el dato en la lista
		while (aux != null && !dato.equals(aux.getData())) {

			aux = aux.getSiguiente();
			i++;
		}

		if (aux == null) {
			// Si la variable "aux" es nula es porque no lo encontro
			return -1;

		} else {
			// Si no es nula la variable "aux" es porque lo encontro en la
			// posicion "i"

			return i;
		}
	}

	// public T buscar(int pos) {
	//
	// Nodo<T> aux = lista;
	// int i = 1;
	//
	// while (i < pos && aux != null) {
	//
	// i++;
	// aux = aux.getSiguiente();
	// }
	//
	// if (aux == null) {
	//
	// return null;
	// }
	//
	// if (i > pos) {
	//
	// return null;
	// }
	//
	// if (i == pos) {
	//
	// return aux.getData();
	// }
	//
	// return null;
	// }

	/*
	 * Vacia la lista
	 */
	public void vaciar() {

		primero = null;
		ultimo = null;
	}

	public String toString() {

		StringBuilder str = new StringBuilder();
		Nodo<T> aux = primero;

		while (aux != null) {

			str.append(aux.getData() + " | ");
			aux = aux.getSiguiente();
		}

		return str.toString();
	}

	public static void main(String[] args) {

		Lista<Integer> l = new Lista<Integer>();

		l.push_front(new Integer(4));

		// l.push_front(new Integer(500));
		// l.push_front(new Integer(5000));
		// l.push_back(new Integer(5));

		System.out.println(l.pop_front());
		l.push_back(new Integer(5));
		System.out.println(l);

	}
}
