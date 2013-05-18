package lista;

public class Nodo<T> {

	private T data;
	private Nodo<T> siguiente;

	public Nodo(){
		
		this.data = null;
		this.siguiente = null;
	}
	
	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}

	public Nodo<T> getSiguiente() {
		return siguiente;
	}

}
