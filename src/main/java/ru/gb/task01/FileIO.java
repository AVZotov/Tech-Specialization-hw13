package ru.gb.task01;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileIO {

    public static void serialise(String filename, Object object){
        try{
            if (filename.endsWith(".json")){
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(filename), object);
            } else if (filename.endsWith(".xml")) {
                XmlMapper xmlMapper = new XmlMapper();
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                xmlMapper.writeValue(new File(filename), object);
            } else if (filename.endsWith(".bin")) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                    oos.writeObject(object);
                }
            }else {
                throw new FileNameExtensionException("unrecognized file extension");
            }
        } catch (IOException | FileNameExtensionException e) {
            throw new RuntimeException(e);
        }
    }
}
