package io;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import model.FullInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {
    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());

    private XmlWriter() {
    }

    public static void writeXml(FullInfo fullInfo)  {
        logger.log(Level.INFO, "XML marshalling started");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(FullInfo.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try {
                Files.createDirectory(Paths.get("xmlReqs"));
                logger.log(Level.INFO, "Directory \"xmlReqs\" created");
            } catch (IOException ioException) {
                logger.log(Level.FINE, "Failed to create directory, maybe directory already exists", ioException);
            }
            File xmlFile = new File("xmlReqs/req" + new Date().getTime() + ".xml");
            marshaller.marshal(fullInfo, xmlFile);
        } catch (JAXBException jaxbException) {
            logger.log(Level.SEVERE, "XML marshalling failed", jaxbException);
        }
        logger.log(Level.INFO, "XML marshalled successfully");
    }
}

