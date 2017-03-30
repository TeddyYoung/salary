package com.fh.controller.salarymanagement;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.fh.entity.system.Flag;
import com.fh.util.UploadFile;

/**
 * 薪资计算模板上传Controller
 * @author zhang_yu 
 *
 */
@Controller(value = "SalaryTemplateController")
@RequestMapping({ "/salaryTemplate" })
public class SalaryTemplateController {

	/**
	 * 跳转至薪资计算模板上传页面
	 */
	@RequestMapping("/salaryTemplate.do")
	public String salaryTemplate(Model model) {
		
		Flag flag = new Flag();
		flag.setFlag("1");
		model.addAttribute("Flag", flag);
		return "salarymanagement/salaryTemplate/salaryTemplateUpload";
		
	}
	
	/**
	 * 上传薪资Excel表格
	 */
	@RequestMapping("/salaryTemplateUpload.do")
	public String salaryTemplateUpload(HttpServletRequest request, String type, 
							   		   MultipartFile uploadFile, Model model) throws Exception {
		
		// 判断上传的文件是否是空文件
		String originalFilename = uploadFile.getOriginalFilename();
		if ("" == originalFilename) {
			Flag flag = new Flag();
			flag.setFlag("2");
			model.addAttribute("Flag", flag);
			return "salarymanagement/salaryTemplate/salaryTemplateUpload";
		}

		// 判断上传的是否是Excel文件
		String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
		if (!".xlsx".equals(substring)) {
			Flag flag = new Flag();
			flag.setFlag("3");
			model.addAttribute("Flag", flag);
			return "salarymanagement/salaryTemplate/salaryTemplateUpload";
		}
		
		// 上传文件工具类
		UploadFile uploadUtil = new UploadFile();
		// 上传文件, 并返回文件上传的绝对目录
		String filePath = uploadUtil.uploadFile(request, uploadFile, type, null);
		
		// 以返回的上传文件的绝对路径构建输入流
		InputStream is = new FileInputStream(filePath); 
		//读取上传的这个模板
		XSSFWorkbook xSSFWorkbook = new XSSFWorkbook(is);
		XSSFSheet sheet = xSSFWorkbook.getSheet("薪资计算公式模板");
		
		int rowNum = 3;
//		int cellNum = 43;
		
		XSSFRow row = sheet.getRow(rowNum);
		for (int i = 43; i < 92; i++) {
			XSSFCell cell = row.getCell(i);
			String cellFormula = cell.getCellFormula();
			System.out.println(cellFormula);
			System.out.println("------------------------------------------------------------------------");
		}
		
		
		Flag flag = new Flag();
		flag.setFlag("4");
		model.addAttribute("Flag", flag);
		return "salarymanagement/salaryTemplate/salaryTemplateUpload";
	}
	
}
