package KWIC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexManager {

    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public boolean isEmpty(){

        return false;
    }

    public void initMap(String word, String line, int pos){
        if (map.containsValue(word)){
            map.put(word, List.add(pos));
        }else{
            map.put(word, List.add(pos));
        }
    }

    public void ocurrencesOfWord(String word){

    }

    public void sorteWords(){}
}
