package edu.ntudp.pzks.lab4.controller;

import com.google.gson.Gson;
import edu.ntudp.pzks.lab4.model.University;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonManager {
    private static final Gson gson = new Gson();

    public static String convertUniversityToJson(University university) {
        return gson.toJson(university);
    }

    public static void writeJsonToFile(String json, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error: Failed to write JSON to file: " + filePath);
        }
    }

    public static University readUniversityFromJson(String json) {
        try{
            return gson.fromJson(json, University.class);
        }catch (Exception e) {
            System.out.println("Error: Failed to create university from JSON");
            return null;
        }
    }

    public static University readUniversityFromFile(String filePath) {
        try {
            String json = new String(Files.readAllBytes(Paths.get(filePath)));
            return readUniversityFromJson(json);

        } catch (IOException e) {
            System.out.println("Error: Failed to create university from file");
            return null;
        }
    }

}
