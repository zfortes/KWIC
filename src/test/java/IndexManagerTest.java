package test.java;



import KWIC.IndexManager;
import KWIC.IndexStorage;
import org.junit.jupiter.api.Test;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndexManagerTest extends IndexManager {
    @Test
    public void isEmptyTest() {
        IndexManager index = new IndexManager();
        index.initMap("Programming", "Programming in Scala", 0);
        index.initMap("Programming", "Object-oriented Programming", 2);

        assertEquals(index.isEmpty(), false);
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


        List<IndexStorage> esperado = new LinkedList<>();

        IndexStorage index = new IndexStorage();
        index.setLine("Programming in Scala");
        index.setPosition(0);
        esperado.add(index);

        List<IndexStorage> retorno = manager.ocurrencesOfWord("Java");
        for (IndexStorage n : retorno) {
            System.out.println(n.getLine());
        }

        assertEquals(retorno.size(), 1);
    }

    @org.junit.jupiter.api.Test
    public void sortedWordsTest() {
        IndexManager manager = new IndexManager();

        manager.initMap("Programming", "Programming in Scala", 0);
        manager.initMap("Programming", "Object-oriented Programming", 2);
        manager.initMap("Scala", "Programming in Scala", 2);
        manager.initMap("Java", "Java is also cool, isn't it?", 0);

        List<String> list = new LinkedList<>();
        list.add("Java");
        list.add("Programming");
        list.add("Scala");
        assertEquals(manager.sortedWords(), list);
    }
//

}
