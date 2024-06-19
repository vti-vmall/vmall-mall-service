package vn.edu.vti.vmall.service.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.vti.vmall.api.common.exception.EnableExceptionHandler;
import vn.edu.vti.vmall.security.config.EnableSecurityCommon;

@SpringBootApplication
@EnableSecurityCommon
@EnableExceptionHandler
public class VmallMallServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(VmallMallServiceApplication.class, args);
  }

}
