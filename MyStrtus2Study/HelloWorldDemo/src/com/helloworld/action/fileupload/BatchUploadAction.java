package com.helloworld.action.fileupload;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 * 文件上传
 * @author BREEZE
 *
 */
public class BatchUploadAction {
	
	private File file[];	//	file 属性名和表单域名相同

	//	上传文件的名称也是由 Struts2 设置好
	//	属性名=表单域名+FileName
	private String fileFileName[];
	
	//	文件类型，属性名=表单域名+ContentType
	private String fileContentType[];
	
	/**
	 * 上传文件的业务方法
	 * @return
	 */
	public String batchUpload() {
		
		//	获取上传文件目录
		String path = ServletActionContext.getServletContext().getRealPath("/uploads");
		try {
			for (int i = 0; i < file.length; i++) {
				FileUtils.copyFile(file[i], new File(path, fileFileName[i]));
			}
			
			return "success";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "error";
	}

	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}
}
