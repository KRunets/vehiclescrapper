package by.runets.vehiclescrapper.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component


@Aspect
@Component
class TimeExecutionAspect {

    @Throws(Throwable::class)
    @Around("@annotation(by.runets.vehiclescrapper.utils.annotation.LogExecutionTime)")
    fun logExecutionTime(joinPoint: ProceedingJoinPoint): Any? {
        val start = System.currentTimeMillis()

        val proceed = joinPoint.proceed()

        val executionTime = System.currentTimeMillis() - start

        println(joinPoint.signature.name + " executed in " + executionTime + "ms")
        return proceed
    }

}