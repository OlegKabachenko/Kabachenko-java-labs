package edu.ntudp.pzks.lab5.controller;

import com.google.gson.Gson;
import edu.ntudp.pzks.lab5.model.University;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonManager {
    private final Gson gson = new Gson();

    public String convertUniversityToJson(University university) {
        return gson.toJson(university);
    }

    public void writeJsonToFile(String json, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error: Failed to write JSON to file: " + filePath);
        }
    }

    public University readUniversityFromJson(String json) {
        try{
            return gson.fromJson(json, University.class);
        }catch (Exception e) {
            System.out.println("Error: Failed to create university from JSON");
            return null;
        }
    }

    public University readUniversityFromFile(String filePath) {
        try {
            String json = new String(Files.readAllBytes(Paths.get(filePath)));
            return readUniversityFromJson(json);

        } catch (IOException e) {
            System.out.println("Error: Failed to create university from file");
            return null;
        }
    }

}
