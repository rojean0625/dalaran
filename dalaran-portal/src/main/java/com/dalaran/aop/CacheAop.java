package com.dalaran.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.dalaran.annot.CacheAnt;

@Aspect
@Component
public class CacheAop {

	@Pointcut("@annotation(com.dalaran.annot.CacheAnt)")
	private void cacheMgr(){}


	@Around("cacheMgr()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("## doAround");


        String clazzName =  joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

//        Signature s = joinPoint.getSignature();
//        MethodSignature m = (MethodSignature) s;
//        String modelType =  m.getMethod().getAnnotation(CacheAnt.class).modelName();

        Signature s = joinPoint.getSignature();
        MethodSignature m = (MethodSignature) s;
        Method currentMethod = joinPoint.getTarget().getClass().getMethod(m.getName(),m.getParameterTypes());
        String modelType = currentMethod.getAnnotation(CacheAnt.class).modelName();

        System.out.println("## clazzName " + clazzName);
        System.out.println("## methodName " + methodName);
        System.out.println("## args " + Arrays.asList(args));
        System.out.println("## modelType " + modelType);

        StringBuilder sb = new StringBuilder(clazzName);
        sb.append("-");
        sb.append(methodName);
        sb.append("-");

        for (Object obj : args) {
            sb.append(obj.toString());
            sb.append("-");
        }
        System.out.println(sb);


        Object object = joinPoint.proceed();//执行该方法
        return object;
    }
}
