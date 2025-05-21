package com.multicampus.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) 클래스
@Repository
public class UserDAOSpring {
	
	@Autowired
	private JdbcTemplate spring;

	// USERS 테이블 관련 SQL 명령어들
	private final String USER_GET = "select * from users where id=? and password=?";

	// CRUD 기능의 메소드 구현
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> SPRING 기반으로 getUser() 기능 처리");
		Object[] params = {vo.getId(), vo.getPassword()};
		return spring.queryForObject(USER_GET, new UserRowMapper(), params);
	}

}
