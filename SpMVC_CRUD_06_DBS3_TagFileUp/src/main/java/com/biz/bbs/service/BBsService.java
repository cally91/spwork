package com.biz.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.biz.bbs.mapper.BBsDao;
import com.biz.bbs.model.BBsDto;
import com.biz.bbs.model.BBsVO;
import com.biz.bbs.model.FileVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BBsService {
	
	@Autowired
	BBsDao bDao;

	@Autowired
	FileService fileService;
	
	public List<BBsDto> bbsList() {
//		List<BBsVO> bbsList = bDao.selectAll();
		List<BBsDto> bbsList = bDao.selectAll();
		return bbsList;
	}
	public List<BBsDto> bbsListForFile() {
		List<BBsDto> bbsDto = bDao.selectAllForFile();
		return bbsDto;
	}

	/*
	 * 글쓰기를 수행할때 file을 같이 ypload를 수행하면
	 * 해당하는 글의 seq를 조회하여 
	 * file table에 저장할때 같이 저장을 수행 해줘야한다
	 * 1. 게시글을 저장하고
	 * 1. 게시글의 bbs_seq를 조회하여
	 * 2. 파일 정보를 insert할때 해당하는 bbs_seq를 같이 저장해주야한다.
	 * 그래야 게시글을 조회할떄 해당하는 파일들을 같이 조회할수 있다.
	 * 
	 */
	public int insert(BBsVO bbsVO) {
		//1. 게시글을 저장
		// 저장후에는 bbsVO.bbs_seq에 새로 생성된 PK값이 담겨있다
		int ret =bDao.insert(bbsVO);
		
		// 파일의 개수가 0이상이고 
		//만약 그렇더라도 0번파일의 이름이 있을 경우에만 실행
		if(bbsVO.getBbs_files().size() > 0 
				&& !bbsVO.getBbs_files().get(0).getOriginalFilename().isEmpty()) {
			//2. 게시글의
			// 가, bbs_seq가 추가되고
			// 나, UUID 파일 이름이 추가된
			//filelist ㄹ르 생성하고
			 fileService.uploadFileList(bbsVO);
			
			// 3. 그 리스트를 모두 insert 수행
			//fileService.fileListInsert(fileList);
//			long bbs_seq =bbsVO.getBbs_seq();
//			log.debug("게시판 SEQ :" + bbs_seq);			
		}

		return ret;
	}

	public BBsDto getContent(long bbs_seq) {
		BBsDto bbsdto=bDao.findBySeqForFile(bbs_seq);
		return bbsdto;
	}
	
	public BBsVO findBySeq(long bbs_seq) {
	BBsVO bbsVO= bDao.findByseq(bbs_seq);
		return bbsVO;
	}
	public int update(BBsVO bbsVO) {
		if(bbsVO.getBbs_files().size() > 0 
				&& !bbsVO.getBbs_files().get(0).getOriginalFilename().isEmpty()) {
			 fileService.uploadFileList(bbsVO);
			// fileService.fileListInsert(fileList);
		}
		int ret =bDao.update(bbsVO);
		return ret;
	}
//	public int delete(long bbs_seq) {
//		int ret =bDao.delete(bbs_seq);
//		return ret;
//	}
	
	

}
