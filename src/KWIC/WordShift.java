package KWIC;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class WordShift
{
    //Implemnetação antiga:

    /*static List<String> lista_de_palavras = new ArrayList<String>();

    *//*public static void sort_shifts()
    {
        Collections.sort(lista_de_palavras);
        System.out.print(lista_de_palavras.toString());

    }*//*

    public static void shift(String frase)
    {
        lista_de_palavras = new ArrayList<String>();//limpando frase anterior

        //Transforma frase em lista de palavras:
        String palavra_temp = new String();

        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (c != ' ') {
                palavra_temp += c;
            } else {
                lista_de_palavras.add(palavra_temp);
                palavra_temp = new String();
            }
        }
        lista_de_palavras.add(palavra_temp);

        try
        {
            FileWriter arq = new FileWriter("shifts.txt");
            PrintWriter gravarArq = new PrintWriter(arq);

            int num_palavras = lista_de_palavras.size();
            //faz todos os shifts possíveis para a lista de palavras
            for (int i = 0; i < num_palavras; i++) {
                Collections.rotate(lista_de_palavras, 1); //rotaciona lista
                for (String s : lista_de_palavras)
                {
                    System.out.print(s);
                    System.out.print(" ");

                    //Colocando no arquivo
                    gravarArq.printf(s);
                    gravarArq.printf(" ");
                }
                System.out.println();
                gravarArq.println();
            }
            arq.close();
        }
        catch (IOException e)
        {
            System.err.printf("Erro ao abrir: %s.\n",
                    e.getMessage());
        }
    }*/

   public static List<String> shift(List<String> words, int pos, int target)
   {
    List<String> l,r = new ArrayList<String>();
    l = words.subList(0,pos);
    r = words.subList(0,pos);

    if (l.toString().replaceAll("[\\[\\]]", "").length() < (target -5))
    {
        return shiftRight(l,r,target);
    }
    return shiftLeft(l,r,target);
   }

   public static List<String> shiftRight(List<String> l,List<String> r,int target)
   {
       if(r.toString().replaceAll("[\\[\\]]", "").length() == 0)
       {
            return l;
       }

       List<String> r1 = new ArrayList<String>();
       List<String> r2 = new ArrayList<String>();
       r2 = r.subList(0,r.toString().replaceAll("[\\[\\]]", "").length()-1);
       r1 = r.subList(0,r.toString().replaceAll("[\\[\\]]", "").length()-1);
       List<String> l1 = new ArrayList<String>();
       l1.addAll(r2);
       l1.addAll(l);

       return shiftRight(l1,r1,target);
   }

    public static List<String> shiftLeft(List<String> l,List<String> r,int target)
    {
        if(l.toString().replaceAll("[\\[\\]]", "").length() == 0)
        {
            return r;
        }

        List<String> l1 = new ArrayList<String>();
        List<String> l2 = new ArrayList<String>();
        l1 = l.subList(0,r.toString().replaceAll("[\\[\\]]", "").length()-1);
        l2 = l.subList(0,r.toString().replaceAll("[\\[\\]]", "").length()-1);
        List<String> r1 = new ArrayList<String>();
        r1.addAll(r);
        r1.addAll(l1);

        if(l2.toString().replaceAll("[\\[\\]]", "").length() < (target - 5))
        {
            List<String> temp = new ArrayList<String>();
            temp.addAll(l2);
            temp.addAll(r1);
            return temp;
        }
        return shiftLeft(l2,r1,target);
    }
}
