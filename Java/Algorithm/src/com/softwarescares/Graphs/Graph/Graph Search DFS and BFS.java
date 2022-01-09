public class Graph 
{
    private HashMap<Integer, Node> nodeLookup = new HashMap<Integer Node>();

    public static class Node 
    {
        private int id;
        LinkedList<Node> adjacent = new LinkedList<Node>();
        private Node(int id)
        {
            this.id = id;
        }
    }

    private Node getNode(int id) {}

    public void addEdge(int source, int destination) {}

    public boolean hasPathsDFS(int source, int destination)
    {
        Node a = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashMap<Integer>();
        return hasPathsDFS(s, d, visited);
    }

    private boolean hasPathsDFS(Node source, Node destination, HashSet<Integer> visited)
    {
        if(visited.contains(source.id))
        {
            return false;
        }
        visited.add(source.id);
        if(source == destination)
        {
            return true;
        }

        for (Node child : source.adjacent)
        {
            if(hasPathsDFS(source, destination, visited))
            {
                return true;
            }
        }
        return false;
    }

    private boolean hasPathsDFS(Node source, Node destination)
    {

        LinkedList<Node> adjacent = new LinkedList<Node>();
        HashSet<Integer> visited = new HashMap<Integer>();
        nextToVisit.add(source);

        while(!nextToVisit.isEmpty())
        {
            Node node = nextToVisit.remove();
            if(node == destination)
            {
                return true;
            }


            if(visited.contains(node.id))
            {
                continue;
            }
            visited.add(node.id)
        }
    }

}