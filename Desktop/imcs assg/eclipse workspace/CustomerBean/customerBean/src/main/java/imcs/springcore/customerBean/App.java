package imcs.springcore.customerBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class App 
{
	
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Myconfig.class);
		Customer customer=ctx.getBean(Customer.class);
		customer.display();
		
		ctx.close();
 }
}
