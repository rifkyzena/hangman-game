package hangman;

import java.util.Scanner;

public class Hangman {
    
    private Model words = new Model();
    private final Scanner sc = new Scanner(System.in);
    
    private void mainFunction() {
        int pilihan;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Data");
            System.out.println("2. Look Data");
            System.out.println("3. Play Game");
            System.out.println("4. Exit");
            System.out.print("Pilih Menu : ");
            pilihan = sc.nextInt();
            
            sc.nextLine();
            
            if (pilihan == 1) {
                addData();
            } else if (pilihan == 2) {
                lookData();
            } else if (pilihan == 3) {
                game();
            } else if (pilihan == 4) {
                // exit
            } else {
                // wrong input
            }
            
            System.out.println("\n\n");
        } while (pilihan != 4);
    }
    
    public static void main(String[] args) {
        new Hangman().mainFunction();
    }
    
    private void addData() {
        
        String word;
        int len;
        boolean isInList;
        do {
            System.out.print("Input word [5 - 50]: ");
            word = sc.nextLine();
            
            len = word.length();
            isInList = words.isInList(word);
            
            if(isInList) {
                System.out.println("\nChoose another word!\n");
            }
            
        } while ((len < 5 || len > 50) || isInList);
        
        words.add(word);
    }
    
    private void lookData() {
        System.out.println("Print List");
        
        if(words.isEmpty()) {
            System.out.println("There is no data\n\n");
            addData();
            return;
        }
        
        words.print();
    }
    
    private String createHiddenString(int len) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < len; i++) {
            result.append("-");
        }
        
        return String.valueOf(result);
    }
    
    /**
     * 
     * @param strip
     * @param len
     * @return true jika masih ada huruf yang belum ditebak<br>
     * false jika sudah tidak ada huruf yang bisa ditebak
     */
    public boolean isContinue(boolean [] strip, int len) {
        for(int i = 0; i < len; i++) {
            if(!strip[i]) {
                return true;
            }
        }
        
        return false;
    }
    
    private void game() {
        System.out.println("Playing Game");
        
        if(words.isEmpty()) {
            System.out.println("There is no data\n\n");
            addData();
            return;
        }
        
        String originalString = words.getRandomString();
        int len = originalString.length();
        boolean [] strip = new boolean[len];
        boolean isAvail;
        char character;
        
        do {
            isAvail = false;
            System.out.print("Input char : ");
            character = sc.nextLine().charAt(0);
            
            for(int i = 0; i < len; i++) {
                if(originalString.charAt(i) == character) {
                    strip[i] = true;
                    isAvail = true;
                }
            }
            
            if(!isAvail) {
                System.out.println("");
                System.out.println("The character of '"+ character +"' doesn't exist in the sentence!");
                System.out.println("");
            }
            
            for(int i = 0; i < len; i++) {
                if(strip[i]) {
                    System.out.print(originalString.charAt(i));
                } else {
                    System.out.print("-");
                }
            }
            System.out.println("\n");
        } while(isContinue(strip, len));
        
        System.out.println("Congratulations!");
    }
    
}
