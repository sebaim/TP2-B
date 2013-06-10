package cola;

public interface Cola<T> {

    public boolean empty();

    public void offer( T dato );

    public T poll();

    public T peek();
    
    public void vaciar();
	
}
