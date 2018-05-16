package KWIC;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SaveFile implements Save{
    public void save(List<String> list){
        try {
            FileWriter arq = new FileWriter("shifts.html");
            PrintWriter gravarArq = new PrintWriter(arq);

            gravarArq.println("<!DOCTYPE html>");
            gravarArq.println("<head>");
            gravarArq.println("<meta charset=\"UTF-8\">");
            gravarArq.println("<title>KEYWORD IN CONTEXT</title>");
            gravarArq.println("</head>");
            gravarArq.println("<body>");
            gravarArq.println("<center><b>KEYWORD IN CONTEXT</b></center>");

            for (String n : list) {
                gravarArq.println(n);
            }

            gravarArq.println("</body>");
            gravarArq.println("</html>");

            arq.close();
        } catch(IOException e) {
            System.err.printf("Erro ao gravar o arquivo: %s.\n", e.getMessage());
        }
    }
}
