package edalib.list;

public interface IQueue<E> {

	public boolean isEmpty();

	public void enqueue(E elem);

	public E dequeue();

	public E front();

	

}
