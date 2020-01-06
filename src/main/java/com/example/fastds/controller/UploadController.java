package com.example.fastds.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.example.fastds.util.FastDFSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
 
@Controller
public class UploadController {
 
	@Autowired
	private FastDFSClientUtil dfsClient;
 
	@RequestMapping("/")
	public String index() {
		return "index.html";
	}
 
	@PostMapping("/upload")
	public String fdfsUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
 
		try {
			String fileUrl = dfsClient.uploadFile(file);
			System.out.println(fileUrl);
			request.setAttribute("msg", "成功上传文件，  '" + fileUrl + "'");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}
 

}