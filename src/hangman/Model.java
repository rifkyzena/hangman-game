package hangman;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    private ArrayList<String> words;
    private Random random;
    
    public Model() {
        words = new ArrayList<>();
        random = new Random();
    }
    
    public int size() {
        return words.size();
    }
    
    public String get(int idx) {
        return words.get(idx);
    }
    
    public String getRandomString() {
        int idx = random.nextInt(size());
        
        return get(idx);
    }
    
    public void print() {
        sort();
        for(String word : words) {
            System.out.println(word);
        }
        System.out.println("\n");
    }
    
    public void sort() {
        int size = size();
        String word;
        
        for(int j = 0; j < size - 1; j++) {
            for(int i = 0; i < size-1-j; i++) {
                if(get(i).compareTo(get(i+1)) > 0) {
                    word = get(i);
                    words.set(i, get(i+1));
                    words.set(i+1, word);
                }
            }
        }
        
//        print();
    }
    
    public void add(String word) {
        words.add(word);
    }
    
    public boolean isInList(String word) {
        int size = size();
        for(int i = 0; i < size; i++) {
            if(get(i).equals(word)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isEmpty() {
        return words.isEmpty();
    }
}
