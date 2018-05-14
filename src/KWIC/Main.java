package KWIC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import KWIC.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {



        DataStorageManager data = new DBLPStorageManager();
        data.init("Carro");
		
		IndexManager im = new IndexManager();
		
		try
        {
            FileReader arq = new FileReader(nArq);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
			
			//lê aquivo e constroi index
			int num_linha =0;
            while (linha != null)
            {
				
                linha = lerArq.readLine();
				String words = linha.split(' ');
				num_linha++;
				
				for(int pos=0;pos <= words.length();pos++) //achar função q de tamanho da palavra
				{
					im.map(words(pos),linha,pos); //aqui o primeiro argumento deve passar o caractere atual da palavra
				}	
            }	
			
			//Exporta o resultado como KWIC:
			List<String> w = new ArrayList<String>();
            w = im.sortedWords;
            int i=0;
			for(String s: w)  //deve percorer a lista de palavras mapeadas no indexmanager
			{
				if(im.ocurrencesOfWord(s) == s)
				{
					List<String> t = new ArrayList<String>();
					t = WordShift.shift(w,i,0);
					System.out.print("%s\n",t.toString());
				}
				i++;

						//foreach( { case (linha,pos) => println(WordShift.shift(line.split(' ').toList, pos, 0).mkString(" ")) })
				//Ainda falta portar isso.
			}

            arq.close();
        } catch (IOException e)
		{
			System.err.printf("Erro ao abrir arquivo: %s.\n",e.getMessage());
		}
		
		 // Factory Method for storages (until we do not explor DI) 
		 //def createStorage(): DataStorageManager = new FileBasedStorageManager()
		
		
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

        System.out.println();
    }
}
