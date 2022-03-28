package org.kgitbank.file.model.dao;

import java.util.List;

import org.kgitbank.file.model.vo.FileVO;

public interface IFileRepository {
	
	int getMaxFileId();
	void uploadFile(FileVO file);
	FileVO getFile(int fileId);
	List<FileVO> getAllFileList();
	List<FileVO> getAllFileListByDir(String dir); 
	

}
