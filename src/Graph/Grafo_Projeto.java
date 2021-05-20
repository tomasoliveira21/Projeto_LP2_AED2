package Graph;

import edu.princeton.cs.algs4.*;

import java.util.NoSuchElementException;

public class Grafo_Projeto {
        private static final String NEWLINE = System.getProperty("line.separator");

        private int V;                // number of vertices in this digraph
        private int E;                      // number of edges in this digraph
        private Bag<Aresta_Projeto>[] adj;    // adj[v] = adjacency list for vertex v
        private int[] indegree;             // indegree[v] = indegree of vertex v

        /**
         * Initializes an empty edge-weighted digraph with {@code V} vertices and 0 edges.
         *
         * @param  V the number of vertices
         * @throws IllegalArgumentException if {@code V < 0}
         */
        public Grafo_Projeto(int V) {
            if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be non-negative");
            this.V = V;
            this.E = 0;
            this.indegree = new int[V];
            adj = (Bag<Aresta_Projeto>[]) new Bag[V];
            for (int v = 0; v < V; v++)
                adj[v] = new Bag<Aresta_Projeto>();
        }

        /**
         * Initializes a random edge-weighted digraph with {@code V} vertices and <em>E</em> edges.
         *
         * @param  V the number of vertices
         * @param  E the number of edges
         * @throws IllegalArgumentException if {@code V < 0}
         * @throws IllegalArgumentException if {@code E < 0}
         */
        public Grafo_Projeto(int V, int E) {
            this(V);
            if (E < 0) throw new IllegalArgumentException("Number of edges in a Digraph must be non-negative");
            for (int i = 0; i < E; i++) {
                int v = StdRandom.uniform(V);
                int w = StdRandom.uniform(V);
                double km = 0.01 * StdRandom.uniform(100);
                double time = 0.01 * StdRandom.uniform(100);
                Aresta_Projeto e = new Aresta_Projeto(v, w, km,time);
                addEdge(e);
            }
        }

        /**
         * Initializes an edge-weighted digraph from the specified input stream.
         * The format is the number of vertices <em>V</em>,
         * followed by the number of edges <em>E</em>,
         * followed by <em>E</em> pairs of vertices and edge weights,
         * with each entry separated by whitespace.
         *
         * @param  in the input stream
         * @throws IllegalArgumentException if {@code in} is {@code null}
         * @throws IllegalArgumentException if the endpoints of any edge are not in prescribed range
         * @throws IllegalArgumentException if the number of vertices or edges is negative
         */
        public Grafo_Projeto(In in) {
            if (in == null) throw new IllegalArgumentException("argument is null");
            try {
                this.V = in.readInt();
                if (V < 0) throw new IllegalArgumentException("number of vertices in a Digraph must be non-negative");
                indegree = new int[V];
                adj = (Bag<Aresta_Projeto>[]) new Bag[V];
                for (int v = 0; v < V; v++) {
                    adj[v] = new Bag<Aresta_Projeto>();
                }

                int E = in.readInt();
                if (E < 0) throw new IllegalArgumentException("Number of edges must be non-negative");
                for (int i = 0; i < E; i++) {
                    int v = in.readInt();
                    int w = in.readInt();
                    validateVertex(v);
                    validateVertex(w);
                    double km = in.readDouble();
                    double time = in.readDouble();
                    addEdge(new Aresta_Projeto(v, w, km,time));
                }
            }
            catch (NoSuchElementException e) {
                throw new IllegalArgumentException("invalid input format in EdgeWeightedDigraph constructor", e);
            }
        }

        /**
         * Initializes a new edge-weighted digraph that is a deep copy of {@code G}.
         *
         * @param  G the edge-weighted digraph to copy
         */
        public Grafo_Projeto(Grafo_Projeto G) {
            this(G.V());
            this.E = G.E();
            for (int v = 0; v < G.V(); v++)
                this.indegree[v] = G.indegree(v);
            for (int v = 0; v < G.V(); v++) {
                // reverse so that adjacency list is in same order as original
                Stack<Aresta_Projeto> reverse = new Stack<Aresta_Projeto>();
                for (Aresta_Projeto e : G.adj[v]) {
                    reverse.push(e);
                }
                for (Aresta_Projeto e : reverse) {
                    adj[v].add(e);
                }
            }
        }

    public Grafo_Projeto() {

    }

    /**
         * Returns the number of vertices in this edge-weighted digraph.
         *
         * @return the number of vertices in this edge-weighted digraph
         */
        public int V() {
            return V;
        }

        /**
         * Returns the number of edges in this edge-weighted digraph.
         *
         * @return the number of edges in this edge-weighted digraph
         */
        public int E() {
            return E;
        }

        // throw an IllegalArgumentException unless {@code 0 <= v < V}
        private void validateVertex(int v) {
            if (v < 0 || v >= V)
                throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }

        /**
         * Adds the directed edge {@code e} to this edge-weighted digraph.
         *
         * @param  e the edge
         * @throws IllegalArgumentException unless endpoints of edge are between {@code 0}
         *         and {@code V-1}
         */
        public void addEdge(Aresta_Projeto e) {
            int v = e.from();
            int w = e.to();
            validateVertex(v);
            validateVertex(w);
            adj[v].add(e);
            indegree[w]++;
            E++;
        }


        /**
         * Returns the directed edges incident from vertex {@code v}.
         *
         * @param  v the vertex
         * @return the directed edges incident from vertex {@code v} as an Iterable
         * @throws IllegalArgumentException unless {@code 0 <= v < V}
         */
        public Iterable<Aresta_Projeto> adj(int v) {
            validateVertex(v);
            return adj[v];
        }

        /**
         * Returns the number of directed edges incident from vertex {@code v}.
         * This is known as the <em>outdegree</em> of vertex {@code v}.
         *
         * @param  v the vertex
         * @return the outdegree of vertex {@code v}
         * @throws IllegalArgumentException unless {@code 0 <= v < V}
         */
        public int outdegree(int v) {
            validateVertex(v);
            return adj[v].size();
        }

        /**
         * Returns the number of directed edges incident to vertex {@code v}.
         * This is known as the <em>indegree</em> of vertex {@code v}.
         *
         * @param  v the vertex
         * @return the indegree of vertex {@code v}
         * @throws IllegalArgumentException unless {@code 0 <= v < V}
         */
        public int indegree(int v) {
            validateVertex(v);
            return indegree[v];
        }

        /**
         * Returns all directed edges in this edge-weighted digraph.
         * To iterate over the edges in this edge-weighted digraph, use foreach notation:
         * {@code for (DirectedEdge e : G.edges())}.
         *
         * @return all edges in this edge-weighted digraph, as an iterable
         */
        public Iterable<Aresta_Projeto> edges() {
            Bag<Aresta_Projeto> list = new Bag<Aresta_Projeto>();
            for (int v = 0; v < V; v++) {
                for (Aresta_Projeto e : adj(v)) {
                    list.add(e);
                }
            }
            return list;
        }

        /**
         * Returns a string representation of this edge-weighted digraph.
         *
         * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
         *         followed by the <em>V</em> adjacency lists of edges
         */
        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append(V + " " + E + NEWLINE);
            for (int v = 0; v < V; v++) {
                s.append(v + ": ");
                for (Aresta_Projeto e : adj[v]) {
                    s.append(e + "  ");
                }
                s.append(NEWLINE);
            }
            return s.toString();
        }

        /**
         * Unit tests the {@code EdgeWeightedDigraph} data type.
         *
         * @param args the command-line arguments
         */


    }


