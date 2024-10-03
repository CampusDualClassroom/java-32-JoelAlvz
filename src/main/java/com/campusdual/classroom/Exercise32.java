package com.campusdual.classroom;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise32 {

    public static void main(String[] args) {

        String textToSave = generateStringToSave(null);
        printToFile(textToSave);
    }

    public static String generateStringToSave(String string) {
        if (string == null) {
            return generateUserInputToSave();
        }
        return string;
    }


    private static String generateUserInputToSave() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String line;
        System.out.println("Escribe el texto, pulsa \"ENTER\" dos veces seguidas para finalizar:");
        while (!(line = scanner.nextLine()).isEmpty()) {
            sb.append(line).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        try (FileWriter writer = new FileWriter("src/main/resources/data.txt")) {
            writer.write(string);
            System.out.println("Texto guardado correctamente");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}