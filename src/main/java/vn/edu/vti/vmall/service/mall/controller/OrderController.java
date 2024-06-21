package vn.edu.vti.vmall.service.mall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.vti.vmall.api.common.response.ApiResponse;
import vn.edu.vti.vmall.service.mall.payload.request.CreateOrderRequest;
import vn.edu.vti.vmall.service.mall.payload.response.CreateOrderResponse;
import vn.edu.vti.vmall.service.mall.service.OrderService;

@RestController
@RequestMapping(value = "/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
  private final OrderService orderService;
  @PostMapping
  public ResponseEntity<ApiResponse<CreateOrderResponse>> createNewOrder(
      @RequestBody CreateOrderRequest request
  ){
    return ResponseEntity.ok(ApiResponse.success(orderService.createNewOrder(request)));
  }
}
