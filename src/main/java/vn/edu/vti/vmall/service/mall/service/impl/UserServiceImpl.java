package vn.edu.vti.vmall.service.mall.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.edu.vti.vmall.api.common.payload.service.user.response.UserInfoResponse;
import vn.edu.vti.vmall.api.common.response.ApiResponse;
import vn.edu.vti.vmall.service.mall.client.UserClient;
import vn.edu.vti.vmall.service.mall.service.UserService;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserClient userClient;
  @Override
//  @CircuitBreaker(
//      name = "UserServiceImpl_getUserInfoByUsername",
//      fallbackMethod = "fallback"
//  )
  public UserInfoResponse getUserInfoByUsername(String username) {
    ResponseEntity<ApiResponse<UserInfoResponse>> userInfoResponse = userClient.getUserInfoByUsername(username);
    ApiResponse<UserInfoResponse> response = userInfoResponse.getBody();
    if(Objects.isNull(response)){
      log.warn("(getUserInfoByUsername)Api response is null for username: [{}]",
          username);
      return null;
    }
    return response.getData();
  }

  public UserInfoResponse fallback(Throwable e){
    log.warn("(fallback)When calling to userService to get userInfo by username with exception: [{}]",
        e.getMessage());
    var userRes = new UserInfoResponse();
    userRes.setPhone("fallback");
    return userRes;
  }
}
