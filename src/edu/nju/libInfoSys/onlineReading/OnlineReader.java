package edu.nju.libInfoSys.onlineReading;

import java.io.File;
import java.util.InputMismatchException;

public class OnlineReader {
    private Reader reader;

    public OnlineReader(String type) {
        switch (type) {
            case "Word":
                reader = new WordReader();
                break;
            case "PDF":
                reader = new PDFReader();
                break;
            case "EPUB":
                reader = new EPUBReader();
                break;
            default:
                throw new InputMismatchException();
        }
    }

    public Object readFile(File file) {
        return reader.read(file);
    }
}
