package vn.edu.vti.vmall.service.mall.service.impl;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.vti.vmall.api.common.exception.VMallException;
import vn.edu.vti.vmall.service.mall.exception.ExceptionEnum;
import vn.edu.vti.vmall.service.mall.payload.request.CreateOrderRequest;
import vn.edu.vti.vmall.service.mall.payload.response.CreateOrderResponse;
import vn.edu.vti.vmall.service.mall.service.OrderService;
import vn.edu.vti.vmall.service.mall.service.UserService;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
  private final UserService userService;
  @Override
  @RateLimiter(name = "simpleRateLimit")
  public CreateOrderResponse createNewOrder(CreateOrderRequest request) {
    var response = new CreateOrderResponse();
    try {
      var userResponse = userService.getUserInfoByUsername(request.getUsername());
      assert userResponse != null;
      response.setUsername(userResponse.getPhone());
      return response;
    }catch (Exception e){
      log.error("(createNewOrder)Exception with message: [{}] and stackTrace: [{}]",
          e.getMessage(),
          e.getStackTrace());
      throw new VMallException(ExceptionEnum.BAD_REQUEST);
    }
  }
}
