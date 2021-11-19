import static java.lang.Math.abs;

public class OffByN implements CharacterComparator{
    private int n;
    public OffByN(int N){
        n = N;
    }
    @Override
    public boolean equalChars(char x, char y){
        if(abs(x - y) == n){
            return true;
        }
        return false;
    }
}