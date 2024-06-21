package vn.edu.vti.vmall.service.mall.service;

import vn.edu.vti.vmall.service.mall.payload.request.CreateOrderRequest;
import vn.edu.vti.vmall.service.mall.payload.response.CreateOrderResponse;

public interface OrderService {
  CreateOrderResponse createNewOrder(CreateOrderRequest request);
}
