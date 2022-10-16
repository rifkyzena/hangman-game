# hangman-game
A simple hangman game programmed in Java. 

## The game consists of 4 menus, namely:
1. Add data
2. Look up data
3. Play Game
4. Exit

## 1. Add data
If the user selects the "**add data**" menu, the user will be asked to enter a word, validate said word for a **minimum of 5 characters** and a **maximum of 50 characters** (including spaces). The number of data is infinite (use ArrayList), and validate that there cannot be the same data (case sensitive).

## 2. Look data
If the user selects the "Look data" menu, then validate:
- If the data does not exist then display "There is no data" and ask to do the add data menu.
- If the data already exists, display the data that has been entered and sorted in ascending order (from small to large).

## 3. Play Game
If the user selects the “Game” menu, then validate:
- If the data does not exist then display "There is no data" and ask to do the add data menu
- If the data already exists then:
   - i. Run random from the list of words that have been inputted
   - ii. Then display '-' the number of letters in the word that has been randomized
   - iii. Asks the user to enter a letter and checks if the letter is in the word, if there is a letter it will be displayed.
   
   
![image](https://user-images.githubusercontent.com/55536824/196027148-f78d5cb9-83cd-42ea-ae6f-6a0636bcb6ba.png)

   
## 4. Exit
If the user selects the “exit” menu, the program will be finished.
