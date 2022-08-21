package com.oww.OhWoonWanBackend;

import com.sun.xml.bind.v2.TODO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing		// Jpa Auditing 활성화
@SpringBootApplication
public class OhWoonWanBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OhWoonWanBackendApplication.class, args);
	}


	// TODO: Ctrl + alt + l 자동 정리
}
