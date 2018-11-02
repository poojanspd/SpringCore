package imcs.springcore.customerBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myconfig {

	@Bean
	public Customer customer() {
		return new Customer();
	}
}
