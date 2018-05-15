package KWIC;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class WordShift {
    public List<String> shiftNormal(List<IndexStorage> list, String word) {
        List<String > listFinal = new LinkedList();
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

            String shifted= "";

            if (!right.isEmpty()){
                shifted = right + " ";
            }
            shifted = shifted + word;
            if (!left.isEmpty()){
                shifted = shifted + " " + left;
            }

            listFinal.add(shifted);

//            System.out.println("**********************");
////            System.out.println("left = " +  left);
//            System.out.println("Frase = " + n.getLine());
//            System.out.println("Shifted = " + shifted);
//
//            System.out.println("word = "+word);
//            System.out.println("**********************");
        }

        return listFinal;
    }

    public List<String> shiftBegin(List<IndexStorage> list, String word) {
        List<String > listFinal = new LinkedList();
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

            String shifted= word + " ";

            if (!right.isEmpty()){
                shifted = shifted + right + "/";
            }
            if (!left.isEmpty()){
                shifted = shifted + left;
            }

            listFinal.add(shifted);

//            System.out.println("**********************");
////            System.out.println("left = " +  left);
//            System.out.println("Frase = " + n.getLine());
//            System.out.println("Shifted = " + shifted);
//
//            System.out.println("word = "+word);
//            System.out.println("**********************");
        }

        return listFinal;
    }

    public String[] wordSep(IndexStorage storage){
        String aux = storage.getLine();

        return aux.split(" ");

    }
}
