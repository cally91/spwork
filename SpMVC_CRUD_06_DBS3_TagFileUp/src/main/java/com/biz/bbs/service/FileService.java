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

	private String upLoadFolder = "c:/bizwork/upload/";

	/*
	 * 파일들을 이름을 UUID이름으로 변경하고 변경된 파일들의 이름을 fileVO에 담아서 리턴하는 METHOD
	 */

	public void uploadFileList(BBsVO bbsVO) {

		// 1. VO에서 파일리스트를 추출
		List<MultipartFile> files = bbsVO.getBbs_files();

		// 2. VO에서 seq값을 추출
		long bbs_seq = bbsVO.getBbs_seq();

		// 3.(업로드된)파일의 개수반큼 반복문을 수행
		for (MultipartFile file : files) {

			// 4. 파일 정보에서 원래 파일이름을 추출
			String originName = file.getOriginalFilename();

			// 5. 파일 이름에 UUID를 추가하여
			String uuString = UUID.randomUUID().toString();

			// 6. UUID와 원래 파일 이름을 연결해서
			// 7. 저장하는 파일이름으로 생성
			String saveName = uuString + "_" + originName;

			// 8. 파일 리스트를 생성
			// 파일 테이블에 저장하기 위한 List를 생성

			// 업로드 될 폴더+UUIDD 파일 이름 묶여서 FILE 객체로 생성
			File uploadFile = new File(upLoadFolder, saveName);

			try {
				// 서버의 폴더에 저장하기
				file.transferTo(uploadFile);
				// 한개의 파일정보를 insert수행
				fDao.insert(FileVO.builder().file_bbs_seq(bbs_seq) // tbl_bbs와 tbl_bbs_file을 연결하는 key
						.file_name(saveName) // view에서 확인할 파일명
						.file_origin_name(originName).build()); // 원래 원본파일이름

			} catch (IllegalStateException | IOException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void fileListInsert(List<FileVO> files) {
		for (FileVO fileVO : files) {
			fDao.insert(fileVO);
		}
	}

	public boolean file_delete(long file_seq) {
		// 파일정보 ㅊ출
		FileVO fileVO = fDao.findBySeq(file_seq);

		// 파일의 물리적 경로 생성
		File delFile = new File(upLoadFolder, fileVO.getFile_name());

		// 파일이 있는지 확인한 후
		if (delFile.exists()) {
			// 파일삭제
			delFile.delete();
			// DB정보 삭제
			fDao.delete(file_seq);
			return true;
		}
		return false;
	}

}
