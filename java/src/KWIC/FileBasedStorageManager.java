package KWIC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*Pega todos as frases de um arquivo e o salva em uma lita de strings*/
public class FileBasedStorageManager implements DataStorageManager {

    List<String> listString = new LinkedList<>();

    //le os titulos presentes no arquivo e os salva em uma string
    @Override
    public void init() {

        System.out.println("Enter the name of file");
        Scanner ler = new Scanner(System.in);
        String nArq = ler.nextLine();
        System.out.println("[FILE BASED = "+ nArq + "]");
        try {
            FileReader arq = new FileReader(nArq);
            BufferedReader lerArq = new BufferedReader(arq);

            String n = lerArq.readLine();
            while (n != null) {
                listString.add(n);
                n = lerArq.readLine();
            }
        } catch (IOException e) {
            System.err.printf("Erro ao abrir arquivo %s.\n", e.getMessage());
        }
    }

    public List<String> getListString() {
        return listString;
    }

    @Override
    public String line(int index) {
        return listString.get(index);
    }

    @Override
    public int length() {
        return listString.size();
    }
}
