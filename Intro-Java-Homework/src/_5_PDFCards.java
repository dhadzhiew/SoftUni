import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class _5_PDFCards {
	public static void main(String[] args) {
		String[] cards = new String[]{"A","K","Q","J","2","3","4","5","6","7","8","9",
				"10"};
		String[] suits = new String[]{"H","S","D","C"};
		  try {
		      Document document = new Document();
		      PdfWriter.getInstance(document, new FileOutputStream("D:/pdfto.pdf"));
		      document.open();
		      document.addSubject("Subjecta");
		      document.addTitle("Hello my first pdf file");
		      
		      Image heart = Image.getInstance("http://images3.makefive.com/images/experiences/hobbies/top-5-card-games/hearts-7.gif");
		      heart.setAlignment(Element.ALIGN_CENTER);;
		      heart.scaleAbsoluteHeight(20);
		      heart.scaleAbsoluteWidth(20);
		      
		      Image diamond = Image.getInstance("http://www.clker.com/cliparts/6/e/d/8/1194984816305628060card_figures_-_diamond_01.svg.med.png");
		      diamond.setAlignment(Element.ALIGN_CENTER);
		      diamond.scaleAbsoluteHeight(20);
		      diamond.scaleAbsoluteWidth(20);
		      

		      Image club = Image.getInstance("http://img4.wikia.nocookie.net/__cb20051126232008/uncyclopedia/images/4/4f/Card-clubs-up.gif");
		      club.setAlignment(Element.ALIGN_CENTER);
		      club.scaleAbsoluteHeight(20);
		      club.scaleAbsoluteWidth(20);
		      
		      Image spade = Image.getInstance("http://www.creditblack.org/993032.jpg");
		      spade.setAlignment(Element.ALIGN_CENTER);;
		      spade.scaleAbsoluteHeight(20);
		      spade.scaleAbsoluteWidth(20);
		      
		      
		      Font fontRed = new Font(Font.FontFamily.TIMES_ROMAN, 15,
  					Font.BOLD, BaseColor.RED);
		      Font fontBlack = new Font(Font.FontFamily.TIMES_ROMAN, 15,
	  					Font.BOLD, BaseColor.BLACK);

		      heart.setSpacingBefore(30);
		      spade.setSpacingBefore(30);
		      diamond.setSpacingBefore(30);
		      club.setSpacingBefore(30);
		      PdfPTable table = new PdfPTable(4) ;
		    
		      PdfPCell cell = null;
		      for(String card : cards){
		    	  for(String suit : suits){
		    		  switch(suit){
		    		  case "H":   
		    			  cell = new PdfPCell();
		    			  cell.addElement(makeCard(card, fontRed, document, heart));
		    		  	break;
		    		  case "D":   
		    			  cell = new PdfPCell();
		    			  cell.addElement(makeCard(card, fontRed, document, diamond));
		    		  	break;
		    		  case "C":   
		    			  cell = new PdfPCell();
		    			  cell.addElement(makeCard(card, fontBlack, document, club));
		    		  	break;
		    		  case "S":   
		    			  cell = new PdfPCell();
		    			  cell.addElement(makeCard(card, fontBlack, document, spade));
		    		  	break;
		    		  } 
		    		  cell.setBorder(0);
		    		  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		    		  table.addCell(cell);
		    	  }
		      }
		      document.add(table);

		      document.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}
	
	static PdfPTable makeCard(String text,Font font,Document document, Image suit) throws Exception{
			PdfPTable table = new PdfPTable(1) ;
			table.setSpacingAfter(10);
			table.setWidthPercentage(90);
			Phrase phrase = new Phrase(text,font);
			phrase.setLeading(12); 
			PdfPCell cell = new PdfPCell();
			cell.addElement(phrase);
			cell.addElement(suit);
			cell.setFixedHeight(120);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell);
			return table;
	}
}
