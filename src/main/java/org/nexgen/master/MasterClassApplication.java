package org.nexgen.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "org.nexgen")
@EnableDiscoveryClient
@EntityScan(basePackages = {"org.nexgen.schema.entity"})
@EnableJpaRepositories(basePackages = {"org.nexgen.authorization.repository", "org.nexgen.master.repository"})
public class MasterClassApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterClassApplication.class, args);
	}

}
