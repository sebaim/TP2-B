package pila;

public interface PilaInterface<T>{

	public boolean empty();
	
	public T peek();
	
	public void vaciar();
	
	public T pop();

	public void push(T dato);
	
}
