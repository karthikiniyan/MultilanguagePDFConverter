package com.karthik.PdfConverter;

import org.springframework.stereotype.Component;

import com.aspose.pdf.Document;
import com.aspose.pdf.Font;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;
import com.aspose.pdf.TextSearchOptions;
import com.aspose.pdf.TextSegment;


@Component
public class PDFConverter {
	
	public void converter () {
		
		// For complete examples and data files, please go to https://github.com/aspose-pdf/Aspose.Pdf-for-Java
		// Instantiate Document object
		Document inputPDF = new Document("C:/workspace/PdfConverter/src/main/resources/input.pdf");

		// Lets to change every of word "Page" to some Japan text with specific font MSGothic that might be installed in the OS
		// Also, it may be another font that supports hieroglyphs
		TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("Incident");

		// Create instance of Text Search options
		TextSearchOptions searchOptions = new TextSearchOptions(true);
		textFragmentAbsorber.setTextSearchOptions(searchOptions);

		// Accept the absorber for all pages of document
		inputPDF.getPages().accept(textFragmentAbsorber);

		// Get the extracted text fragments into collection
		TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();

		// Loop through the fragments
		for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
			// Get particular segment from Segments collection of TextFragment
			// object
			TextSegment textSegment = textFragment.getSegments().get_Item(1);
			// Create an instance of font object using MSGothic font
			Font font = FontRepository.findFont("MSGothic");
			// Get the size of current TextSegment object
			float size = textSegment.getTextState().getFontSize();
			// Replace the text Fragment with Japanese text
			textFragment.setText("入射");
			// Set font for TextFragment as MSGothic
			textFragment.getTextState().setFont(font);
			textFragment.getTextState().setFontSize(size);
		}
		// Save the updated document
		inputPDF.save("Japanese_Text.pdf");
		
		System.out.println("conversion done");
		
	}

}
