package KWIC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import KWIC.WordShift;

public class Main
{
    public static void main(String[] args)
    {
        DataStorageManager dsm = new FileBasedStorageManager();
        dsm.init("t.txt");

		IndexManager im = new IndexManager();


        String linha;

        for (int lineNumber = 0; lineNumber < dsm.length(); lineNumber++ ){
            linha = dsm.line(lineNumber);
            String[] words = linha.split(" ");

            for (int pos=0; pos < words.length; pos++){
                im.initMap(words[pos], linha, pos);
//                System.out.println(pos);
            }
        }

        List<String> list = im.sortedWords();

        WordShift ws = new WordShift();
        for (String n : list){
            List<IndexStorage> nlist = new LinkedList();
            im.ocurrencesOfWord(n).forEach((d)->{
                nlist.add(d);
//                System.out.println("________________________________");
//                System.out.println("Word : "+ n);
//                System.out.println("Line : " + d.getLine());
//                System.out.println("Posicao : " + d.getPosition());
//                System.out.println("________________________________");

//                Collections.addAll(nlist, d.getLine().split(" "));

//                System.out.println(d.getLine());

//                for (String j : nlist){
//                    System.out.println(j);
//                }


            });

//            for (String j : nlist){
//                    System.out.println(j);
//            }

            List<String> list1 = ws.shiftBegin(nlist, n);
            System.out.println("Word = " + n);
            for (String j : list1){
                System.out.println(j);
            }
        }

    }
}





//        DataStorageManager data = new DBLPStorageManager();
//        data.init("Carro");
//        Scanner ler = new Scanner(System.in);
//
//        System.out.printf("nome de arquivo:\n");
//        String nome = ler.nextLine();
//
//        //System.out.printf("\nConteúdo do texto:\n");
//        try
//        {
//            FileReader arq = new FileReader(nome);
//            BufferedReader lerArq = new BufferedReader(arq);
//
//            String linha = lerArq.readLine();
//
//            while (linha != null)
//            {
//                //Manda linha para gerar shifts:
//                WordShift.shift(linha);
//
//                linha = lerArq.readLine();
//            }
//
//            arq.close();
//        } catch (IOException e)
//        {
//            System.err.printf("Erro ao abrir: %s.\n",
//                    e.getMessage());
//        }
//
//        System.out.println();
//    }
//}
