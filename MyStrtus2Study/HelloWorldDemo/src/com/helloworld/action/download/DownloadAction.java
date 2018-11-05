package com.helloworld.action.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

public class DownloadAction {

	private String fileName;

	public InputStream getInputStream() throws Exception {
		String path = ServletActionContext.getServletContext().getRealPath("/downloads");
		return new FileInputStream(new File(path, fileName));
	} 
	
	public String download() {
		return "success";
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
