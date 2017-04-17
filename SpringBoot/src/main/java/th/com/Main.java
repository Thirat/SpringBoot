package th.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Main 
{
	@RequestMapping("/")
	public String hello(){
		return "Hello from the other side";
	}
	
    public static void main( String[] args )
    {
    	SpringApplication.run(Main.class, args);
    }
}
