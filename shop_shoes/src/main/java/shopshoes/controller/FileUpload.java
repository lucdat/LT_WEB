package shopshoes.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import shopshoes.entities.MyFile;
import shopshoes.util.Constant;

@Controller
public class FileUpload {
	@RequestMapping("/uploadFile")
	public String index(Model model) {
		model.addAttribute("myFile", new MyFile());
		return "upload/upload-file";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(MyFile myFile, Model model) {
		model.addAttribute("message", "upload success");
		model.addAttribute("description", myFile.getDescription());

		try {
			MultipartFile multipartFile = myFile.getMultipartFile();
			String fileName = multipartFile.getOriginalFilename();
			File file = new File(Constant.DIRECT_FILE_IMG, fileName);
			multipartFile.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "upload failed");
		}
		return "successfull";
	}
}
