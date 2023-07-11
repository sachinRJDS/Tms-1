package com.TYSS.Renaa_TMS_Hybrid;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class ListenerItransform implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		annotation.setRetryAnalyzer(com.TYSS.Renaa_TMS_Hybrid.ListenerRetryImpln.class);
	}

}
