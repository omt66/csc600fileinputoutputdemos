package omt.csc600inputoutputdemos20210218;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author omt
 */
public class XMLDemo {

    public static void main(String[] args) throws IOException {
        System.out.println("--- XML Demo ---");
//        xmlDemo1();
//        xmlDemo2();
        xmlDemo3();
    }

    static void xmlDemo1() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Person person = new Person("Jane Walker", 35);
        String xmlInfo = xmlMapper.writeValueAsString(person);
        System.out.println("XML info -> " + xmlInfo);
    }
    
    static void xmlDemo2() throws IOException {
        Person person = new Person("Alan Kay", 80);
        serializeToFile("person.xml", person);
    }

    static void serializeToFile(String fileName, Person person) throws IOException {
        File file = new File(fileName);
        XmlMapper xmlMapper = new XmlMapper();
        
        xmlMapper.writeValue(file, person);
    }
    
    static void xmlDemo3() throws IOException {
        System.out.println("Read xml file and parse");
        XmlMapper xmlMapper = new XmlMapper();
        Path path = Paths.get("person.xml");
        String xmlContent = Files.readString(path);
        System.out.println("XML content (text): " + xmlContent);
        Person person = xmlMapper.readValue(xmlContent, Person.class);
        
        System.out.println("Person is " + person);
       
    }
}
