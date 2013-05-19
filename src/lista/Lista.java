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
	 * Elimina un elemento del final
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

	// invierte el orden de los elementos en la lista

	public void reverse() {
		Lista<T> lista = new Lista<T>();
		while (!this.empty()) {
			lista.push_front(this.pop_front());
		}

	}

	// insertar en una posiion
	public boolean insert(int posicion, T dato) {
		Nodo<T> nuevo = new Nodo<T>();
		nuevo.setData(dato);

		Nodo<T> ant = this.primero;
		Nodo<T> act = ant;

		int contPos = 0;

		while (act != null && contPos != posicion) {
			ant = act;
			act = act.getSiguiente();
			contPos++;
		}

		if (contPos != posicion) // si no hay la cantidad de elementos para
									// insertar en esa posicion
			return false;

		ant.setSiguiente(nuevo);
		nuevo.setSiguiente(act);
		return true;

	}

	// elimina de una posicion determinada
	public boolean erase(int posicion) {
		Nodo<T> ant = this.primero;
		Nodo<T> act = ant;

		int contPos = 0;

		while (act != null && contPos != posicion) {
			ant = act;
			act = act.getSiguiente();
			contPos++;
		}

		if (contPos != posicion) // si no hay la cant de elemenos para llegar a
									// borrar en esa posicion
			return false;

		ant.setSiguiente(act.getSiguiente());

		return true;

	}

	public boolean remove(T dato) {
		if (this.primero == null)
			return false;
		Nodo<T> act = this.primero;
		Nodo<T> ant = this.primero;

		while (act != null && !act.getData().equals(dato)) {
			ant = act;
			act = act.getSiguiente();
		}

		if (act == null)// si no lo encontro
			return false;

		if (act == ant) // si es el primero
			this.primero = act.getSiguiente();

		if (act.getSiguiente() == null) // si es el ultimo
			this.ultimo = ant;

		ant.setSiguiente(act.getSiguiente());

		return true;

	}

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

	/*
	 * Busca un nodo por la posicion "pos" pasada por parametro, y devuelve el
	 * dato que contiene.
	 */
	public T buscar(int pos) {

		// Lista vacia
		if (this.empty()) {

			return null;
		}

		Nodo<T> aux = primero;
		int i = 1;

		// Recorro la lista, hasta llegar al final o a una posicion
		// mayor a la buscada
		while (i < pos && aux != null) {

			i++;
			aux = aux.getSiguiente();
		}

		// Si se llego al final de la lista
		if (aux == null) {

			return null;
		}

		// Se encontro la posicion en la lista
		if (i == pos) {

			return aux.getData();
		}

		return null;
	}

	/*
	 * Vacia la lista
	 */
	public void vaciar() {

		primero = null;
		ultimo = null;
	}

	/*
	 * Muestra el contenido del primer nodo
	 */
	public T mostrar_primero() {

		if (!this.empty()) {
			return primero.getData();
		}

		return null;
	}

	/*
	 * Muestra el contenido del ultimo nodo
	 */
	public T mostrar_ultimo() {

		if (!this.empty()) {
			return ultimo.getData();
		}

		return null;
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
		l.push_back(new Integer(6));
		System.out.println(l);

	}
}
