package KWIC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import KWIC.WordShift;

public class Main
{
    public static void main(String[] args)
    {
        Scanner ler = new Scanner(System.in);

        System.out.printf("nome de arquivo:\n");
        String nome = ler.nextLine();

        //System.out.printf("\nConteúdo do texto:\n");
        try
        {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();

            while (linha != null)
            {
                //Manda linha para gerar shifts:
                WordShift.shift(linha);

                linha = lerArq.readLine();
            }

            arq.close();
        } catch (IOException e)
        {
            System.err.printf("Erro ao abrir: %s.\n",
                    e.getMessage());
        }

        System.out.println();
    }
}
