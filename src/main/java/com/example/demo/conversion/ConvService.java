package com.example.demo.conversion;

import com.qoppa.office.OfficeException;
import com.qoppa.office.WordConvertOptions;
import com.qoppa.office.WordDocument;
import com.qoppa.pdf.PDFException;

import java.io.IOException;
import java.util.concurrent.Callable;


public class ConvService implements Callable<String> {

    private String folderPath;
    private String filePath ;
    private String fileName ;
    private String toType;

    public ConvService(String folderPath, String filePath, String fileName, String toType) {
        this.folderPath = folderPath;
        this.filePath = filePath;
        this.fileName = fileName;
        this.toType = toType;
    }

    @Override
    public String call() throws Exception {

        WordConvertOptions opts = new WordConvertOptions();
        try {
            WordDocument  wdoc = new WordDocument(filePath,opts);
            wdoc.saveAsPDF(folderPath+"/"+fileName+toType);
        } catch (IOException | OfficeException | PDFException e) {
            e.printStackTrace();
        }

        System.out.println("Done!");
        return "Done!";
    }
}
