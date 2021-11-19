public class LinkedListDeque<Item> implements Deque<Item>{
	private IntNode sentinel;
	private int size;
	private IntNode q;

	private class IntNode {
		public IntNode prev;
		public Item item;
		public IntNode next;
		public IntNode(Item item, IntNode prev, IntNode next){
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

	@Override
	public void addLast(Item item){
		size += 1;
		IntNode p = sentinel;
		p.prev = new IntNode(item, p.prev, p);
		p.prev.prev.next = p.prev;
	}
	@Override
	public void addFirst(Item item){
		size += 1;
		IntNode p = sentinel;
		p.next = new IntNode(item, p, p.next);
		p.next.next.prev = p.next;
	}
	@Override
	public int size(){
		return size;
	}
	@Override
	public boolean isEmpty(){
		if(size == 0)
			return true;
		else return false;
	}
	@Override
	public void printDeque(){
		IntNode p = sentinel;
		while(p.next.item != null){
        System.out.print(p.next.item + " ");
        p = p.next;
    	}
	}
	@Override
	public Item removeFirst(){
		IntNode p = sentinel;
		if (p.next == p){
			return null;
		}
		Item res = p.next.item;
		p.next = p.next.next;
		p.next.prev = p;
		size = size - 1;
		return res;
	}
	@Override
	public Item removeLast(){
		IntNode p = sentinel;
		if (p.next == p){
			return null;
		}
		Item res = p.prev.item;
		p.prev = p.prev.prev;
		p.prev.next = p;
		size = size - 1;
		return res;
	}
	@Override
	public Item get(int index){
		IntNode p = sentinel.next;
		if(index > size - 1){
			return null;
		}
		for(int i = 0; i <= index; i++){
			if(i == index)
				return p.item;
			p = p.next;
		}
		return null;
	}

	public Item getRecursive(int index){
		if(index > size - 1 || index < 0){
			return null;
		}
		if(index == 0){
			Item res = q.next.item;
			q = sentinel;
			return res;
		}
		else q = q.next;
		return getRecursive(index - 1);
	}
}