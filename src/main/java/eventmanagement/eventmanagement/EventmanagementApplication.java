package eventmanagement.eventmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;


@SpringBootApplication
@ComponentScan(basePackages = "eventmanagement.eventmanagement",
		excludeFilters={@ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "eventmanagement.eventmanagement.exception.*")} )

public class EventmanagementApplication {


	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
	}

}
