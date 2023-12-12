package algo.graph;

class Edge {
    //it is the source vertex
    private Node u;
    //it is the destination vertex
    private Node v;
    //it denotes the weight on edge
    private int w;

    public Edge(Node u, Node v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public Node getU() {
        return u;
    }

    public void setU(Node u) {
        this.u = u;
    }

    public Node getV() {
        return v;
    }

    public void setV(Node v) {
        this.v = v;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }
}