package com.karthik.PdfConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PDFController {
	
	@Autowired 
	public PDFConverter conver;
	
	@GetMapping("/callConverter")
	public void callConverter() {
		
		conver.converter();
	}

}
