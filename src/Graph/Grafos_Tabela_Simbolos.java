package Graph;

import edu.princeton.cs.algs4.*;

public class Grafos_Tabela_Simbolos {
  
        public ST<String, Integer> st=new ST<>(); //  ID -> Index no Grafo
        public Grafo_Projeto graph=new Grafo_Projeto();

        
        public Grafos_Tabela_Simbolos(String filename, String delimiter) {
            st = new ST<String, Integer>();

            // First pass builds the index by reading strings to associate
            // distinct strings with an index
            In in = new In(filename);
            // while (in.hasNextLine()) {
            while (!in.isEmpty()) {
                String[] a = in.readLine().split(delimiter);
                for (int i = 0; i < a.length; i++) {
                    if (!st.contains(a[i]))
                        st.put(a[i], st.size());
                }
            }

            
           

            // second pass builds the graph by connecting first vertex on each
            // line to all others
            graph = new Grafo_Projeto(st.size());
            in = new In(filename);
            while (in.hasNextLine()) {
                String[] a = in.readLine().split(delimiter);
                int v = st.get(a[0]);
                double km =st.get(a[1]);
                double time =st.get(a[2]);
                for (int i = 3; i < a.length; i++) {
                    int w = st.get(a[i]);
                    Aresta_Projeto e =new Aresta_Projeto(v,w,km,time);
                    graph.addEdge(e);
                }
            }
        }

    public Grafos_Tabela_Simbolos() {
        
    }



    /**
         * Does the graph contain the vertex named {@code s}?
         * @param s the name of a vertex
         * @return {@code true} if {@code s} is the name of a vertex, and {@code false} otherwise
         */
        public boolean contains(String s) {
            return st.contains(s);
        }

        /**
         * Returns the integer associated with the vertex named {@code s}.
         * @param s the name of a vertex
         * @return the integer (between 0 and <em>V</em> - 1) associated with the vertex named {@code s}
         * @deprecated Replaced by {@link #indexOf(String)}.
         */
        @Deprecated
        public int index(String s) {
            return st.get(s);
        }


        /**
         * Returns the integer associated with the vertex named {@code s}.
         * @param s the name of a vertex
         * @return the integer (between 0 and <em>V</em> - 1) associated with the vertex named {@code s}
         */
        public int indexOf(String s) {
            return st.get(s);
        }
        
        /**
         * Returns the graph assoicated with the symbol graph. It is the client's responsibility
         * not to mutate the graph.
         * @return the graph associated with the symbol graph
         * @deprecated Replaced by {@link #graph()}.
         */
        @Deprecated
        public Grafo_Projeto G() {
            return graph;
        }

        /**
         * Returns the graph assoicated with the symbol graph. It is the client's responsibility
         * not to mutate the graph.
         * @return the graph associated with the symbol graph
         */
        public Grafo_Projeto graph() {
            return graph;
        }

        // throw an IllegalArgumentException unless {@code 0 <= v < V}
        private void validateVertex(int v) {
            int V = graph.V();
            if (v < 0 || v >= V)
                throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }


        /**
         * Unit tests the {@code SymbolGraph} data type.
         *
         * @param args the command-line arguments
         */
    
    }

