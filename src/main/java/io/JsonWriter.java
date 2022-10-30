package io;

import model.FullInfo;
import util.JsonUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class JsonWriter {

    private JsonWriter() {
    }

    public static void writeJson(FullInfo fullInfo) {
        try {
            Files.createDirectory(Paths.get("jsonReqs"));
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
