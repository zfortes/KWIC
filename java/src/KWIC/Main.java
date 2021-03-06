package KWIC;

import java.util.*;


public class Main {

    /*Main pegando de arquivo e printando na tela
     *
     * */
    public static void main(String[] args){


        System.out.println("[****************KWIC*********************]");
        System.out.println();

        //Recebe o tipo de input
        DataStorageManager dsm = getInput();

        //Inicializa o input
        dsm.init();

        IndexManager im = new IndexManager();

        String linha;

        //Quebra todas as linhas em palavras e as insere no hashmap
        for (int lineNumber = 0; lineNumber < dsm.length(); lineNumber++ ){
            linha = dsm.line(lineNumber);
            String[] words = linha.split(" ");
            for (int pos=0; pos < words.length; pos++){
                im.initMap(words[pos], linha, pos);
            }
        }

        //retorna uma lista com as palavras ordenadas
        List<String> list = im.sortedWords();

        WordShift ws = new WordShift();

        //Le as stopwords
        StopWordManager stopWordManager = new StopWordManager();
        List<String> stopWord = stopWordManager.stopWord("stop_words.txt");

        List<StringStorage> shifted = new LinkedList();

        /*Se a palavra atual nao e uma stop word entao ele retorna uma lista de incidencias dessa palavra
        *Em seguida adiciona a linha dessa palavra em uma lista
         */
        for (String n : list){
            if (!stopWord.contains(n)) {
                List<StringStorage> list1 = ws.shiftBegin(im.ocurrencesOfWord(n), n);
                for (StringStorage j : list1) {
                    shifted.add(j);
                }
            }
        }


        Save save = getOutput();

        save.save(shifted);

        System.out.println("[_________________________________________]");
        System.out.println("[****************KWIC*********************]");


    }

    static DataStorageManager getInput(){
        return new FileBasedStorageManager();
    }

    static Save getOutput(){
        return new SaveScreen();
    }
}



























//    /*Main pegando de arquivo e printando na tela
//     *
//     * */
//    public static void main(String[] args){
//        DataStorageManager dsm = new FileBasedStorageManager();
//        dsm.init("t.txt");
//
//        IndexManager im = new IndexManager();
//
//
//        String linha;
//
//        for (int lineNumber = 0; lineNumber < dsm.length(); lineNumber++ ){
//            linha = dsm.line(lineNumber);
//            String[] words = linha.split(" ");
//
//            for (int pos=0; pos < words.length; pos++){
//                im.initMap(words[pos], linha, pos);
////                System.out.println(pos);
//            }
//        }
//
//        List<String> list = im.sortedWords();
//
//
//        System.out.println("[****************KWIC*********************]");
//        System.out.println("[FILE BASED = words.txt]");
//        System.out.println("    [WORD]-----------[CONTEXT]");
//        System.out.println();
//        WordShift ws = new WordShift();
//        StopWordManager stopWordManager = new StopWordManager();
//        List<String> stopWord = stopWordManager.stopWord("stop_words.txt");
//        List<IndexStorage> nlist = new LinkedList();
//        for (String n : list){
//            if (!stopWord.contains(n)) {
//                im.ocurrencesOfWord(n).forEach((d) -> {
//                    nlist.add(d);
////                System.out.println("________________________________");
////                System.out.println("Word : "+ n);
////                System.out.println("Line : " + d.getLine());
////                System.out.println("Posicao : " + d.getPosition());
////                System.out.println("________________________________");
//
////                Collections.addAll(nlist, d.getLine().split(" "));
//
////                System.out.println(d.getLine());
//
////                for (String j : nlist){
////                    System.out.println(j);
////                }
//
//
//                });
//
////            for (String j : nlist){
////                    System.out.println(j);
////            }
//
//                List<String> list1 = ws.shiftBegin(nlist, n);
//                for (String j : list1) {
//                    System.out.println("    " + j);
//                }
//            }
//        }
//        System.out.println("[_________________________________________]");
//        System.out.println("[****************KWIC*********************]");
//
//
////    }






    //Main pegando do DBLP e printando na tela
//    public static void main(String[] args) {
//        DataStorageManager dsm = new DBLPStorageManager();
//
//        System.out.println("[****************KWIC*********************]");
//
//        //Bloco que le e faz a busca no site DBLP
//        System.out.println("Enter the key");
//        Scanner ler = new Scanner(System.in);
//        String key = ler.nextLine();
//        dsm.init(key);
//        System.out.println("[DBLP SEARCHE KEY = " + key);
//
//        IndexManager im = new IndexManager();
//
//
//        String linha;
//
//        for (int lineNumber = 0; lineNumber < dsm.length(); lineNumber++) {
//            linha = dsm.line(lineNumber);
//            String[] words = linha.split(" ");
//
//            for (int pos = 0; pos < words.length; pos++) {
//                im.initMap(words[pos], linha, pos);
//            }
//        }
//
//        List<String> list = im.sortedWords();
//
//
//        System.out.println("    [WORD]-----------[CONTEXT]");
//        System.out.println();
//        WordShift ws = new WordShift();
//        StopWordManager stopWordManager = new StopWordManager();
//        List<String> stopWord = stopWordManager.stopWord("stop_words.txt");
//        for (String n : list) {
//            if (!stopWord.contains(n)) {
//                List<IndexStorage> nlist = new LinkedList();
//                for(IndexStorage e : im.ocurrencesOfWord(n)) {
//                    nlist.add(e);
//                }
//                List<String> list1 = ws.shiftBegin(nlist, n);
//                for (String j : list1) {
//                    System.out.println("    " + j);
//                }
//            }
//        }
//        System.out.println("[_________________________________________]");
//        System.out.println("[****************KWIC*********************]");
//    }




//    //Main pegando do DBLP e printando na tela
//    public static void main(String[] args) {
//        DataStorageManager dsm = new DBLPStorageManager();
//
//        System.out.println("[****************KWIC*********************]");
//
//        //Bloco que le e faz a busca no site DBLP
//        System.out.println("Enter the key");
//        Scanner ler = new Scanner(System.in);
//        String key = ler.nextLine();
//        dsm.init(key);
//        System.out.println("[DBLP SEARCHE KEY = " + key);
//
//        IndexManager im = new IndexManager();
//
//
//        String linha;
//
//        for (int lineNumber = 0; lineNumber < dsm.length(); lineNumber++) {
//            linha = dsm.line(lineNumber);
//            String[] words = linha.split(" ");
//
//            for (int pos = 0; pos < words.length; pos++) {
//                im.initMap(words[pos], linha, pos);
//            }
//        }
//
//        List<String> list = im.sortedWords();
//
//
//        System.out.println("    [WORD]-----------[CONTEXT]");
//        System.out.println();
//        WordShift ws = new WordShift();
//        StopWordManager stopWordManager = new StopWordManager();
//        List<String> stopWord = stopWordManager.stopWord("stop_words.txt");
//        for (String n : list) {
//            if (!stopWord.contains(n)) {
//                List<IndexStorage> nlist = new LinkedList();
//                im.ocurrencesOfWord(n).forEach((d) -> {
//                    nlist.add(d);
//                });
//                List<String> list1 = ws.shiftBegin(nlist, n);
//                for (String j : list1) {
//                    System.out.println("    " + j);
//                }
//            }
//        }
//        System.out.println("[_________________________________________]");
//        System.out.println("[****************KWIC*********************]");
//    }






//}
