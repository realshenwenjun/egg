package com.dskj.system.support;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

public class MyDispatcherServlet extends DispatcherServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6461491950436910136L;
	public static int pv = 0;

	@Override
	protected LocaleContext buildLocaleContext(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.buildLocaleContext(request);
	}

	@Override
	protected HttpServletRequest checkMultipart(HttpServletRequest request) throws MultipartException {
		// TODO Auto-generated method stub
		return super.checkMultipart(request);
	}

	@Override
	protected void cleanupMultipart(HttpServletRequest request) {
		// TODO Auto-generated method stub
		super.cleanupMultipart(request);
	}

	@Override
	protected Object createDefaultStrategy(ApplicationContext context, Class<?> clazz) {
		// TODO Auto-generated method stub
		return super.createDefaultStrategy(context, clazz);
	}

	@Override
	protected void doDispatch(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		pv++;
		super.doDispatch(arg0, arg1);
	}

	@Override
	protected void doService(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		super.doService(arg0, arg1);
	}

	@Override
	protected <T> List<T> getDefaultStrategies(ApplicationContext arg0, Class<T> arg1) {
		// TODO Auto-generated method stub
		return super.getDefaultStrategies(arg0, arg1);
	}

	@Override
	protected <T> T getDefaultStrategy(ApplicationContext context, Class<T> strategyInterface) {
		// TODO Auto-generated method stub
		return super.getDefaultStrategy(context, strategyInterface);
	}

	@Override
	protected String getDefaultViewName(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return super.getDefaultViewName(request);
	}

	@Override
	protected HandlerExecutionChain getHandler(HttpServletRequest arg0) throws Exception {
		// TODO Auto-generated method stub
		return super.getHandler(arg0);
	}

	@Override
	protected HandlerAdapter getHandlerAdapter(Object arg0) throws ServletException {
		// TODO Auto-generated method stub
		return super.getHandlerAdapter(arg0);
	}

	@Override
	protected void initStrategies(ApplicationContext context) {
		// TODO Auto-generated method stub
		super.initStrategies(context);
	}

	@Override
	protected void noHandlerFound(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		super.noHandlerFound(arg0, arg1);
	}

	@Override
	protected void onRefresh(ApplicationContext context) {
		// TODO Auto-generated method stub
		super.onRefresh(context);
	}

	@Override
	protected ModelAndView processHandlerException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		// TODO Auto-generated method stub
		return super.processHandlerException(arg0, arg1, arg2, arg3);
	}

	@Override
	protected void render(ModelAndView arg0, HttpServletRequest arg1, HttpServletResponse arg2) throws Exception {
		// TODO Auto-generated method stub
		super.render(arg0, arg1, arg2);
	}

	@Override
	protected View resolveViewName(String arg0, Map<String, Object> arg1, Locale arg2, HttpServletRequest arg3) throws Exception {
		// TODO Auto-generated method stub
		return super.resolveViewName(arg0, arg1, arg2, arg3);
	}

	@Override
	public void setCleanupAfterInclude(boolean cleanupAfterInclude) {
		// TODO Auto-generated method stub
		super.setCleanupAfterInclude(cleanupAfterInclude);
	}

	@Override
	public void setDetectAllHandlerAdapters(boolean detectAllHandlerAdapters) {
		// TODO Auto-generated method stub
		super.setDetectAllHandlerAdapters(detectAllHandlerAdapters);
	}

	@Override
	public void setDetectAllHandlerExceptionResolvers(boolean detectAllHandlerExceptionResolvers) {
		// TODO Auto-generated method stub
		super.setDetectAllHandlerExceptionResolvers(detectAllHandlerExceptionResolvers);
	}

	@Override
	public void setDetectAllHandlerMappings(boolean detectAllHandlerMappings) {
		// TODO Auto-generated method stub
		super.setDetectAllHandlerMappings(detectAllHandlerMappings);
	}

	@Override
	public void setDetectAllViewResolvers(boolean detectAllViewResolvers) {
		// TODO Auto-generated method stub
		super.setDetectAllViewResolvers(detectAllViewResolvers);
	}

	@Override
	public void setThrowExceptionIfNoHandlerFound(boolean throwExceptionIfNoHandlerFound) {
		// TODO Auto-generated method stub
		super.setThrowExceptionIfNoHandlerFound(throwExceptionIfNoHandlerFound);
	}

	@Override
	protected void applyInitializers(ConfigurableApplicationContext arg0) {
		// TODO Auto-generated method stub
		super.applyInitializers(arg0);
	}

	@Override
	protected ServletRequestAttributes buildRequestAttributes(HttpServletRequest request, HttpServletResponse response, RequestAttributes previousAttributes) {
		// TODO Auto-generated method stub
		return super.buildRequestAttributes(request, response, previousAttributes);
	}

	@Override
	protected void configureAndRefreshWebApplicationContext(ConfigurableWebApplicationContext wac) {
		// TODO Auto-generated method stub
		super.configureAndRefreshWebApplicationContext(wac);
	}

	@Override
	protected WebApplicationContext createWebApplicationContext(ApplicationContext parent) {
		// TODO Auto-generated method stub
		return super.createWebApplicationContext(parent);
	}

	@Override
	protected WebApplicationContext createWebApplicationContext(WebApplicationContext parent) {
		// TODO Auto-generated method stub
		return super.createWebApplicationContext(parent);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(request, response);
	}

	@Override
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doTrace(request, response);
	}

	@Override
	protected WebApplicationContext findWebApplicationContext() {
		// TODO Auto-generated method stub
		return super.findWebApplicationContext();
	}

	@Override
	public String getContextAttribute() {
		// TODO Auto-generated method stub
		return super.getContextAttribute();
	}

	@Override
	public Class<?> getContextClass() {
		// TODO Auto-generated method stub
		return super.getContextClass();
	}

	@Override
	public String getContextConfigLocation() {
		// TODO Auto-generated method stub
		return super.getContextConfigLocation();
	}

	@Override
	public String getContextId() {
		// TODO Auto-generated method stub
		return super.getContextId();
	}

	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return super.getNamespace();
	}

	@Override
	public String getServletContextAttributeName() {
		// TODO Auto-generated method stub
		return super.getServletContextAttributeName();
	}

	@Override
	protected String getUsernameForRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.getUsernameForRequest(request);
	}

	@Override
	protected void initFrameworkServlet() throws ServletException {
		// TODO Auto-generated method stub
		super.initFrameworkServlet();
	}

	@Override
	protected WebApplicationContext initWebApplicationContext() {
		// TODO Auto-generated method stub
		return super.initWebApplicationContext();
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		super.onApplicationEvent(event);
	}

	@Override
	protected void postProcessWebApplicationContext(ConfigurableWebApplicationContext wac) {
		// TODO Auto-generated method stub
		super.postProcessWebApplicationContext(wac);
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		super.refresh();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(request, response);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		// TODO Auto-generated method stub
		super.setApplicationContext(applicationContext);
	}

	@Override
	public void setContextAttribute(String contextAttribute) {
		// TODO Auto-generated method stub
		super.setContextAttribute(contextAttribute);
	}

	@Override
	public void setContextClass(Class<?> contextClass) {
		// TODO Auto-generated method stub
		super.setContextClass(contextClass);
	}

	@Override
	public void setContextConfigLocation(String contextConfigLocation) {
		// TODO Auto-generated method stub
		super.setContextConfigLocation(contextConfigLocation);
	}

	@Override
	public void setContextId(String contextId) {
		// TODO Auto-generated method stub
		super.setContextId(contextId);
	}

	@Override
	public void setContextInitializerClasses(String contextInitializerClasses) {
		// TODO Auto-generated method stub
		super.setContextInitializerClasses(contextInitializerClasses);
	}

	@Override
	public void setContextInitializers(ApplicationContextInitializer<? extends ConfigurableApplicationContext>... arg0) {
		// TODO Auto-generated method stub
		super.setContextInitializers(arg0);
	}

	@Override
	public void setDispatchOptionsRequest(boolean dispatchOptionsRequest) {
		// TODO Auto-generated method stub
		super.setDispatchOptionsRequest(dispatchOptionsRequest);
	}

	@Override
	public void setDispatchTraceRequest(boolean dispatchTraceRequest) {
		// TODO Auto-generated method stub
		super.setDispatchTraceRequest(dispatchTraceRequest);
	}

	@Override
	public void setNamespace(String namespace) {
		// TODO Auto-generated method stub
		super.setNamespace(namespace);
	}

	@Override
	public void setPublishContext(boolean publishContext) {
		// TODO Auto-generated method stub
		super.setPublishContext(publishContext);
	}

	@Override
	public void setPublishEvents(boolean publishEvents) {
		// TODO Auto-generated method stub
		super.setPublishEvents(publishEvents);
	}

	@Override
	public void setThreadContextInheritable(boolean threadContextInheritable) {
		// TODO Auto-generated method stub
		super.setThreadContextInheritable(threadContextInheritable);
	}

	@Override
	protected ConfigurableEnvironment createEnvironment() {
		// TODO Auto-generated method stub
		return super.createEnvironment();
	}

	@Override
	public ConfigurableEnvironment getEnvironment() {
		// TODO Auto-generated method stub
		return super.getEnvironment();
	}

	@Override
	protected void initBeanWrapper(BeanWrapper bw) throws BeansException {
		// TODO Auto-generated method stub
		super.initBeanWrapper(bw);
	}

	@Override
	public void setEnvironment(Environment environment) {
		// TODO Auto-generated method stub
		super.setEnvironment(environment);
	}

	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doHead(req, resp);
	}

	@Override
	protected long getLastModified(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return super.getLastModified(req);
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

	@Override
	public String getInitParameter(String name) {
		// TODO Auto-generated method stub
		return super.getInitParameter(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		// TODO Auto-generated method stub
		return super.getInitParameterNames();
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return super.getServletConfig();
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return super.getServletInfo();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	@Override
	public void log(String msg) {
		// TODO Auto-generated method stub
		super.log(msg);
	}

	@Override
	public void log(String message, Throwable t) {
		// TODO Auto-generated method stub
		super.log(message, t);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

}
