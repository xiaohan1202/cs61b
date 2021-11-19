public class Palindrome {
	public Deque<Character> wordToDeque(String word){
		Deque<Character> d = new LinkedListDeque<>();
		for(int i = 0; i < word.length(); i++){
			d.addLast(word.charAt(i));
		}
		return d;
	}
	private static String dequeToWord(Deque<Character> d){
		String s = "";
		Deque<Character> m = d;
		while(!m.isEmpty()){
			s = s + m.removeFirst();
		}
		return s;
	}
	public boolean isPalindrome(String word){
		Deque<Character> d = wordToDeque(word);
		if(d.isEmpty() || d.size() == 1) {
			return true;
		}
		if(d.removeFirst() == d.removeLast()){
			return isPalindrome(dequeToWord(d));
		}
		else return false;
	}
	public boolean isPalindrome(String word, CharacterComparator cc){
		Deque<Character> d = wordToDeque(word);
		if(d.isEmpty() || d.size() == 1) {
			return true;
		}
		if(cc.equalChars(d.removeFirst(), d.removeLast())){
			return isPalindrome(dequeToWord(d), cc);
		}
		else return false;
	}

//	public static void main(String arg[]){
//		Deque<Character> d = new LinkedListDeque<>();
//		d.addLast('a');
//		d.addLast('b');
//		d.addLast('c');
//		String s = dequeToWord(d);
//		System.out.println(s);
//	}
}