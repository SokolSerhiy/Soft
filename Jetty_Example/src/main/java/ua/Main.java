package ua;

import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.component.LifeCycle.Listener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.annotation.Handler;

public class Main {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        final ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("/META-INF/context.xml");
        
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(Handler.class);
        beans.entrySet().stream().map((e)->e.getValue()).map(b->(HttpServlet)b).forEach(b->context.addServlet(new ServletHolder(b), b.getClass().getAnnotation(Handler.class).value()));
        server.addLifeCycleListener(new Listener() {
			public void lifeCycleStopping(LifeCycle arg0) { }
			public void lifeCycleStopped(LifeCycle arg0) {
				applicationContext.close();
			}
			public void lifeCycleStarting(LifeCycle arg0) { }
			public void lifeCycleStarted(LifeCycle arg0) { }
			public void lifeCycleFailure(LifeCycle arg0, Throwable arg1) {
				applicationContext.close();
			}
		});
        server.start();
        server.join();
        
	}
}