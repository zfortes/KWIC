package test.java;



import KWIC.IndexManager;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndexManagerTest extends IndexManager {
    @org.junit.jupiter.api.Test
    public boolean isEmpty() {
        IndexManager index = new IndexManager();
        index.initMap("Programming", "Programming in Scala", 0);
        index.initMap("Programming", "Object-oriented Programming", 2);

        assertEquals(index.isEmpty(), false);
        return false;
    }

    @org.junit.jupiter.api.Test
    public void initMap() {
        IndexManager manager = new IndexManager();

        manager.initMap("Programming", "Programming in Scala", 0);
        manager.initMap("Programming", "Object-oriented Programming", 2);
        manager.initMap("Scala", "Programming in Scala", 2);
        manager.initMap("Java", "Java is also cool, isn't it?", 0);

        assertEquals(manager.isEmpty(), false);
    }

    @org.junit.jupiter.api.Test
    public void ocurrencesOfWord() {
        IndexManager manager = new IndexManager();

        manager.initMap("Programming", "Programming in Scala", 0);
        manager.initMap("Programming", "Object-oriented Programming", 2);
        manager.initMap("Scala", "Programming in Scala", 2);
        manager.initMap("Java", "Java is also cool, isn't it?", 0);


        List<String> esperado = new LinkedList<>();
        esperado.add("Java");
        esperado.add("Programming");
        esperado.add("Scala");


        assertEquals(manager.sortedWords(), esperado);
    }

    @org.junit.jupiter.api.Test
    public List<String> sortedWords() {
        List<String> list = new LinkedList<>();
        return list;
    }
//

}
