package com.xmh.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xmh.service.MealService;


@Controller
public class UploadController {
	@Autowired
	private MealService mealService;
	
	@RequestMapping("/upload")
	@ResponseBody
	public Map<String, String> upload(@RequestParam("mealId")Integer mealId,@RequestParam(value = "file")MultipartFile file ,HttpServletRequest request) throws IllegalStateException, IOException {
		
		Map<String, String> map = new HashMap<String, String>();
		//�ļ��ϴ�λ��/DesWeb/WebContent/WEB-INF/img/meal
		String uploadPath = "G:/worker/eclipse-workspace/DesWeb/WebContent/WEB-INF/img/meal";
		System.out.println(file);
		//�ļ�ԭʼ����
		String originalFileName = file.getOriginalFilename();
		//���ļ���
		//String newFileName =String.valueOf(System.currentTimeMillis())+originalFileName.substring(originalFileName.lastIndexOf("."));
		//�����ļ���
		File dir=new File(uploadPath,originalFileName);
		//���ļ�
		//�ж��ļ�Ŀ¼�Ƿ����
		if (!dir.getParentFile().exists()) {
			dir.getParentFile().mkdirs();
		}
		System.out.println(dir);
		//д�����
		file.transferTo(dir);
		//������URL
		File filepath = new File(uploadPath+ File.separator +originalFileName);
		String fileString = filepath.getPath();
		System.out.println(fileString);
		boolean flag = mealService.submitImg(mealId,fileString);
		if (flag) {
			map.put("result", "success");
			return map;
		}
		
		return null;

	}
}
