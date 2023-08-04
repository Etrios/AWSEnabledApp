package com.ganesh.personal.AWSEnabledApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestAwsEnabledAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(AwsEnabledAppApplication::main).with(TestAwsEnabledAppApplication.class).run(args);
	}

}
