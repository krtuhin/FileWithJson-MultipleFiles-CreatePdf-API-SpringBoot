package com.filejsononeapi.services;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    private Logger logger = LoggerFactory.getLogger(PdfService.class);

    //method to create PDF
    public ByteArrayInputStream createPdf() {

        this.logger.info("PDF creating started..!");

        //PDF content
        String title = "This is title of PDF..!";
        String content = "This is content of the PDF...!";

        //write pdf data
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        //create document
        Document document = new Document();

        //create pdf
        PdfWriter.getInstance(document, outputStream);


        //creating footer into pdf
        HeaderFooter footer = new HeaderFooter(true, new Phrase(" tkm"));

        //setting footer alignment
        footer.setAlignment(Element.ALIGN_CENTER);

        //set bottom border
        footer.setBorderWidthBottom(0);

        //add footer into document
        document.setFooter(footer);


        //open document to add pdf content
        document.open();

        //create font for pdf title
        Font titleFont = FontFactory.getFont(FontFactory.COURIER_BOLD, 35, Color.CYAN);

        //create title paragraph
        Paragraph titleParagraph = new Paragraph(title, titleFont);

        //add title alignment
        titleParagraph.setAlignment(Element.ALIGN_CENTER);

        //add paragraph to o document
        document.add(titleParagraph);


        //content paragraph

        //set font into content paragraph
        Font contentFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 20, Color.RED);

        //create content paragraph
        Paragraph contentParagraph = new Paragraph(content, contentFont);

        //add new text into content paragraph
        contentParagraph.add(new Chunk(" This text is added after create content paragraph..!"));

        //set alignment into content paragraph
        contentParagraph.setAlignment(Element.ALIGN_RIGHT);

        //add content paragraph into document
        document.add(contentParagraph);

        //close document after adding all the data
        document.close();

        //returning the byte output stream after converting into
        // ByteInputStream so that we can read the data
        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}
