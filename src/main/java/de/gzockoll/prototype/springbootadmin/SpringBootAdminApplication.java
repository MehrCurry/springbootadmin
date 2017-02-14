package de.gzockoll.prototype.springbootadmin;

import com.hazelcast.config.*;
import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAdminServer
public class SpringBootAdminApplication {

	public static void main(String[] args) {
	    SpringApplication.run(SpringBootAdminApplication.class, args);
	}

	@Bean
	public Config hazelcastConfig() {
		Config config = new Config().setProperty("hazelcast.jmx", "true")
				.addMapConfig(new MapConfig("spring-boot-admin-application-store").setBackupCount(1)
						.setEvictionPolicy(EvictionPolicy.NONE))
				.addListConfig(new ListConfig("spring-boot-admin-event-store").setBackupCount(1)
						.setMaxSize(1000));
		JoinConfig join = config.getNetworkConfig().getJoin();
		join.getMulticastConfig().setEnabled(false);
		join.getTcpIpConfig().setEnabled(true);
		join.getTcpIpConfig().addMember("springbootadmin");

		return config;

	}
}
