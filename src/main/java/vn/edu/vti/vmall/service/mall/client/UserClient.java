package vn.edu.vti.vmall.service.mall.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.vti.vmall.api.common.payload.service.user.response.UserInfoResponse;
import vn.edu.vti.vmall.api.common.response.ApiResponse;

@FeignClient(name = "VMALL-USER-MANAGER")
public interface UserClient {
  @GetMapping("/api/v1/internal/users/{username}")
  ResponseEntity<ApiResponse<UserInfoResponse>> getUserInfoByUsername(
      @PathVariable String username
  );
}
