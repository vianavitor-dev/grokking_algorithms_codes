import com.vianavitor.algorithms.dataStructure.DiGraph;
import com.vianavitor.algorithms.dataStructure.VertexExample;
import com.vianavitor.algorithms.search.BinarySearch;
import com.vianavitor.algorithms.search.BreadthFirstSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchTest {

    @Test
    @Tag("Search")
    @DisplayName("Binary Search - ArrayList ")
    public void testBinarySearch() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 5, 8, 12, 20, 26, 70));

        int index = BinarySearch.search(list, 26);

        if (index == -1) {
            System.out.println("Not found number");
        }

        assert(index == 6);
    }

    @Test
    @Tag("Search")
    @DisplayName("Dummy Search - ArrayList ")
    public void testDummySearch() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 5, 8, 12, 20, 26, 70));
        int index = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 26) {
                index = i;
            }
        }

        if (index == -1) {
            System.err.println("Not found number");
        }

        assert(index == 6);
    }

    @Test
    @Tag("Search")
    @DisplayName("Breadth-First Search")
    public void BreadthFirstSearchTest() {
        DiGraph<String, Boolean> graph = new DiGraph<>();
        
        // This test aim is search for the programmer among the following people 
        VertexExample<String, Boolean> x = new VertexExample<>("X", false);
        VertexExample<String, Boolean> jorge = new VertexExample<>("Jorge", false);
        VertexExample<String, Boolean> marco = new VertexExample<>("Marco", false);
        VertexExample<String, Boolean> pedro = new VertexExample<>("Pedro", false);
        VertexExample<String, Boolean> maria = new VertexExample<>("Maria", false);
        VertexExample<String, Boolean> jhonny = new VertexExample<>("Jhonny", false);
        VertexExample<String, Boolean> bob = new VertexExample<>("Bob", true);

        graph.addVertex(x);
        graph.addVertex(jorge);
        graph.addVertex(marco);
        graph.addVertex(pedro);
        graph.addVertex(maria);
        graph.addVertex(jhonny);
        graph.addVertex(bob);

        graph.addEdge(x,  List.of(jorge, marco));

        graph.addEdge(jorge, List.of(jhonny));
        graph.addEdge(marco, List.of(pedro));
        graph.addEdge(pedro, List.of(maria));
        graph.addEdge(jhonny, List.of(maria, bob));

        graph.display();
        System.out.println();

        BreadthFirstSearch<String, Boolean> algorithm = new BreadthFirstSearch<>(graph.getNeighborns(x));
        boolean result = algorithm.search(graph, true);

        Assertions.assertEquals(true, result, "there is no programmer");
    }
}
