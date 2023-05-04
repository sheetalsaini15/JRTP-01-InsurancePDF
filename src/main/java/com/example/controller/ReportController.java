package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.CitizenPlan;
import com.example.request.SearchRequest;
import com.example.service.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		 
		response.setContentType("application/pdf");
		
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
		service.exportPdf(response);
		
	}
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		 
		response.setContentType("application/octet-stream");
		
		response.addHeader("Content-Disposition", "attachment;filename=plans.xls");
		service.exportExcel(response);
		
	}
	
	/*
	 * @PostMapping("/search") public String search(@ModelAttribute("search")
	 * SearchRequest request ,Model model) { System.out.println(request);
	 * 
	 * List<CitizenPlan> result = service.search(request);
	 * model.addAttribute("result", result); //model.addAttribute("search",
	 * request); same work AS @ModelAttribute("search") init(model); return "index";
	 * }
	 */

	/*
	 * @GetMapping("/") public String getwelcome(Model model) {
	 * 
	 * model.addAttribute("search", new SearchRequest());
	 * 
	 * init(model);
	 * 
	 * return "index"; }
	 */

	private void init(Model model) {
		//model.addAttribute("search", new SearchRequest());
		model.addAttribute("names", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatuses());
	}
	
}
