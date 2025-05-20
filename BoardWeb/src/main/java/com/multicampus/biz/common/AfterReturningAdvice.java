package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.multicampus.biz.user.UserVO;

// After-Returning은 비즈니스 메소드가 리턴한 데이터를 받아서 사후처리 로직을 작성할 수 있다.
@Service
@Aspect
public class AfterReturningAdvice {
	
	//컨테이너가 Advice(afterLog)를 호출하면서 비즈니스 메소드 리턴값을 바인드 변수(returnObj)에 전달해줌
	@AfterReturning(pointcut = "BoardPointcut.getPointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		System.out.println("[사후 처리]"+methodName +"()메소드 리턴값 : "+ returnObj.toString());
		
		if (returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
		}
		
		
	}
}
