package Graph;

import edu.princeton.cs.algs4.*;
public class Prim_AED2 {
        private static final double FLOATING_POINT_EPSILON = 1E-12;

        private Aresta_Projeto[] edgeTo;        // edgeTo[v] = shortest edge from tree vertex to non-tree vertex
        private double[] distTo;      // distTo[v] = weight of shortest such edge
        private boolean[] marked;     // marked[v] = true if v on tree, false otherwise
        private IndexMinPQ<Double> pq;

        /**
         * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
         * @param G the edge-weighted graph
         */
        public Prim_AED2(Grafo_Projeto G,int s,double totalDistance) {
            edgeTo = new Aresta_Projeto[G.V()];
            distTo = new double[G.V()];
            marked = new boolean[G.V()];
            pq = new IndexMinPQ<Double>(G.V());
            for (int v = 0; v < G.V(); v++)
                distTo[v] = Double.POSITIVE_INFINITY;

            //for (int v = 0; v < G.V(); v++)      // run from each vertex to find
                if (!marked[s]) prim(G, s,totalDistance);      // minimum spanning forest

            // check optimality conditions
            assert check(G);
        }

        // run Prim's algorithm in graph G, starting from vertex s
        private void prim(Grafo_Projeto G, int s,double totalDistance) {
            distTo[s] = 0.0;
            pq.insert(s, distTo[s]);
            while (!pq.isEmpty()) {
                int v = pq.delMin();
                scan(G, v,totalDistance);
            }
        }

        // scan vertex v
        private void scan(Grafo_Projeto G, int v,double totalDistance) {
            marked[v] = true;
            for (Aresta_Projeto e : G.adj(v)) {
                int w = e.to();
                double km = weight() + e.km();
                if(km>=totalDistance)return;
                if (marked[w]) continue;         // v-w is obsolete edge
                if (e.km() < distTo[w]) {
                    distTo[w] = e.km();
                    edgeTo[w] = e;
                    if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                    else                pq.insert(w, distTo[w]);
                }
            }
        }

        /**
         * Returns the edges in a minimum spanning tree (or forest).
         * @return the edges in a minimum spanning tree (or forest) as
         *    an iterable of edges
         */
        public Iterable<Aresta_Projeto> edges() {
            Queue<Aresta_Projeto> mst = new Queue<Aresta_Projeto>();
            for (int v = 0; v < edgeTo.length; v++) {
                Aresta_Projeto e = edgeTo[v];
                if (e != null) {
                    mst.enqueue(e);
                }
            }
            return mst;
        }

        /**
         * Returns the sum of the edge weights in a minimum spanning tree (or forest).
         * @return the sum of the edge weights in a minimum spanning tree (or forest)
         */
        public double weight() {
            double weight = 0.0;
            for (Aresta_Projeto e : edges())
                weight += e.km();
            return weight;
        }


        // check optimality conditions (takes time proportional to E V lg* V)
        private boolean check(Grafo_Projeto G) {

            // check weight
            double totalWeight = 0.0;
            for (Aresta_Projeto e : edges()) {
                totalWeight += e.km();
            }
            if (Math.abs(totalWeight - weight()) > FLOATING_POINT_EPSILON) {
                System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", totalWeight, weight());
                return false;
            }

            // check that it is acyclic
            UF uf = new UF(G.V());
            for (Aresta_Projeto e : edges()) {
                int v = e.from(), w = e.to();
                if (uf.find(v) == uf.find(w)) {
                    System.err.println("Not a forest");
                    return false;
                }
                uf.union(v, w);
            }

            // check that it is a spanning forest
            for (Aresta_Projeto e : G.edges()) {
                int v = e.from(), w = e.to();
                if (uf.find(v) != uf.find(w)) {
                    System.err.println("Not a spanning forest");
                    return false;
                }
            }

            // check that it is a minimal spanning forest (cut optimality conditions)
            for (Aresta_Projeto e : edges()) {

                // all edges in MST except e
                uf = new UF(G.V());
                for (Aresta_Projeto f : edges()) {
                    int x = f.from(), y = f.to();
                    if (f != e) uf.union(x, y);
                }

                // check that e is min weight edge in crossing cut
                for (Aresta_Projeto f : G.edges()) {
                    int x = f.from(), y = f.to();
                    if (uf.find(x) != uf.find(y)) {
                        if (f.km() < e.km()) {
                            System.err.println("Edge " + f + " violates cut optimality conditions");
                            return false;
                        }
                    }
                }

            }

            return true;
        }

        /**
         * Unit tests the {@code PrimMST} data type.
         *
         * @param args the command-line arguments
         */
        public static void main(String[] args) {
            In in = new In(args[0]);
            EdgeWeightedGraph G = new EdgeWeightedGraph(in);
            edu.princeton.cs.algs4.PrimMST mst = new edu.princeton.cs.algs4.PrimMST(G);
            for (Edge e : mst.edges()) {
                StdOut.println(e);
            }
            StdOut.printf("%.5f\n", mst.weight());
        }


    }
