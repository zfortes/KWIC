package KWIC;

import java.util.*;

/*Pega todas as keywords e as insere em um map q contem a keyword de um lado e uma lista do tipo indexstorage onde
todos as frases com essa keyword estao salvasa e inclue a possicao da palavra na frase*/
public class IndexManager {

    Map<String, List<IndexStorage>> map = new HashMap();

    public boolean isEmpty(){
        return map.isEmpty();
    }

    public void initMap(String word, String line, int pos){

        IndexStorage index = new IndexStorage();
        index.setLine(line);
        index.setPosition(pos);


        if (map.containsKey(word)) {
            map.get(word).add(index);
        }else{
            List<IndexStorage> list = new LinkedList<>();
            list.add(index);
            map.put(word, list);
        }
    }

    public List<IndexStorage> ocurrencesOfWord(String word){
        return map.get(word);
    }

    public List<String> sortedWords(){
        SortedSet<String> keys = new TreeSet<String>(map.keySet());
        List<String> lista = new ArrayList<>(keys);
        return lista;
    }

}
