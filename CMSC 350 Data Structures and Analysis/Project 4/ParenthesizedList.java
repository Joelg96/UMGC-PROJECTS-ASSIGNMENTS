/*Joel Goode CMSC 350 Project4 
 * The fourth programming project involves writing a program that accepts information contained in a file about
the class dependencies in a Java program and creates a directed graph from that information. From the directed
graph, it produces two different kinds of displays of those dependency relationships.
 */

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class ParenthesizedList implements DFSActions<Vertex> {

    Queue<String> res = new LinkedList<>();

    @Override
    public void processVertex(Vertex vertex) {
        res.add(vertex.toString());
    }

    @Override
    public void descendVertex(Vertex vertex) {
        res.add("(");
    }

    @Override
    public void ascendVertex(Vertex vertex) {
        res.add(")");
    }

    @Override
    public void cycleDetected() {
        res.add("*");
    }

    @Override
    public String toString() {

        StringBuilder answer = new StringBuilder();
        answer.append("( ");

        while (!res.isEmpty()) {
            String c = res.peek();
            res.remove();

            if (Objects.equals(c, "(")) {

                if (Objects.equals(res.peek(), ")")) {
                    res.remove();
                    continue;
                    
                } else if (Objects.equals(res.peek(), "*")) {
                    answer.append(res.peek()).append(" ");
                    res.remove();
                    res.remove();
                    continue;
                }
            }
            answer.append(c).append(" ");
        }
        answer.append(")\n");
        return answer.toString();
    }
}