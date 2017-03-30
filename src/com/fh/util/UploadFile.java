package com.fh.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传工具类
 * @author Teddy
 *
 */
public class UploadFile {
	
	public String uploadFile(HttpServletRequest request, MultipartFile uploadFile, String projectNo, String originalFilename) {
		try {
			String backPath = null; //定义一个字符串存放文件上传在服务器上的路径
			
			if (null != uploadFile && !"".equals(uploadFile)) {
				//服务器上保存文件的目录
				String realPath = request.getSession().getServletContext().getRealPath("uploadFiles");
				// 将不同页面上传的文件放放于不同的文件夹中
				String storeDirectory = realPath + "/" + projectNo;;
				
				//获取上传文件的原文件名
				if(originalFilename == null) {
					originalFilename = uploadFile.getOriginalFilename();
					originalFilename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
				}
				//获取生成的日期目录
				String dir = this.makeChildDirectory(storeDirectory);
				//指定文件上传的最终目录
				String uploadDir = storeDirectory + "/" + dir;
				//将最终的上传绝对目录返回
				backPath = uploadDir + "/" + originalFilename;
//				backPath = "/uploadFiles/" + projectNo + "/" + dir + "/" + originalFilename;
				uploadFile.transferTo(new File(uploadDir, originalFilename)); //上传
				
				return backPath;
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	//创建一个以日期命名的上传文件目录
	private String makeChildDirectory(String storeDirectory) {
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String directory = df.format(date);
		
		File file = new File(storeDirectory, directory);
		if (!file.exists()) { // 如果该文件目录不存在, 创建它
			file.mkdirs();
		}
		
		return directory;
		
	}
	
}
