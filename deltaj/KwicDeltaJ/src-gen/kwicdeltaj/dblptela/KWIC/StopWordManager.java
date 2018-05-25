package kwicdeltaj.dblptela.KWIC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
/*** added by dBase
 */
public class StopWordManager {
	public List<String> stopWord(String file) {
		List<String> lista = new LinkedList();
		try {
			FileReader arq = new FileReader(file);
			BufferedReader lerArq = new BufferedReader(arq);
			String n = lerArq.readLine();
			while(n != null) {
				lista.add(n);
				n = lerArq.readLine();
			}
			arq.close();
		}
		catch(IOException e) {
			System.err.printf("Erro ao abrir: %s.\n", e.getMessage());
		}
		return lista;
	}
}