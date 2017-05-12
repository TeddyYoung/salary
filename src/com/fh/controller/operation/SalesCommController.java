package com.fh.controller.operation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.fh.controller.BaseController;
import com.fh.entity.system.Flag;
import com.fh.entity.system.StoreEmployee;
import com.fh.util.UploadFile;

/**
 * 员工销售提成确认
 */
@Controller
@RequestMapping({"/sales"})
public class SalesCommController extends BaseController {

	/**
	 * 跳转至员工销售确认提成页面
	 */
	@RequestMapping("toImportExcel.do")
	public String toImportExcel() {

		return "operation/salescomm/importExcel";

	}
	
	/**
	 * 导入Excel表格
	 */
	@RequestMapping("importExcel.do")
	public String importExcel(HttpServletRequest request, String type,
			MultipartFile uploadFile, Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		// 判断上传的文件是否是空文件
		String originalFilename = uploadFile.getOriginalFilename();
		if ("" == originalFilename) {
			Flag flag = new Flag();
			flag.setFlag("1");
			model.addAttribute("flag", flag);
			return "operation/salescomm/importExcel";
		}

		// 判断上传的是否是Excel文件
		String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
		if (!".xls".equals(substring) && !".xlsx".equals(substring)) {
			Flag flag = new Flag();
			flag.setFlag("2");
			model.addAttribute("flag", flag);
			return "operation/salescomm/importExcel";
		}

		// 上传文件工具类
		UploadFile uploadUtil = new UploadFile();
		// 上传文件, 并返回文件上传的绝对目录
		String filePath = uploadUtil.uploadFile(request, uploadFile, type, null);

		// 读取上传的文件的内容
		try {

			InputStream is = new FileInputStream(filePath); // 以返回的上传文件的绝对路径构建输入流

			String extensionsName = filePath.substring(filePath.lastIndexOf("."));
			if (".xls".equals(extensionsName)) {
				HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(is); // 创建一个Excel2003工作簿

				StoreEmployee storeEmployee = null;
				List<StoreEmployee> list = new ArrayList<StoreEmployee>();

				// 循环工作表
				for (int numSheet = 0; numSheet < hSSFWorkbook.getNumberOfSheets(); numSheet++) {
					HSSFSheet hssfSheet = hSSFWorkbook.getSheetAt(numSheet);
					if (null == hssfSheet) {
						continue;
					}

					// 循环Row, 从Excel表格的第二行开始读取数据, 第一行是表头, 写死在页面上, 不读取
					for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
						HSSFRow hssfRow = hssfSheet.getRow(rowNum);
						if (null == hssfRow) {
							continue;
						}

						storeEmployee = new StoreEmployee();

						// 读取单元格中数据
						HSSFCell cell0 = hssfRow.getCell(0); // 用户ID
						if (null == cell0) {
							continue;
						}
						storeEmployee.setUserid(String.valueOf(cell0));

						HSSFCell cell1 = hssfRow.getCell(1); // 用户姓名
						if (null == cell1) {
							continue;
						}
						storeEmployee.setUsername(String.valueOf(cell1));

						HSSFCell cell2 = hssfRow.getCell(2); // 用户密码
						if (null == cell2) {
							continue;
						}
						storeEmployee.setUserpwd(String.valueOf(cell2));

						HSSFCell cell3 = hssfRow.getCell(3); // 状态
						if (null == cell3) {
							continue;
						}
						storeEmployee.setDel(String.valueOf(cell3));

						HSSFCell cell4 = hssfRow.getCell(4); // 是否在线
						if (null == cell4) {
							continue;
						}
						storeEmployee.setOnline(String.valueOf(cell4));

						HSSFCell cell5 = hssfRow.getCell(5); // 电子邮箱
						if (null == cell5) {
							continue;
						}
						storeEmployee.setEmail(String.valueOf(cell5));

						HSSFCell cell6 = hssfRow.getCell(6); // 联系电话
						if (null == cell6) {
							continue;
						}
						storeEmployee.setPhone(String.valueOf(cell6));

						// HSSFCell cell7 = hssfRow.getCell(7); //创建日期
						// if (null == cell7) {
						// continue;
						// }
						// storeEmployee.setCreatedate(Date.valueOf(String.valueOf(cell7)));

						HSSFCell cell8 = hssfRow.getCell(8); // 创建人
						if (null == cell8) {
							continue;
						}
						storeEmployee.setOperator(String.valueOf(cell8));

						// HSSFCell cell9 = hssfRow.getCell(9); //修改日期
						// if (null == cell9) {
						// continue;
						// }
						// storeEmployee.setChangedate(Date.valueOf(String.valueOf(cell9)));

						list.add(storeEmployee);
					}
				}

				model.addAttribute("list", list);
				//TODO 将数据存放到session中作为缓存

			} else {
				XSSFWorkbook xSFWorkbook = new XSSFWorkbook(is);

				StoreEmployee storeEmployee = null;
				List<StoreEmployee> list = new ArrayList<StoreEmployee>();

				// 循环工作表
				for (int numSheet = 0; numSheet < xSFWorkbook.getNumberOfSheets(); numSheet++) {
					XSSFSheet hssfSheet = xSFWorkbook.getSheetAt(numSheet);
					if (null == hssfSheet) {
						continue;
					}

					// 循环Row, 从Excel表格的第二行开始读取数据, 第一行是表头, 写死在页面上, 没什么好读取的
					for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
						XSSFRow hssfRow = hssfSheet.getRow(rowNum);
						if (null == hssfRow) {
							continue;
						}

						storeEmployee = new StoreEmployee();

						// 读取单元格中数据
						XSSFCell cell0 = hssfRow.getCell(0); // 用户ID
						if (null == cell0) {
							continue;
						}
						storeEmployee.setUserid(String.valueOf(cell0));

						XSSFCell cell1 = hssfRow.getCell(1); // 用户姓名
						if (null == cell1) {
							continue;
						}
						storeEmployee.setUsername(String.valueOf(cell1));

						XSSFCell cell2 = hssfRow.getCell(2); // 用户密码
						if (null == cell2) {
							continue;
						}
						storeEmployee.setUserpwd(String.valueOf(cell2));

						XSSFCell cell3 = hssfRow.getCell(3); // 状态
						if (null == cell3) {
							continue;
						}
						storeEmployee.setDel(String.valueOf(cell3));

						XSSFCell cell4 = hssfRow.getCell(4); // 是否在线
						if (null == cell4) {
							continue;
						}
						storeEmployee.setOnline(String.valueOf(cell4));

						XSSFCell cell5 = hssfRow.getCell(5); // 电子邮箱
						if (null == cell5) {
							continue;
						}
						storeEmployee.setEmail(String.valueOf(cell5));

						XSSFCell cell6 = hssfRow.getCell(6); // 联系电话
						if (null == cell6) {
							continue;
						}
						storeEmployee.setPhone(String.valueOf(cell6));

						// HSSFCell cell7 = hssfRow.getCell(7); //创建日期
						// if (null == cell7) {
						// continue;
						// }
						// storeEmployee.setCreatedate(Date.valueOf(String.valueOf(cell7)));

						XSSFCell cell8 = hssfRow.getCell(8); // 创建人
						if (null == cell8) {
							continue;
						}
						storeEmployee.setOperator(String.valueOf(cell8));

						// HSSFCell cell9 = hssfRow.getCell(9); //修改日期
						// if (null == cell9) {
						// continue;
						// }
						// storeEmployee.setChangedate(Date.valueOf(String.valueOf(cell9)));

						list.add(storeEmployee);
					}
				}

				model.addAttribute("list", list);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return "operation/salescomm/importExcel";

	}

}
