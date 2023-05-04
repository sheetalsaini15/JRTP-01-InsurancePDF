package com.example.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.example.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


@Component
public class PdfGenerator {

	public void generate(HttpServletResponse response , List<CitizenPlan> records,File file) throws Exception {
	
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		PdfWriter.getInstance(document, new FileOutputStream(file));
		
		document.open();
		
		
		// Creating font
				// Setting font style and size
				Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				fontTiltle.setSize(20);

				// Creating paragraph
				Paragraph paragraph = new Paragraph("Citizen Plans", fontTiltle);

				// Aligning the paragraph in document
				paragraph.setAlignment(Paragraph.ALIGN_CENTER);

				// Adding the created paragraph in document
				document.add(paragraph);
		
		
		
		
		PdfPTable table= new PdfPTable(6);
		table.setSpacingBefore(7);
		
		
		// Create Table Cells for table header
				PdfPCell cell = new PdfPCell();

				// Setting the background color and padding
				cell.setBackgroundColor(CMYKColor.MAGENTA);
				cell.setPadding(7);
		
		
		
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		
		
		
		
		for (CitizenPlan Plan : records) {
			
			table.addCell(String.valueOf(Plan.getCitizenId()));
			table.addCell(Plan.getCitizenName());
			table.addCell(Plan.getPlanName());
			table.addCell(Plan.getPlanStatus());
			
			if (null != Plan.getPlanStartDate()) {
				table.addCell(Plan.getPlanStartDate()+"");
			}else {
				table.addCell("N/A");
			}
			
			
            if (null != Plan.getPlanEndDate()) {
            	table.addCell(Plan.getPlanEndDate()+"");
			}else {
				table.addCell("N/A");
			}
	
			
		}
		
	
		document.add(table);
		document.close();
	
	}	
}
