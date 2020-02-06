package com.hugeyurt.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.hugeyurt.util.OnLineNumber;

/**
 * Application Lifecycle Listener implementation class OnLineCountListener
 *
 */
@WebListener
public class OnLineCountListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public OnLineCountListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("one session created");
    	OnLineNumber.counter.incrementAndGet();
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("one session destroyed");
    	OnLineNumber.counter.decrementAndGet();
    }
	
}
