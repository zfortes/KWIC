package KWIC;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/*Quebra a linha e coloca a key em evidencia.
*Coloca tudo em um objeto do tipo StringStorage
 */
public class WordShift {
    //Coloca a keyword no inicio da linha e o contexto a esquerda invertendo ambos
    public List<StringStorage> shiftBegin(List<IndexStorage> list, String word) {
        List<StringStorage > listFinal = new LinkedList();


        for (IndexStorage n : list){
            StringStorage stringStorage = new StringStorage();
            stringStorage.setKeyword(word);
            String[] wordS = wordSep(n);

            String left = "";
            for (int i =0; i < n.getPosition(); i++){
                left = left.concat(wordS[i] + " ");
            }

            String right = "";
            for (int j = n.getPosition()+1; j < wordS.length; j++){
                right = right.concat(" " + wordS[j]);
            }

            stringStorage.setLeft(left);
            stringStorage.setRight(right);
            listFinal.add(stringStorage);

        }

        return listFinal;
    }

    public String[] wordSep(IndexStorage storage){
        String aux = storage.getLine();

        return aux.split(" ");

    }
}
