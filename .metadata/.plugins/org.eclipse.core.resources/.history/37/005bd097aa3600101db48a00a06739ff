package com.multicampus.web.board;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardDAOJdbc;
import com.multicampus.biz.board.BoardVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 수정 처리");
		
		// 1. 사용자 입력정보 추출
		String title = request.getParameter("title");
		String seq = request.getParameter("seq");
		String content = request.getParameter("content");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setSeq(Integer.parseInt(seq));
		vo.setContent(content);
		
		BoardDAO dao = new BoardDAOJdbc();
		dao.updateBoard(vo);
		
		// 3. 화면 이동
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}

}
