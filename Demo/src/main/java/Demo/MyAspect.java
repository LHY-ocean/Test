package Demo;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class MyAspect implements MethodBeforeAdvice, AfterReturningAdvice,MethodInterceptor, ThrowsAdvice{

	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("执行之前");
	}

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("正常返回："+returnValue);
	}

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("环绕前");
		Object o = invocation.proceed();
		System.out.println("环绕后");
		return o;
	}

	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
		 System.out.println("出错了");
	 }
	
}
