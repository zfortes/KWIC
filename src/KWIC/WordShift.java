package KWIC;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/*Quebra a linha e coloca a key em evidencia.
*Pode por a key no meio e invertendo o contexto
* Pode por a key no inicio e inverter o contexto na frente
 */
public class WordShift {
    //Coloca a keyword no inicio da linha e o contexto a esquerda invertendo ambos
    public List<StringStorage> shiftBegin(List<IndexStorage> list, String word) {
        List<StringStorage > listFinal = new LinkedList();
        StringStorage stringStorage = new StringStorage();
        stringStorage.setKeyword(word);

        for (IndexStorage n : list){
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
