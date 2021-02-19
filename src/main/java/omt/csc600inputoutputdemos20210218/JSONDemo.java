/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omt.csc600inputoutputdemos20210218;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author omt
 */
public class JSONDemo {
    public static void main(String[] args) throws ParseException, IOException {
        System.out.println("--- JSON Demo ---");
        writeJSONToString1();
        readJSON();
        writeJSONToString2();
    }
    
    static void writeJSONToString1() {
        System.out.println("Write JSON to string 1");
        Person person = new Person("Ada Lovelace", 29);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(person);
        System.out.println("jsonStr " + jsonStr);
    }
    
    static void writeJSONToString2() {
        System.out.println("Write JSON to string 2");
        Person person1 = new Person("Ada Lovelace", 29);
        Person person2 = new Person("Alan Kay", 80);
        
        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        
        // Just get the ages from people
        List<Integer> ages = people.stream()
                .map(p -> p.age)
                .collect(Collectors.toList());
        
        for (Person p: people) {
            System.out.println("Person -> " + p);
        }
        
        for (int age: ages) {
            System.out.println("age -> " + age);
        }
        
        Gson gson = new Gson();
        String jsonStr = gson.toJson(people);
        System.out.println("jsonStr (people): " + jsonStr);
        
        jsonStr = gson.toJson(ages);
        System.out.println("jsonStr (ages):" + jsonStr);
    }
    
    static void readJSON() throws ParseException, IOException {
        System.out.println("Read JSON from file");
        JSONParser jsonParser = new JSONParser();
        Path path = Paths.get("person.json");
        String jsonContent = Files.readString(path);
        System.out.println("JSON content: " + jsonContent);
        Object obj = jsonParser.parse(jsonContent);
        
        System.out.println("Obj " + obj);
    }
}
