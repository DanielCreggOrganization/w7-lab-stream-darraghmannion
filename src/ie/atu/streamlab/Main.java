package ie.atu.streamlab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Java Streams!");
         List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        names.stream()
             .filter(name -> name.startsWith("A"))
             .forEach(name -> System.out.println(name));

             List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

             numbers.stream()
             .filter(num -> num % 2 != 0)
             .forEach(System.out::println);

             List<String> fruits = Arrays.asList("apple", "banana", "grape", "kiwi", "orange", "mango");

        List<String> result = fruits.stream()
                                    .filter(fruit -> fruit.length() > 4)  
                                    .sorted() 
                                    .map(String::toUpperCase) 
                                    .collect(Collectors.toList());

       
        result.forEach(System.out::println);  

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);

      
        numbers2.stream()
               .map(NumberUtils::doubleNumber)  
               .forEach(System.out::println);  

               List<Integer> numbers3 = Arrays.asList(2, 4, 6, 8, 10);

        
        int product = numbers3.stream()
                             .reduce(1, (a, b) -> a * b);  

       
        int min = numbers3.stream()
                         .reduce(Integer.MAX_VALUE, (a, b) -> Math.min(a, b));  

        System.out.println("Product: " + product);
        System.out.println("Minimum value: " + min);

        String filePath = "resources/input.txt";

        try {
           
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            
            long countJavaLines = lines.stream()
                                       .filter(line -> line.contains("Java")) 
                                       .count();  
           
            double averageLineLength = lines.stream()
                                            .mapToInt(String::length) 
                                            .average()  
                                            .orElse(0.0); 
         
            System.out.println("Lines containing \"Java\": " + countJavaLines);
            System.out.println("Average line length: " + averageLineLength);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


    


  
    
