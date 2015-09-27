package za.ac.cput.AshDyani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 *
 */
//@SpringBootApplication
@Configuration
@ComponentScan
@EnableWebMvc
@EnableAutoConfiguration
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!\nThis is a VetShop Application" );
        SpringApplication.run(App.class, args);
    }
}
