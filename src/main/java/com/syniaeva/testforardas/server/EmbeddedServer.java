package com.syniaeva.testforardas.server;


import com.syniaeva.testforardas.controller.GreetingController;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * The class creates and runs an application on the Jetty-server
 *
 * @author osyniaev
 */
public final class EmbeddedServer {

    private static final int SERVER_PORT = 7777;
    private static String contextPath = "/";

    public static void main(String[] args) throws Exception {
        Server jettyServer = new Server(SERVER_PORT);
        ServerConnector http = new ServerConnector(jettyServer);
        jettyServer.addConnector(http);
        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        ServletHolder jerseyServlet = servletContextHandler.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);
        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", GreetingController.class.getCanonicalName());

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{servletContextHandler});
        jettyServer.setHandler(handlers);

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }
}

