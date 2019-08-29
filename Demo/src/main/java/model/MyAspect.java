package model;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class MyAspect implements MethodBeforeAdvice{

	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("执行之前");
	}

	

}
