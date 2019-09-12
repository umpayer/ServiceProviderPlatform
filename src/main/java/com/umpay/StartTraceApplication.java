package com.umpay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
//@ComponentScan({"com.umpay"})
@EnableScheduling // 启动定时任务配置
public class StartTraceApplication {
	private static final Logger log = LoggerFactory.getLogger(StartTraceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(StartTraceApplication.class, args);
	}

}
