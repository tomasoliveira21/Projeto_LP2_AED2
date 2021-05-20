package Graph;

public class Aresta_Projeto {
        private  int v;
        private  int w;
        private  double km;
        private  double time;

        /**
         * Initializes a directed edge from vertex {@code v} to vertex {@code w} with
         * the given {@code weight}.
         * @param v the tail vertex
         * @param w the head vertex
         * @param km the weight of the directed edge
         * @throws IllegalArgumentException if either {@code v} or {@code w}
         *    is a negative integer
         * @throws IllegalArgumentException if {@code weight} is {@code NaN}
         */
        public Aresta_Projeto(int v, int w, double km,double time) {
            if (v < 0) throw new IllegalArgumentException("Vertex names must be non-negative integers");
            if (w < 0) throw new IllegalArgumentException("Vertex names must be non-negative integers");
            if (Double.isNaN(km)) throw new IllegalArgumentException("Weight is NaN");
            this.v = v;
            this.w = w;
            this.km = km;
            this.time = time;
        }

        /**
         * Returns the tail vertex of the directed edge.
         * @return the tail vertex of the directed edge
         */
        public int from() {
            return v;
        }

        /**
         * Returns the head vertex of the directed edge.
         * @return the head vertex of the directed edge
         */
        public int to() {
            return w;
        }

        public double getTime() {
        return time;
        }

    /**
         * Returns the weight of the directed edge.
         * @return the weight of the directed edge
         */
        public double km() {
            return km;
        }

        /**
         * Returns a string representation of the directed edge.
         * @return a string representation of the directed edge
         */
        public String toString() {
            return v + "->" + w + " " + String.format("%5.2f", km);
        }

        /**
         * Unit tests the {@code DirectedEdge} data type.
         *
         * @param args the command-line arguments
         */

    }
