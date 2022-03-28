package org.kgitbank.file.service;

import java.util.List;

import org.kgitbank.file.model.vo.FileVO;

public interface IFileService {
	
	int getMaxFileId();
	void uploadFile(FileVO file);
	FileVO getFile(int fileId);
	List<FileVO> getAllFileList();
	List<FileVO> getAllFileListByDir(String dir); 

}
