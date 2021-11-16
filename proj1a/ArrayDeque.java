public class ArrayDeque<T> {
	private T[] items;
	private int size;
	private int nextFirst = 0;
	private int nextLast = 1;

	public ArrayDeque(){
		size = 0;
		items = (T[])new Object[8];
	}

	public boolean isEmpty(){
		if (size == 0){
			return true;
		}
		else return false;
	}
	public int size(){
		return size;
	}
	public void resize(int res){
		T[] a = (T[])new Object[res];
		for(int i = 0; i < size; i++){
			a[i] = items[nextLast];
			nextLast = plusOne(nextLast);
		}
		nextLast = size;
		nextFirst = a.length - 1;
		items = a;
	}
	private int plusOne(int index){
		return(index + 1) % items.length;
	}
	private int minusOne(int index){
		return(index - 1 + items.length) % items.length;
	}
	public void addLast(T item){
		if (size == items.length){
			resize(size * 2);
		}
		items[nextLast] = item;
		nextLast = plusOne(nextLast);
		size += 1;
	}
	public void addFirst(T item){
		if (size == items.length){
			resize(size * 2);
		}
		items[nextFirst] = item;
		nextFirst = minusOne(nextFirst);
		size += 1;
	}
	public T get(int index){
		return items[index];
	}
	public void printDeque(){
		int pos = plusOne(nextFirst);
		for(int i = 0; i < size; i++){
			System.out.print(items[pos] + " ");
			pos = plusOne(pos);
		}
	}
	public T removeFirst(){
		nextFirst = plusOne(nextFirst);
		items[nextFirst] = null;
		double a = size;
		double b = items.length;
		double R = a / b;
		if (R < 0.25){
			resize(items.length / 2);
		}
		size -= 1;
		return items[plusOne(nextFirst)];
	}
	public T removeLast(){
		nextLast = minusOne(nextLast);
		items[nextLast] = null;
		double R = size / items.length * 1.0;
		if (items.length > 16 && R < 0.25){
			resize(items.length / 2);
		}
		size -= 1;
		return items[minusOne(nextLast)];
	}

}