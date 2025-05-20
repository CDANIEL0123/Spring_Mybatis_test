package com.multicampus.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BoardPointcut {
	@Pointcut("execution(* com.multicampus.biz..*Impl.*(..))")
	public void allPoitcut() {}
	
	@Pointcut("execution(* com.multicampus.biz..*Impl.get*(..))")
	public void getPoitcut() {}
	
	@Pointcut("execution(* com.multicampus.biz.board.*Impl.*(..))")
	public void boardPoitcut() {}
	
	@Pointcut("execution(* com.multicampus.biz.user.*Impl.*(..))")
	public void userPoitcut() {}
}
