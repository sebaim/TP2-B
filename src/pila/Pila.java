package pila;

public interface Pila<T>{

	public boolean empty();
	
	public T peek();
	
	public void vaciar();
	
	public T pop();

	public void push(T dato);
	
}
