//200518088
package com.example.assignment2;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.HashMap;
import java.util.Map;
public class ScrabblePointsGeneratorController {
    private Map<Character, Integer> letterPoints;
    private Map<Character, Integer> letterCount;
    @FXML
    private TextField userWord;
    @FXML
    private Label points;
    @FXML
    private ListView<String> previousWordsListView;
    @FXML
    private GridPane letterCountGrid1;
    public ScrabblePointsGeneratorController() {
        initializeLetterPoints();
        initializeLetterCount();
    }
    private void initializeLetterPoints() {
        letterPoints = new HashMap<>();
        letterPoints.put('A', 1);
        letterPoints.put('B', 3);
        letterPoints.put('C', 3);
        letterPoints.put('D', 2);
        letterPoints.put('E', 1);
        letterPoints.put('F', 4);
        letterPoints.put('G', 2);
        letterPoints.put('H', 4);
        letterPoints.put('I', 1);
        letterPoints.put('J', 8);
        letterPoints.put('K', 5);
        letterPoints.put('L', 1);
        letterPoints.put('M', 3);
        letterPoints.put('N', 1);
        letterPoints.put('O', 1);
        letterPoints.put('P', 3);
        letterPoints.put('Q', 10);
        letterPoints.put('R', 1);
        letterPoints.put('S', 1);
        letterPoints.put('T', 1);
        letterPoints.put('U', 1);
        letterPoints.put('V', 4);
        letterPoints.put('W', 4);
        letterPoints.put('X', 8);
        letterPoints.put('Y', 4);
        letterPoints.put('Z', 10);
    }
    private void initializeLetterCount() {
        letterCount = new HashMap<>();
        letterCount.put('A', 9);
        letterCount.put('B', 2);
        letterCount.put('C', 2);
        letterCount.put('D', 4);
        letterCount.put('E', 12);
        letterCount.put('F', 2);
        letterCount.put('G', 3);
        letterCount.put('H', 2);
        letterCount.put('I', 9);
        letterCount.put('J', 1);
        letterCount.put('K', 1);
        letterCount.put('L', 4);
        letterCount.put('M', 2);
        letterCount.put('N', 6);
        letterCount.put('O', 8);
        letterCount.put('P', 2);
   letterCount.put('Q', 1);
    letterCount.put('R', 6);
  letterCount.put('S', 4);
  letterCount.put('T', 6);
    letterCount.put('U', 4);
    letterCount.put('V', 2);
   letterCount.put('W', 2);
   letterCount.put('X', 1);
 letterCount.put('Y', 2);
   letterCount.put('Z', 1);
  }
  @FXML
    private void calculatePoints() {
 String word = userWord.getText().toUpperCase();
   int points = 0;
 for (char letter : word.toCharArray()) {
   if (letterPoints.containsKey(letter)) {
   points += letterPoints.get(letter);
    updateLetterCount(letter);
    }
  }
  points.setText(String.valueOf(points));
  previousWordsListView.getItems().add(word);
 }
 private void updateLetterCount(char letter) {
 if (letterCount.containsKey(letter)) {
 int count = letterCount.get(letter);
 if (count > 0) {
 count--;
 letterCount.put(letter, count);
 }
 }
 letterCountGrid1.getChildren().clear();
 int row = 0;
 for (char c = 'A'; c <= 'Z'; c++) {
Label letterLabel = new Label(String.valueOf(c));
GridPane.setConstraints(letterLabel, 0, row);
letterCountGrid1.getChildren().add(letterLabel);
Label countLabel = new Label(String.valueOf(letterCount.getOrDefault(c, 0)));
GridPane.setConstraints(countLabel, 1, row);
letterCountGrid1.getChildren().add(countLabel);
row++;
}
}
}
