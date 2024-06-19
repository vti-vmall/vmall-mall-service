package vn.edu.vti.vmall.service.mall.exception;

import org.springframework.http.HttpStatus;
import vn.edu.vti.vmall.api.common.exception.VMallExceptionInfo;

public enum ExceptionEnum implements VMallExceptionInfo {
  BAD_REQUEST(
      "BAD_REQUEST",
      "Bad request",
      HttpStatus.BAD_REQUEST
  );

  private final String errorCode;
  private final String errorDescription;
  private final HttpStatus httpStatus;

  ExceptionEnum(String errorCode, String errorDescription, HttpStatus httpStatus) {
    this.errorCode = errorCode;
    this.errorDescription = errorDescription;
    this.httpStatus = httpStatus;
  }

  @Override
  public String getErrorCode() {
    return errorCode;
  }

  @Override
  public String getErrorDescription() {
    return errorDescription;
  }

  @Override
  public HttpStatus getHttpStatus() {
    return httpStatus;
  }
}
