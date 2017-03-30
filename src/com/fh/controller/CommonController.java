package com.fh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.util.DownloadUtil;

/**
 * 接口表 Controller
 * @author zhouqk
 */
@Controller(value="commonController")
@RequestMapping(value = "/common")
public class CommonController {
	
	/**
	 * 下载模板文件
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("downloadTemplate")
	public void downloadTemplate(HttpServletRequest request, HttpServletResponse response, String fileType, String yearMonth) throws Exception {
		DownloadUtil downloadUtil = new DownloadUtil();
		String filePath = request.getSession().getServletContext().getRealPath("template");
		String fileName = "";
		if ("1".equals(fileType)) {// 文件类型： 搭伙补贴
			fileName = "【模板】搭伙补贴.xlsx";
		} else if ("2".equals(fileType)) {// 文件类型：浮动编制 TODO
			fileName = "【模板】MMP、NPS、便利店批量上传.xlsx";
		} else if ("3".equals(fileType)) {// 文件类型：
			fileName = "【模板】星级评测.xlsx";
		} else if ("4".equals(fileType)) {// 文件类型：
			fileName = "【模板】各油站逐月绩效目标.xlsx";
		} else if ("5".equals(fileType)) {// 津贴模板
			fileName = "【模板】岗位津贴.xlsx";
		} else if ("6".equals(fileType)) {// 话费模板
			fileName = "【模板】扣款维护.xlsx";
		} else if ("7".equals(fileType)) {// 浮动编制
			fileName = "【模板】编制维护.xlsx";
		} else if ("8".equals(fileType)) {// 销售提成
			fileName = "【模板】销售提成.xlsx";
		} else if ("9".equals(fileType)) {// 绩效系数
			fileName = "【模板】绩效系数.xlsx";
		} else if ("10".equals(fileType)) {// 油品损耗奖金
			fileName = "【模板】油品损耗奖金.xlsx";
		} else if ("11".equals(fileType)) {// 其他奖金
			fileName = "【模板】奖金配置.xlsx";
		} else if ("12".equals(fileType)) {// 销售数据
			fileName = "【模板】销售数据.xlsx";
		} else if ("13".equals(fileType)) {// 便利店考核
			fileName = "【模板】便利店考核.xlsx";
		} else if ("14".equals(fileType)) {// MMP
			fileName = "【模板】MMP、NPS分数.xlsx";
		} else if ("15".equals(fileType)) {// 挑战奖金
			fileName = "【模板】挑战奖金.xlsx";
		} else if("16".equals(fileType)){
			fileName = "【模板】兼站奖金.xlsx";
		}else if("17".equals(fileType)){
			fileName = "【模板】住宿补贴.xlsx";
		}
		else if (yearMonth != null && !"".equals(yearMonth)) {// 下载当月薪资表
			filePath = request.getSession().getServletContext().getRealPath("uploadFiles/" + yearMonth);
			fileName = "中化福建" + yearMonth + "薪资表.zip";
		}
		downloadUtil.download(filePath + "/" + fileName, fileName, response, false);
	}

}
