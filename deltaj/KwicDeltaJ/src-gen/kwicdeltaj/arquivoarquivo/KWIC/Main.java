package kwicdeltaj.arquivoarquivo.KWIC;

import java.util.*;
/*** added by dBase* modified by dFileOut
 */
public class Main {
	public static void main(String [] args) {
		System.out.println("[****************KWIC*********************]");
		System.out.println();
		DataStorageManager dsm = getInput();
		dsm.init();
		IndexManager im = new IndexManager();
		String linha;
		for(int lineNumber = 0;
			lineNumber < dsm.length();
			lineNumber ++) {
			linha = dsm.line(lineNumber);
			String [] words = linha.split(" ");
			for(int pos = 0;
				pos < words.length;
				pos ++) {
				im.initMap(words[pos], linha, pos);
			}
		}
		List<String> list = im.sortedWords();
		WordShift ws = new WordShift();
		StopWordManager stopWordManager = new StopWordManager();
		List<String> stopWord = stopWordManager.stopWord("stop_words.txt");
		List<StringStorage> shifted = new LinkedList();
		for(String n : list) {
			if(! stopWord.contains(n)) {
				List<StringStorage> list1 = ws.shiftBegin(im.ocurrencesOfWord(n), n);
				for(StringStorage j : list1) {
					shifted.add(j);
				}
			}
		}
		Save save = getOutput();
		save.save(shifted);
		System.out.println("[_________________________________________]");
		System.out.println("[****************KWIC*********************]");
	}
	static DataStorageManager getInput() {
		return new FileBasedStorageManager();
	}
	static Save getOutput() {
		return new SaveFile();
	}
}