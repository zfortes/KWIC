package KWIC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileBasedStorageManager implements DataStorageManager {

    List<String> listString = new LinkedList<>();

    //le os titulos presentes no arquivo e os salva em uma string
    @Override
    public void init(String nArq) {
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
