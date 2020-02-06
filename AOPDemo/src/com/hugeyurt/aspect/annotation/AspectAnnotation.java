package com.hugeyurt.aspect.annotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/**
 * �����࣬�ڴ����б�д֪ͨ
 */
@Component
@Aspect
public class AspectAnnotation {
	// �����������ʽ
	@Pointcut("execution(* com.hugeyurt.aspect.annotation.*.*(..))")
	// ʹ��һ������ֵΪvoid��������Ϊ�յķ��������������
	private void myPointCut(){}
	// ǰ��֪ͨ
	
	@Before("myPointCut()")
	public void myBefore(JoinPoint joinPoint) {
		System.out.print("ǰ��֪ͨ ��ģ��ִ��Ȩ�޼��...,");
		System.out.print("Ŀ�����ǣ�"+joinPoint.getTarget() );
		System.out.println(",��֯����ǿ�����Ŀ�귽��Ϊ��"
		               +joinPoint.getSignature().getName());
	}
	// ����֪ͨ
	@AfterReturning(value="myPointCut()")
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.print("����֪ͨ��ģ���¼��־...," );
		System.out.println("��֯����ǿ�����Ŀ�귽��Ϊ��"
		              + joinPoint.getSignature().getName());
	}
	// ����֪ͨ	
	@Around("myPointCut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) 
            throws Throwable {
		// ��ʼ
		System.out.println("���ƿ�ʼ��ִ��Ŀ�귽��֮ǰ��ģ�⿪������...");
		// ִ�е�ǰĿ�귽��
		Object obj = proceedingJoinPoint.proceed();
		// ����
		System.out.println("���ƽ�����ִ��Ŀ�귽��֮��ģ��ر�����...");
		return obj;
	}
	// �쳣֪ͨ
	@AfterThrowing(value="myPointCut()",throwing="e")
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("�쳣֪ͨ��" + "������" + e.getMessage());
	}
	// ����֪ͨ
	@After("myPointCut()")
	public void myAfter() {
		System.out.println("����֪ͨ��ģ�ⷽ����������ͷ���Դ...");
	}
}
