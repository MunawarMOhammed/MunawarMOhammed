import java.util.*;
class Graphs{ // USing BFS (Breadth Firsth Search)
    private LinkedList<Integer> adj[];
    public Graphs(int v){
        adj=new LinkedList[v];
        for(int i =0;i<v;i++){
            adj[i]=new LinkedList<Integer>();
        }
    }
    public void addEdge(int source , int destination){
        adj[source].add(destination);
        adj[destination].add(source);

    }
    public int  BFS(int soruce, int destination){
        boolean visited[]= new boolean[adj.length];
        int parent[]=new int[adj.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(soruce);
        visited[soruce]=true;
        parent [soruce]=-1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == destination) break;
            else {
                for (int neighbour : adj[cur]) {
                    if (!visited[neighbour]) {
                        visited[neighbour] = true;
                        q.add(neighbour);
                        parent[neighbour] = cur;
                    }
                }
            }
        }
        int cur = destination;
        int distance =0;
        while (parent[cur]!= -1){
            System.out.print(cur+" -> ");
            cur = parent[cur];
            distance++;
        }


         return distance;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("ENter the no. vertices :");
        int vertices = sc.nextInt();
        System.out.println("ENTer the no. edges :");
        int edges = sc.nextInt();
        Graphs graphs = new Graphs(vertices);
        System.out.println("Enter "+edges+" edges:");
        for(int i = 0;i<edges;i++){
           int source = sc.nextInt();
           int destination = sc.nextInt();
           graphs.addEdge(source,destination);
        }
        System.out.print("Enter source and destination to find shortest distance between them :");
        int source =sc.nextInt();
        int detination = sc.nextInt();
        System.out.println("shortest distance is "+graphs.BFS(source,detination));


    }
}
