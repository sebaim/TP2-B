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

		if (lista == null) {

			lista = nuevo;

		} else {

			Nodo<T> aux = lista;
			Nodo<T> ultimo = aux;
			while (aux != null) {

				ultimo = aux;
				aux = aux.getSiguiente();
			}
			ultimo.setSiguiente(nuevo);
		}
	}

	/*
	 * Elimina un elmento del final
	 */
	public T pop_back() {

		Nodo<T> aux = lista;
		Nodo<T> ultimo = aux;

		while (aux != null && aux.getSiguiente() != null) {

			ultimo = aux;
			aux = aux.getSiguiente();
		}

		// Sin elementos
		if (lista == null) {

			return null;
		}

		// Un solo elemento
		if (aux == lista) {

			T retorno = aux.getData();
			lista = null;
			return retorno;
		}

		// Mas de un elemento
		if (lista != null) {

			T retorno = ultimo.getSiguiente().getData();
			ultimo.setSiguiente(null);
			return retorno;
		}

		return null;
	}

	/*
	 * Inserta un elemento al comienzo.
	 */
	public void push_front(T dato) {

		Nodo<T> nuevo = new Nodo<T>();
		nuevo.setData(dato);

		if (lista == null) {

			nuevo.setSiguiente(null);
		} else {

			nuevo.setSiguiente(lista);
		}

		lista = nuevo;
	}

	/*
	 * Borra un elemento al comienzo.
	 */
	public T pop_front() {

		if (lista != null) {

			Nodo<T> retorno = lista;
			lista = lista.getSiguiente();
			return retorno.getData();
		}

		return null;
	}

	/*
	 * Elimina un elemento de un valor determinado.
	 */
	public boolean remove(T dato) {

		Nodo<T> aux = lista;
		Nodo<T> ultimo = aux;

		while (aux != null && aux.getSiguiente() != null
				&& !dato.equals(aux.getData())) {

			ultimo = aux;
			aux = aux.getSiguiente();
		}

		// Lista vacia
		if (lista == null){
			
			return false;
		}
		
		// Se llego al final de lista sin encontrarlo
		if (aux == null) {

			return false;
		}

		// Se encontro el dato
		if (dato.equals(aux.getData())) {

			// si es el primero de la lista
			if ( ultimo == aux) {
			
				lista = ultimo.getSiguiente();
			} else {
				ultimo.setSiguiente(aux.getSiguiente());
			}
			return true;
		}

		return false;
	}

	/*
	 * invierte el orden de los elementos en la lista
	 */
	// public void reverse(){
	//		
	//			
	// }

	// insert(posición, dato )//insertar

	/*
	 * Eliminar por posición
	 */
	// public boolean erase(int pos){
	//		
	// Nodo<T> aux = lista;
	// Nodo<T> anterior = aux;
	// int i = 1;
	//		
	// while ( aux != null && i < pos){
	//		
	// i++;
	// anterior = aux;
	// aux = aux.getSiguiente();
	// }
	//		
	// if ( i == pos && aux != null){
	//			
	// anterior.setSiguiente(aux.getSiguiente());
	// return true;
	// }
	//		
	// return false;
	// }

	public boolean empty() {

		return this.lista == null;
	}

	public int buscar(T dato) {

		Nodo<T> aux = lista;
		int i = 1;

		while (aux != null && !dato.equals(aux.getData())) {

			aux = aux.getSiguiente();
			i++;
		}

		if (aux == null) {

			return -1;

		} else {

			return i;
		}
	}

	public T buscar(int pos) {

		Nodo<T> aux = lista;
		int i = 1;

		while (i < pos && aux != null) {

			i++;
			aux = aux.getSiguiente();
		}

		if (aux == null) {

			return null;
		}

		if (i > pos) {

			return null;
		}

		if (i == pos) {

			return aux.getData();
		}

		return null;
	}

	public void vaciar() {

		lista = null;
	}
	
	public T ver_primero(){
		
		if (lista != null){
			
			return lista.getData();
		} else {
			
			return null;
		}
	}
	
	public T ver_ultimo(){
		
		Nodo<T> aux = lista;
		Nodo<T> ultimo = aux;
		
		while( aux != null ){
		
			ultimo = aux;
			aux = aux.getSiguiente();
		}
		
		if (lista==null){
			
			return null;
		}
	
		return ultimo.getData();
	}

	public String toString() {

		StringBuilder str = new StringBuilder();
		Nodo<T> aux = lista;

		while (aux != null) {

			str.append(aux.getData() + " | ");
			aux = aux.getSiguiente();
		}

		return str.toString();
	}

	public static void main(String[] args) {

		Lista<Integer> l = new Lista<Integer>();

		l.push_front(new Integer(4));
		l.push_back(new Integer(50));
//		l.push_front(new Integer(500));
//		l.push_front(new Integer(5000));
//		l.push_back(new Integer(5));

		System.out.println(l);
		System.out.println(l.remove(new Integer(500)));
		l.push_front(new Integer(5));
		System.out.println(l);

	}
}
