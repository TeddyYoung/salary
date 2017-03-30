package com.fh.common.export;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

public class ExportExcel {
	
	//下载
	public static void download(ByteArrayOutputStream byteArrayOutputStream,HttpServletResponse response,String returnName) throws IOException{
		response.setContentType("application/octet-stream;charset=utf-8");
		returnName=response.encodeURL(new String(returnName.getBytes(),"iso8859-1"));
		response.addHeader("Content-Disposition","attachment;filename=" + returnName); 
		response.setContentLength(byteArrayOutputStream.size());
		
		//获取输出流
		ServletOutputStream outPutStream = response.getOutputStream();
		//写到输出流
		byteArrayOutputStream.writeTo(outPutStream);
		//关闭
		byteArrayOutputStream.close();
		//刷新数据
		outPutStream.flush();
	}	
	
	// 小标题的样式
	public static CellStyle title(Workbook wb) {
		
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 12);

		style.setFont(font);

		style.setAlignment(CellStyle.ALIGN_CENTER); // 横向居中
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 纵向居中

		style.setBorderTop(CellStyle.BORDER_THIN); // 上细线
		style.setBorderBottom(CellStyle.BORDER_THIN); // 下细线
		style.setBorderLeft(CellStyle.BORDER_THIN); // 左细线
		style.setBorderRight(CellStyle.BORDER_THIN); // 右细线

		return style;
		
	}
	//大标题样式
	public static CellStyle bigTitle(Workbook wb){
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short)(16));
		//加粗
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(font);
		//横向居中
		style.setAlignment(CellStyle.ALIGN_CENTER);
		//纵向居中
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		return style;
	}
	//文字样式
	public static CellStyle text(Workbook wb) {
		
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short) 10);

		style.setFont(font);

		style.setBorderTop(CellStyle.BORDER_THIN); // 上细线
		style.setBorderBottom(CellStyle.BORDER_THIN); // 下细线
		style.setBorderLeft(CellStyle.BORDER_THIN); // 左细线
		style.setBorderRight(CellStyle.BORDER_THIN); // 右细线
		//横向居中
		style.setAlignment(CellStyle.ALIGN_CENTER);
		//纵向居中
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		return style;
		
	}
}
