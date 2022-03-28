package org.kgitbank.file.service;

import java.util.List;

import org.kgitbank.file.model.dao.IFileRepository;
import org.kgitbank.file.model.vo.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FileService implements IFileService{
//	@Autowired
//	private IFileService fileService;
	
	@Autowired
	private IFileRepository fileRepository;

	@Override
	public int getMaxFileId() {
		return fileRepository.getMaxFileId();
	}

	@Override
	public void uploadFile(FileVO file) {
		file.setFileId(getMaxFileId()+1);
		fileRepository.uploadFile(file);
	}

	@Override
	public FileVO getFile(int fileId) {
		return fileRepository.getFile(fileId);
	}
	
	@Override
	public List<FileVO> getAllFileList() {
		return fileRepository.getAllFileList();
	}

	@Override
	public List<FileVO> getAllFileListByDir(String dir) {
		return fileRepository.getAllFileListByDir(dir);
	}
	
//	@GetMapping("/img/{fileId}")
//	public ResponseEntity<byte[]> getImageFile(@PathVariable int fileId) {
//		FileVO file = fileService.getFile(fileId);
//		final HttpHeaders headers = new HttpHeaders();
//		if(file != null) {
//			String[] mediaTypes = file.getfileContentType().split("/");
//			headers.setContentType(new MediaType(mediaTypes[0], mediaTypes[1]));
//			headers.setContentDispositionFormData("attachment", file.getFileName());
//			headers.setContentLength(file.getFileSize());
//			return new ResponseEntity<byte[]>(file.getFileData(), headers, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
//		}
//	}

}
