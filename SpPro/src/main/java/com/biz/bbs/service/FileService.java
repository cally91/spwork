package com.biz.bbs.service;

import java.awt.BufferCapabilities.FlipContents;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.biz.bbs.mapper.FileDao;
import com.biz.bbs.model.BBsVO;
import com.biz.bbs.model.FileVO;

@Service
public class FileService {

	@Autowired
	FileDao fDao;
	
	private String upLoadFolder="c:/bizwork/upload/";

	/*
	 * 파일들을 이름을 UUID이름으로 변경하고 변경된 파일들의 이름을 fileVO에 담아서 리턴하는 METHOD
	 */
	public List<FileVO> gatFileList(List<MultipartFile> files) {

		List<FileVO> fileList = new ArrayList<FileVO>();
		for (MultipartFile file : files) {
			String originName = file.getOriginalFilename();
			String uuString = UUID.randomUUID().toString();
			String saveName = uuString + "_" + originName;
			fileList.add(FileVO.builder().file_origin_name(originName).file_name(saveName).build());

		}
		return fileList;
	}
	
	public List<FileVO> gatFileList(BBsVO bbsVO) {
		
		
		List<MultipartFile> files = bbsVO.getBbs_files();
		long bbs_seq = bbsVO.getBbs_seq();

		List<FileVO> fileList = new ArrayList<FileVO>();
		for (MultipartFile file : files) {
			String originName = file.getOriginalFilename();
			String uuString = UUID.randomUUID().toString();
			String saveName = uuString + "_" + originName;

			fileList.add(
					FileVO.builder().file_bbs_seq(bbs_seq).file_name(saveName).file_origin_name(originName).build());

			// 업로드 될 폴더+UUIDD 파일 이름 묶여서 FILE 객체로 생성
			File uploadFile =new File(upLoadFolder,saveName);
			
			try {
				file.transferTo(uploadFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fileList;
	}

	public void fileListInsert(List<FileVO> files) {
		for (FileVO fileVO : files) {
			fDao.insert(fileVO);
		}
	}

	public boolean file_delete(long file_seq) {
		// 파일정보 ㅊ출
		FileVO fileVO =fDao.findBySeq(file_seq);
		
		//파일의 물리적 경로 생성
		File delFile= new File(upLoadFolder,fileVO.getFile_name()) ;
		
		//파일이 있는지 확인한 후
		if(delFile.exists()) {
			// 파일삭제
			delFile.delete();
			// DB정보 삭제
			fDao.delete(file_seq);
			return true;
		}
		return false;
	}
	
	
}
