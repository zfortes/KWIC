package KWIC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class StopWordManager {
    public static List<String> stopWord(String file){
        List<String> lista = new LinkedList<>();
        try
        {
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);





//            lista.forEach((d) -> {
//                ItemGenericoChamador itemGenerico = new ItemGenericoChamador();
//                itemGenerico.setQuantidade(1);
//                itemGenerico.setItemGenerico(d);
//                igChamadores.add(itemGenerico);
//            });

            String n = lerArq.readLine();
            while (n != null) {
                lista.add(n);
                n = lerArq.readLine();
            }




//            lista.forEach((i) -> {
//                System.out.println(i);
//            });



//            while (linha != null)
//            {
//                System.out.printf("%s\n", linha);
//
//                linha = lerArq.readLine();
//            }

            arq.close();
        } catch (IOException e)
        {
            System.err.printf("Erro ao abrir: %s.\n", e.getMessage());
        }
        return lista;

    }

}
