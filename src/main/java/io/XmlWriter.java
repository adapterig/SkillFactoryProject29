package io;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import model.FullInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class XmlWriter {
    private XmlWriter() {
    }

    public static void writeXml(FullInfo fullInfo) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FullInfo.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        try{
            Files.createDirectory(Paths.get("xmlReqs"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File xmlFile = new File("xmlReqs/req.xml");
        marshaller.marshal(fullInfo, xmlFile);

    }
}

