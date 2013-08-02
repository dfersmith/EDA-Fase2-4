package edalib.list;

public interface IStack<E> {

	public boolean isEmpty();

	public void push(E elem);

	public E pop();

	public E top();

}
