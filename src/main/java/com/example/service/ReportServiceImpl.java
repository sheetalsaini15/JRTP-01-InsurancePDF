package com.example.service;


import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.entity.CitizenPlan;
import com.example.repo.CitizenPlanRepo;
import com.example.request.SearchRequest;
import com.example.utils.EmailUtils;
import com.example.utils.ExcelGenerator;
import com.example.utils.PdfGenerator;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private ExcelGenerator exlGenerator;

	@Autowired
	private CitizenPlanRepo repo;

	@Override
	public List<String> getPlanNames() {

		return repo.getPlanName();
	}

	@Override
	public List<String> getPlanStatuses() {

		return repo.getPlanStatus();
	}

	//@Override
	/*public List<CitizenPlan> search(SearchRequest request) {

		CitizenPlan entity = new CitizenPlan();

		
		 * if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
		 * entity.setPlanName(request.getPlanName()); }
		 * 
		 * if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
		 * entity.setPlanStatus(request.getPlanStatus()); }
		 * 
		 * if (null != request.getGender() && !"".equals(request.getGender())) {
		 * entity.setGender(request.getGender()); } if (null !=
		 * request.getPlanStartDate() && !"".equals(request.getPlanStartDate())) {
		 * 
		 * String startDate = request.getPlanStartDate();
		 * 
		 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 * LocalDate localDate = LocalDate.parse(startDate, formatter);
		 * 
		 * entity.setPlanStartDate(localDate); }
		 * 
		 * if (null != request.getPlanEndDate() && !"".equals(request.getPlanEndDate()))
		 * {
		 * 
		 * String endDate = request.getPlanEndDate();
		 * 
		 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 * LocalDate localDate = LocalDate.parse(endDate, formatter);
		 * 
		 * entity.setPlanEndDate(localDate); }
		 * 
		 * Example<CitizenPlan> example = Example.of(entity);
		 * 
		 * List<CitizenPlan> findAll = repo.findAll(example);
		 * 
		 * findAll.forEach(System.out::println);
		
		return findAll;
	} */

	@Override
	public Boolean exportExcel(HttpServletResponse response) throws Exception {

		
		List<CitizenPlan> records = repo.findAll();
		File file=new File("plans.xls");
		exlGenerator.generate(response, records,file);
		
		
		String subject="Test mail subject";
		String body="<h1>Test mail Body</h1>";
		String to="nishant8064@gmail.com";
		
		
		emailUtils.sandMail(subject, body, to,file);
		
		file.delete();
		
		return true;
	}
	
	
	

	@Override
	public Boolean exportPdf(HttpServletResponse response) throws Exception {

		File file=new File("plans.pdf");
		List<CitizenPlan> records = repo.findAll();

		pdfGenerator.generate(response, records,file);
		
		
		String subject="Test mail subject";
		String body="<h1>Test mail Body</h1>";
		String to="nishant8064@gmail.com";
		
		
		emailUtils.sandMail(subject, body, to,file);
		
		file.delete();
		
		return true;
	}

}
