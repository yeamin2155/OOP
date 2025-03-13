package asg7;

import java.util.ArrayList;

public class XenoLexicon {
    private ArrayList<String> words;

    public XenoLexicon() {
        words = new ArrayList<>();
    }

    public void addWord(String word) {
        words.add(word);
    }

    public boolean isWord(String sequence) {
        return words.contains(sequence);
    }
}
