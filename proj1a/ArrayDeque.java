public class ArrayDeque<T>{
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
		System.arraycopy(items, 0, a, 0, size);
		items = a;
		size += 1;
	}
	private int plusOne(int index){
		if(index == size - 1){
			return 0;
		}
		else return index + 1;
	}
	private int minusOne(int index){
		if(index == 0){
			return size - 1;
		}
		else return index - 1;
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
		for(int i = 0; i < size; i++){
			System.out.print(items[i] + " ");
		}
	}
	public T removeFirst(){
		nextFirst = plusOne(nextFirst);
		items[nextFirst] = null;
		double R = size / items.length * 1.0;
		if (R < 0.25){
			resize(items.length / 2);
		}
		return items[plusOne(nextFirst)];
	}
	public T removeLast(){
		nextLast = minusOne(nextLast);
		items[nextLast] = null;
		double R = size / items.length * 1.0;
		if (R < 0.25){
			resize(items.length / 2);
		}
		return items[minusOne(nextLast)];
	}

}