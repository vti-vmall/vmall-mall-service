package vn.edu.vti.vmall.service.mall.client.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import vn.edu.vti.vmall.api.common.exception.VMallException;
import vn.edu.vti.vmall.service.mall.exception.ExceptionEnum;

public class CustomErrorDecoder implements ErrorDecoder {

  private final ErrorDecoder defaultErrorDecoder = new Default();

  @Override
  public Exception decode(String s, Response response) {
    HttpStatus status = HttpStatus.valueOf(response.status());

    return switch (status) {
      case NOT_FOUND,
          BAD_REQUEST,
          UNAUTHORIZED,
          FORBIDDEN,
          INTERNAL_SERVER_ERROR ->
          new VMallException(ExceptionEnum.BAD_REQUEST);
      default -> defaultErrorDecoder.decode(s, response);
    };
  }
}
