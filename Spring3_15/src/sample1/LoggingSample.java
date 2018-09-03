package sample1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingSample {

	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getKind();
		StopWatch sw = new StopWatch();

		sw.start(methodName);

		System.out.println("[LOG] METHOD: " + methodName + " is calling.");
		Object rtnObj = pjp.proceed();

		sw.stop();

		System.out.println("[LOG] METHOD:" + methodName + " was called.");
		System.out.println("[LOG] processing time " + sw.getTotalTimeMillis() / 1000 + " sec");

		return rtnObj;
	}
}
