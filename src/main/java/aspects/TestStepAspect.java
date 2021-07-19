package aspects;

import annotations.SpiraTestStep;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class TestStepAspect {

    private SpiraTestStep step;

    @Pointcut("@annotation(annotations.SpiraTestStep)")
    public void withStepAnnotation() {
    }

    @Pointcut("execution(* *(..))")
    public void anyMethod() {
    }

    @Before("anyMethod() && withStepAnnotation()")
    public void stepStart(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        step = (SpiraTestStep)methodSignature.getMethod().getAnnotation(SpiraTestStep.class);
        System.out.println("ID: " + step.id());
       // getLifecycle().startStep(uuid, result);
    }

    @AfterThrowing(
            pointcut = "anyMethod() && withStepAnnotation()",
            throwing = "e"
    )
    public void stepFailed(Throwable e) {
        System.out.println("FAILED: id - "+ step.id()+", Error: "+ e.getMessage());
//        getLifecycle().updateStep((s) -> {
//            s.setStatus((Status) ResultsUtils.getStatus(e).orElse(Status.BROKEN)).setStatusDetails((StatusDetails)ResultsUtils.getStatusDetails(e).orElse((Object)null));
//        });
//        getLifecycle().stopStep();
    }

    @AfterReturning(
            pointcut = "anyMethod() && withStepAnnotation()"
    )
    public void stepStop() {
        System.out.println("Done: "+step.id());
//        getLifecycle().updateStep((s) -> {
//            s.setStatus(Status.PASSED);
//        });
//        getLifecycle().stopStep();
    }

}
