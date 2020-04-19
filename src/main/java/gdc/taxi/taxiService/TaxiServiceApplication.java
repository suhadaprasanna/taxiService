package gdc.taxi.taxiService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(value= {"gdc"})
@EntityScan("gdc.taxi.datamanager")
@EnableJpaRepositories("gdc.taxi.datamanager")
public class TaxiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxiServiceApplication.class, args);
	}

}
