package com.bike.admin.kernel;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 应用启动的时候如果要做一些动作，那就写在这里。
 * 
 * @author Cony
 */
public class ApplicationStartupListener implements ServletContextListener {

    protected static final Log log = LogFactory.getLog(ApplicationStartupListener.class);

    /**
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event) {
        if (log.isDebugEnabled()) {
            log.debug("Servlet context destroyed");
        }
        // 这里等你来填
    }

    /**
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
        if (log.isDebugEnabled()) {
            log.debug("Servlet context initialized");
        }
    }

}
