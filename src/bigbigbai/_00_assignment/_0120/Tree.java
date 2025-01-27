package bigbigbai._00_assignment._0120;

public class Tree {
    public int x;
    public Tree l;
    public Tree r;

    public Tree() {}

    public Tree(int x) {
        this.x = x;
    }

    public Tree(int x, Tree l, Tree r) {
        this.x = x;
        this.l = l;
        this.r = r;
    }
}
