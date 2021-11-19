public class ArrayDeque<Item> implements Deque<Item> {
	private Item[] items;
	private int size;
	private int nextFirst = 0;
	private int nextLast = 1;

	public ArrayDeque(){
		size = 0;
		items = (Item[])new Object[8];
	}
	@Override
	public boolean isEmpty(){
		if (size == 0){
			return true;
		}
		else return false;
	}
	@Override
	public int size(){
		return size;
	}
	private void resize(int res){
		Item[] a = (Item[])new Object[res];
		for(int i = 0; i < size; i++){
			a[i] = items[plusOne(nextFirst)];
			nextFirst = plusOne(nextFirst);
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
	@Override
	public void addLast(Item item){
		if (size == items.length){
			resize(size * 2);
		}
		items[nextLast] = item;
		nextLast = plusOne(nextLast);
		size += 1;
	}
	@Override
	public void addFirst(Item item){
		if (size == items.length){
			resize(size * 2);
		}
		items[nextFirst] = item;
		nextFirst = minusOne(nextFirst);
		size += 1;
	}
	@Override
	public Item get(int index){
		if(index > size - 1){
			return null;
		}
		int st = plusOne(nextFirst);
		return items[(index + st)% items.length];
	}
	@Override
	public void printDeque(){
		int pos = plusOne(nextFirst);
		for(int i = 0; i < size; i++){
			System.out.print(items[pos] + " ");
			pos = plusOne(pos);
		}
	}
	@Override
	public Item removeFirst(){
		if (size == 0){
			return null;
		}
		Item temp = items[plusOne(nextFirst)];
		nextFirst = plusOne(nextFirst);
		items[nextFirst] = null;
		double a = size;
		double b = items.length;
		double R = a / b;
		if (items.length > 16 && R < 0.25){
			resize(items.length / 2);
		}
		size -= 1;
		return temp;
	}
	@Override
	public Item removeLast(){
		if(size == 0){
			return null;
		}
		Item temp = items[minusOne(nextLast)];
		nextLast = minusOne(nextLast);
		items[nextLast] = null;
		double a = size;
		double b = items.length;
		double R = a / b;
		if (items.length > 16 && R < 0.25){
			resize(items.length / 2);
		}
		size -= 1;
		return temp;
	}

}