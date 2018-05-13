package KWIC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;


public class DBLPStorageManager implements DataStorageManager {

    List<String> lines;
    @Override
    public void init(String nArq) {

        List<String> list = new LinkedList<>();
        try {
            URL url = new URL("http://dblp.org/search/publ/api?q="+nArq+"&format=json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;


            while ((line = reader.readLine()) != null) {
               list.add(line);
            }
            reader.close();

            lines = jsonParse(list);
        } catch (MalformedURLException e) {
            System.out.println("An error occurred. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error has occurred, check the connection. " + e.getMessage());
        }

    }

    public List<String> jsonParse(List<String> list){
        List<String> titles = new LinkedList<>();

        for (String i : list){
            if(i.contains("title")){
                int index1 = i.indexOf("title") + 8;
                int index2 = 0;
                for (index2 = index1; i.charAt(index2)  != '"'; index2++){}
                titles.add(i.substring(index1,  index2));
            }
        }

        return titles;
    }

    @Override
    public String line(int index){
        return lines.get(index);
    }

    @Override
    public int length() {
        return lines.size();
    }
}
