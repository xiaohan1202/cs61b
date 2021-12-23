package lab11.graphs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {

//    public int[] distTo;
//    public int[] edgeTo;
//    public boolean[] marked;

    private int s;
    private int t;
    private Maze maze;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;// Add more variables here!
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs() {
        Queue<Integer> fringe = new LinkedList<>();
        fringe.offer(s);
        marked[s] = true;
        announce();
        while(!fringe.isEmpty() && fringe.peek() != t) {
            int v = fringe.poll();
            for(int w : maze.adj(v)) {
                if (marked[w] == false){
                    marked[w] = true;
                    fringe.offer(w);
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    announce();
                }
            }
        }
        // TODO: Your code here. Don't forget to update distTo, edgeTo, and marked, as well as call announce()
    }


    @Override
    public void solve() {
         bfs();
    }
}

