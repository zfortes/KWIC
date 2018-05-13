package KWIC;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class WordShift
{
    static List<String> lista_de_palavras = new ArrayList<String>();

    public static void shift(String frase)
    {
        lista_de_palavras = new ArrayList<String>();//limpamdo frase anterior

        //Transforma frase em lista de palavras:
        String palavra_temp = new String();

        for (int i=0; i<frase.length(); i++)
        {

            char c = frase.charAt(i);
            if (c != ' ')
            {
                palavra_temp += c;
            }
            else
            {
                lista_de_palavras.add(palavra_temp);
                palavra_temp = new String();
            }
        }
        lista_de_palavras.add(palavra_temp);


        int num_palavras = lista_de_palavras.size();

        //faz todos os shifts possíveis para a lista de palavras
        for(int i=0; i<num_palavras; i++)
        {

            Collections.rotate(lista_de_palavras,1); //rotaciona lista

            for(String s: lista_de_palavras)
            {
                System.out.print(s);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
