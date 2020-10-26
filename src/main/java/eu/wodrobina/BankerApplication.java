package eu.wodrobina;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class BankerApplication {

    public static final String DEFAULT_CONTEXT_PATH = "/";

    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath(DEFAULT_CONTEXT_PATH);

        Server jettyServer = new Server(8070);
        jettyServer.setHandler(context);

//    new ServletContainer(new AppConfig())
        ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        jerseyServlet.setInitParameter(
                "jersey.config.server.provider.packages",
                "eu.wodrobina");
        jerseyServlet.setInitParameter("javax.ws.rs.Application",
                "eu.wodrobina.AppConfig");
        jerseyServlet.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature",
                "true");
        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }
}
