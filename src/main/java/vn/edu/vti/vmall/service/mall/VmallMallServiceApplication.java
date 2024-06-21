package vn.edu.vti.vmall.service.mall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import vn.edu.vti.vmall.api.common.exception.EnableExceptionHandler;
import vn.edu.vti.vmall.security.config.EnableSecurityCommon;
import vn.edu.vti.vmall.service.mall.client.UserClient;

@SpringBootApplication
@EnableSecurityCommon
@EnableExceptionHandler
@EnableFeignClients
@Slf4j
public class VmallMallServiceApplication implements CommandLineRunner {
  public static void main(String[] args) {
    SpringApplication.run(VmallMallServiceApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

  }
}
