package Demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Aspect {
	 public void Before(JoinPoint p) throws Throwable{
//		 System.out.println(p.getTarget().hashCode());
//		 System.out.println(p.getThis().hashCode());
			System.out.println("前置.......");
		} 
	 public void AfterReturning(JoinPoint p,Object result) throws Throwable{
			System.out.println("返回......."+result);
		} 
	 public void After(JoinPoint p) throws Throwable{
			System.out.println("后置.......");
		} 
	 public Object Around(ProceedingJoinPoint pjp) throws Throwable{
			System.out.println("h前置.......");
			Object o = pjp.proceed();
			System.out.println("h后置.......");
			return o;
		} 
	 public void AfterThrowing( JoinPoint jp, Throwable e) throws Throwable{
			System.out.println("出错了"+e.getMessage());
		}
}
