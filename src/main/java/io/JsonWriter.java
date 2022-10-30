package io;

import model.FullInfo;
import util.JsonUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {
    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    private JsonWriter() {
    }

    public static void writeJson(FullInfo fullInfo) {
        logger.log(Level.INFO, "JSON writing started");
        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.log(Level.INFO, "Directory \"jsonReqs\" created");
        } catch (IOException ioException) {
            logger.log(Level.FINE, "Failed to create directory, maybe directory already exists", ioException);
        }
        File jsonFile = new File("jsonReqs/req" + new Date().getTime() + ".json");
        String text = "";
        text = JsonUtil.studentListToJson(fullInfo.getStudentList()) + "\n" +
                JsonUtil.universityListToJson(fullInfo.getUniversityList()) + "\n" +
                JsonUtil.statisticsListToJson(fullInfo.getStatisticsList());

        try {
            FileWriter fileWriter = new FileWriter(jsonFile);
            fileWriter.write(text);
            fileWriter.close();
            logger.log(Level.INFO, "JSON file written");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Writing JSON to file failed");
        }
    }
}
