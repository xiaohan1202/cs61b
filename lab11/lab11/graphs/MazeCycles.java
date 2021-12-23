package lab11.graphs;

import edu.princeton.cs.algs4.Stack;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private class Node {
        int v;
        int parent;
        public Node(int v, int parent){
            this.v = v;
            this.parent = parent;
        }
    }

    public MazeCycles(Maze m) {
        super(m);
    }

    @Override
    public void solve() {
        dfs(new Node(0, 0));
        while(!stack.isEmpty()) {
            int v = stack.pop();
            if(stack.isEmpty()) break;
            edgeTo[v] = stack.peek();
            announce();
        }
        // TODO: Your code here!
    }
    private boolean cycle = false;
    private boolean overlap;
    private int overlapPoint;
    private Stack<Integer> stack = new Stack<>();
    private void dfs(Node node) {
        marked[node.v] = true;
        announce();
        for (int w : maze.adj(node.v)) {
            if(marked[w] && w != node.parent) {
                cycle = true;
                stack.push(w);
                overlap = false;
                overlapPoint = w;
                return;
            }
            if(!marked[w]) {
                marked[w] = true;
                dfs(new Node(w, node.v));
            }
            if(cycle) {
                if(overlap == false) {
                    stack.push(w);
                }
                if(overlapPoint == w) {
                    overlap = true;
                }
                return;
            }
        }
    }

    // Helper methods go here
}

