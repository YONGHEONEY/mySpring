package org.kgitbank.file.controller;

import java.io.IOException;

import org.kgitbank.file.model.vo.FileVO;
import org.kgitbank.file.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {
	
	@Autowired
	private IFileService fileService;
	
	@GetMapping("/new")
	public String uploadFile(Model model) {
		model.addAttribute("dir","/");
		return "/file/form";
	}
	
	@PostMapping("/save")
	public String uploadFile(@RequestParam(value="dir", required=false, defaultValue="/") String dir, 
			@RequestParam MultipartFile file, RedirectAttributes redi) {
		try {
			if(file != null && !file.isEmpty()) {
				FileVO newFile = new FileVO();
				newFile.setDirectoryName(dir);
				newFile.setFileName(file.getOriginalFilename());
				newFile.setFileSize(file.getSize());
				newFile.setfileContentType(file.getContentType());
				newFile.setFileData(file.getBytes());
				fileService.uploadFile(newFile);
			}
		} catch(IOException e) {
			e.printStackTrace();
			redi.addFlashAttribute("message", e.getMessage());
//			redi.addAttribute("message", e.getMessage());
		}
		return "redirect:/list";
	}
	
	@GetMapping("/img/{fileId}")
	public ResponseEntity<byte[]> getImageFile(@PathVariable int fileId) {
		FileVO file = fileService.getFile(fileId);
		final HttpHeaders headers = new HttpHeaders();
		if(file != null) {
			String[] mediaTypes = file.getfileContentType().split("/");
			headers.setContentType(new MediaType(mediaTypes[0], mediaTypes[1]));
			headers.setContentDispositionFormData("attachment", file.getFileName());
			headers.setContentLength(file.getFileSize());
			return new ResponseEntity<byte[]>(file.getFileData(), headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/list")
	public String getFileList(Model model) {
		model.addAttribute("fileList", fileService.getAllFileList());
		return "/file/list";
	}
	
	@GetMapping("/list/{dir}")
	public String getFileListByDir(Model model, @PathVariable String dir) {
		model.addAttribute("fileList", fileService.getAllFileListByDir("/"+dir));
		return "/file/list";
	}

}
