package SpingTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hugeyurt.test.First;

public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		String[] locations = {"bean1.xml"};    
	    ApplicationContext ctx = new ClassPathXmlApplicationContext(locations); 
	    First fi=(First)   ctx.getBean("first");
	    fi.say();
	    

	}

}
