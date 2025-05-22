package com.multicampus.web.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

@Controller
// Model에 "board"라는 이름으로 데이터가 등록될 때, 세션에도 동일하게 등록해라.
@SessionAttributes("board")
public class BoardController {
	
	// Controller는 비즈니스 컴포넌트를 호출할 때 인터페이스(리모컨)를 이용한다.
	// BoardService 타입의 객체(BoardServiceImpl)를 주입해라.
	@Autowired
	private BoardService boardService;

	// 글 등록 화면으로 이동
	@RequestMapping("/insertBoardView.do")
	public String insertBoardView() throws Exception {
		return "insertBoard.jsp";
	}
	
	// 글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws Exception {
		boardService.insertBoard(vo);
		// 문자열을 리턴하면 해당 화면으로 이동한다(기본 : Forward)
		return "redirect:getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	// 세션에 "board"라는 이름으로 등록된 객체가 있다면 꺼내서 재사용해라.
	public String updateBoard(@ModelAttribute("board") BoardVO vo) throws Exception {
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) throws Exception {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) throws Exception {
		model.addAttribute("board", boardService.getBoard(vo)); // Model
		return "getBoard.jsp";   // View 이름 리턴
	}
	
	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) throws Exception {
		// Null Check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		model.addAttribute("condition", vo.getSearchCondition());
		model.addAttribute("keyword", vo.getSearchKeyword());
		model.addAttribute("boardList", boardService.getBoardList(vo)); // Model
		return "getBoardList.jsp";    // View 이름 리턴
	}

}










