import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    ArrayDequeSolution<String> show = new ArrayDequeSolution<>();

    private String message(){
        String m = "\n";
        if (show.size() < 3) {
            for (String s : show) {
                m = m.concat(s + "\n");
            }
        }
        else {
            for(int j = show.size() - 3; j <= show.size() - 1; j++){
                m = m.concat(show.get(j) + "\n");
            }
        }
        return m;
    }
    @Test
    public void task1(){
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

        for (int i = 0; i < 500; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.25) {
                sad.addLast(i);
                ads.addLast(i);
                show.addLast("addLast(" + i + ")");
            } else if (numberBetweenZeroAndOne >= 0.25 && numberBetweenZeroAndOne < 0.5) {
                sad.addFirst(i);
                ads.addFirst(i);
                show.addLast("addFirst(" + i + ")");
            } else if (numberBetweenZeroAndOne >= 0.5 && numberBetweenZeroAndOne <0.75) {
                assertEquals(message() + "size()", sad.size(), ads.size());
                if(ads.size() != 0) {
                    show.addLast("removeLast()");
                    assertEquals(message(), ads.removeLast(), sad.removeLast());
                }
            } else {
                assertEquals(message() + "size()", sad.size(), ads.size());
                if(ads.size() != 0) {
                    show.addLast("removeFirst()");
//                    System.out.println(sad.removeFirst());
//                    System.out.println(ads.removeFirst());
                    assertEquals(message(), ads.removeFirst(), sad.removeFirst());
                }
            }
        }
    }
}
