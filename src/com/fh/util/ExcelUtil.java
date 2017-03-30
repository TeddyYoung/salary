package com.fh.util;

import java.math.BigDecimal;

import org.apache.poi.xssf.usermodel.XSSFCell;

/**
 * Excel文件处理解析工具类
 * @author zhang_yu
 *
 */
public class ExcelUtil {
	
	/**
	 * 解析Excel中的单元格公式, 返回公式的String计算值
	 * 单元格中的值需要经过设置后的公式计算
	 * @param cell Excel的单元格
	 * @return 解析公式后的计算值
	 */
	public String getFormulaCellStringValue(XSSFCell cell) {
		
		String value = null;
		if (null != cell && !"".equals(cell)) {
			switch (cell.getCellType()) {
			case XSSFCell.CELL_TYPE_FORMULA:
				try {
					value = String.valueOf(cell.getNumericCellValue());
				} catch (Exception e) {
					try { //防止公式计算值"#N/A"
						value = String.valueOf(cell.getRichStringCellValue());
					} catch (Exception e2) {
						return null;
					}
				}
				break;
			case XSSFCell.CELL_TYPE_NUMERIC:
				value = String.valueOf(cell.getNumericCellValue());
				break;
			case XSSFCell.CELL_TYPE_STRING:
				value = String.valueOf(cell.getRichStringCellValue());
				break;
			}
		}
		return value;
		
	}
	
	/**
	 * 解析Excel中的单元格公式, 返回公式的BigDecimal计算值
	 * 单元格中的值需要经过设置后的公式计算
	 * @param cell Excel的单元格
	 * @return 解析公式后的计算值
	 */
	public BigDecimal getFormulaCellBigDecimalValue(XSSFCell cell) {
		
		String value = this.getFormulaCellStringValue(cell);
		if (null == value) {
			return null;
		}else{
			BigDecimal bigDecimalValue = new BigDecimal(value);
			return bigDecimalValue;
		}
		
	}
	
	/**
	 * 读取Excel单元格中字符串单元格的值, 返回String
	 * 单元格中的值无需计算, 直接解析即可
	 */
	public String getCellStringValue(XSSFCell cell) {
		
		if (null != String.valueOf(cell) && !"".equals(cell)) {
			return String.valueOf(cell);
		}else{
			return null;
		}
		
	}
	
	/**
	 * 读取Excel单元格中字符串单元格的值, 返回BigDecimal类型的值
	 * 单元格中的值无需计算, 直接解析即可
	 */
	public BigDecimal getBigDecimalValue(XSSFCell cell) {
		
		if (null != String.valueOf(cell) && !"".equals(cell)) {
			String cellValue = String.valueOf(cell);
			try {
				BigDecimal bigDecimal = new BigDecimal(cellValue);
				return bigDecimal;
			} catch (Exception e) {
				return null;
			}
		}else{
			return null;
		}
		
	}
	
	/**
	 * 读取Excel单元格中字符串单元格的值, 将字符串类型的百分数转为BigDecimal类型的小数返回
	 * 单元格中的值无需计算, 直接解析即可
	 */
	public BigDecimal getBigDecimalValueFromPercentage(XSSFCell cell) {
		
		if (null != String.valueOf(cell) && !"".equals(cell)) {
			try {
				String cellValue = String.valueOf(cell);
				String ssCellValue = cellValue.substring(0, cellValue.indexOf("%"));
				BigDecimal bigDecimal = new BigDecimal(ssCellValue);
				BigDecimal bigDecimal2 = new BigDecimal("100");
				return bigDecimal.divide(bigDecimal2);
			} catch (Exception e) {
				return null;
			}
		}else{
			return null;
		}
		
	}
	
	/**
	 * 
	 */
	
}
