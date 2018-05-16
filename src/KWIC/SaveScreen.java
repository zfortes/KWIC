package KWIC;

import java.util.List;

public class SaveScreen implements Save{
    public void save(List<String> list) {
        for (String j : list) {
            System.out.println("    " + j);
        }
    }
}
