package com.gla;

import java.io.*;

public class ReadConsoleWriteFile {
    public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))
        ) {
            String line;
            System.out.println("Enter text :):");
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line);
                writer.newLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

