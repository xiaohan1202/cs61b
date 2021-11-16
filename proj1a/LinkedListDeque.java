public class LinkedListDeque<T> {
	private IntNode sentinel;
	private int size;
	private IntNode q;

	private class IntNode {
		public IntNode prev;
		public T item;
		public IntNode next;
		public IntNode(T item, IntNode prev, IntNode next){
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
	}

	public LinkedListDeque() {
		sentinel = new IntNode(null, null, null);
		sentinel.prev = sentinel;
		sentinel.next = sentinel;
		q = sentinel;
		size = 0;
	}

	public void addLast(T item){
		size += 1;
		IntNode p = sentinel;
		p.prev = new IntNode(item, p.prev, p);
		p.prev.prev.next = p.prev;
	}
	public void addFirst(T item){
		size += 1;
		IntNode p = sentinel;
		p.next = new IntNode(item, p, p.next);
		p.next.next.prev = p.next;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		if(size == 0)
			return true;
		else return false;
	}
	public void printDeque(){
		IntNode p = sentinel;
		while(p.next.item != null){
        System.out.print(p.next.item + " ");
        p = p.next;
    }
	}
	public T removeFirst(){
		size = size - 1;
		IntNode p = sentinel;
		if (p.next.item == null){
			return null;
		}
		p.next = p.next.next;
		p.next.prev = p;
		return p.next.item;
	}
	public T removeLast(){
		size = size - 1;
		IntNode p = sentinel;
		if (p.next.item == null){
			return null;
		}
		p.prev = p.prev.prev;
		p.prev.next = p;
		return p.prev.item;
	}
	public T get(int index){
		IntNode p = sentinel.next;
		if(index > size - 1){
			return null;
		}
		for(int i = 0; i < index; i++){
			p = p.next;
		}
		return p.item;
	}

	public T getRecursive(int index){
		if(index > size - 1){
			return null;
		}
		if(index == 0){
			T res = q.next.item;
			q = sentinel;
			return res;
		}
		else q = q.next;
		return getRecursive(index - 1);
	}
}