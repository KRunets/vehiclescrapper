package by.runets.vehiclescrapper.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component


@Aspect
@Component
class TimeExecutionAspect {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Throws(Throwable::class)
    @Around("@annotation(by.runets.vehiclescrapper.utils.annotation.LogExecutionTime)")
    fun logExecutionTime(joinPoint: ProceedingJoinPoint): Any? {
        val start = System.currentTimeMillis()

        val proceed = joinPoint.proceed()

        val executionTime = System.currentTimeMillis() - start

        logger.debug(joinPoint.signature.name + " executed in " + executionTime + "ms")

        return proceed
    }

}