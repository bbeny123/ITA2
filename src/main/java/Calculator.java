package pl.beny;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Calculator {

  static int add(String numbersString) {
    int result = 0;
    List<Integer> numbers = new ArrayList<>();
    if(!numbersString.isEmpty()) {
      Arrays.asList(numbersString.split(",|\n")).forEach(number -> numbers.add(Integer.parseInt(number)));
      for(Integer number : numbers) {
	result += number;
      }
    }
    return result;    
  }

}
