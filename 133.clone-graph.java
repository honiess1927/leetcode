/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
	Map<Node, Node> map = new HashMap<>();
	public Node cloneGraph(Node node) {
		if (node == null) return null;
		if (map.containsKey(node)) return map.get(node);
		Node cur = new Node();
		cur.val = node.val;
		map.put(node, cur);
		cur.neighbors = new LinkedList<>();
		for (Node neighbor : node.neighbors) {
			cur.neighbors.add(cloneGraph(neighbor));
		}
		return cur;
	}
}
