package omt.csc600inputoutputdemos20210218;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

/**
 *
 * @author omt
 */
public class FileInputOutputDemo {

    public static void main(String[] args) throws IOException {
        System.out.println("--- FileInputOutputDemo Demos (18 Feb 2021/Thr( ---");
//        readFileDemo1();
//        readFileDemo2();
//        readFileDemo3();
//        readFileDemo4();
        writeFile1();
        appendToFile1();
    }

    static void printFileInfo(File file) {
        System.out.println("File Info:");
        System.out.println(" Name: " + file.getName());
        System.out.println(" Length: " + file.length());
        System.out.println(" Path: " + file.getPath());
    }

    static void readFileDemo1() throws FileNotFoundException, IOException {
        System.out.println("Read file demo1");
        String fileName = "hello.txt";
        File file = new File(fileName);
        printFileInfo(file);

        // Let's use try with resources: All resources should be closed
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            String content = new String(data);
            System.out.println("Content:\n" + content);
        };
    }

    static void readFileDemo2() throws FileNotFoundException, IOException {
        System.out.println("Read file demo2");
        String fileName = "story1.txt";
        File file = new File(fileName);
        printFileInfo(file);

        // Let's use try with resources: All resources should be closed
        try (FileReader fr = new FileReader(file)) {
            char[] buffer = new char[(int) file.length()];
            fr.read(buffer);
            String content = new String(buffer);
            System.out.println("Content:\n" + content);
        }
    }

    /**
     * I believe this is a simpler way of reading a file from file system.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    static void readFileDemo3() throws FileNotFoundException, IOException {
        System.out.println("Read file demo3");
        String fileName = "story2.txt";
        Path path = Paths.get(fileName);
        String content = Files.readString(path);
        System.out.println("Content:\n" + content);
    }

    static void readFileDemo4() throws FileNotFoundException, IOException {
        System.out.println("Read file demo4");
        String fileName = "story2.txt";
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path); //, StandardCharsets.UTF_8);

        for (String line : lines) {
            System.out.println("line: " + line);
        }
    }
    
    static void writeFile1() throws IOException {
        String fileName = "hello2.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write("Hello my CSC600 friends. Hope everyone is OK\n");
        writer.write("What's up?\n");
        writer.write("\nHave a wonderful day...\n");
        writer.close();
    }
    
    static void appendToFile1() throws IOException {
        String fileName = "hello2.txt";
        boolean append = true;
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append));
        writer.append("\nThese are new info. Today is " + new Date());
        writer.append("\nBye for now...");
        writer.close();
    }
}
