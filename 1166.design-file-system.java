class FileSystem {

    private final class Node {
        Map<String, Node> next;
        Integer value;

        Node(int value) {
            this.next = new HashMap<>();
            this.value = value;
        }

        public Node getNext(String path) {
            return next.get(path);
        }

        public Node createAndGetNext(String path, int value) {
            next.put(path, new Node(value));
            return next.get(path);
        }
    }

    private Node root;

    public FileSystem() {
        root = new Node(-1);
    }

    public boolean createPath(String path, int value) {
        String[] dirs = path.split("/");
        // print(dirs.length);
        Node cur = root;
        for (int i = 1; i < dirs.length - 1; i++) {
            cur = cur.getNext(dirs[i]);
            if (cur == null) return false;
        }
        String cdir = dirs[dirs.length - 1];
        if (cur.getNext(cdir) != null) return false;
        cur = cur.createAndGetNext(cdir, value);
        return true;
    }

    public int get(String path) {
        Node cur = root;
        String[] dirs = path.split("/");
        for (int i = 1; i < dirs.length; i++) {
            cur = cur.getNext(dirs[i]);
            if (cur == null) return -1;
        }
        return cur.value;
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
