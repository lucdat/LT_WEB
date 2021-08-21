package shoesstore.entities;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class MyFile implements Serializable {
	private static final long serialVersionUID = 4621940440984499718L;
	private MultipartFile multipartFile;
	private String description;
	public MyFile() {
		
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
