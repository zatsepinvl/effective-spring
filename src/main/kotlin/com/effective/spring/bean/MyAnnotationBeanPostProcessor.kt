package com.effective.spring.bean

import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.stereotype.Component


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class MyAnnotation(val name: String)


@Component
class MyAnnotationBeanPostProcessor : BeanPostProcessor {

    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any? {
        val annotation = AnnotationUtils.findAnnotation(bean.javaClass, MyAnnotation::class.java)
        if (annotation != null) {
            println("Annotation found: ${annotation.name}")
        }
        return bean
    }
}

@Component
@MyAnnotation("parent")
abstract class Parent

@Component
@MyAnnotation("child")
class Circle : Parent()

