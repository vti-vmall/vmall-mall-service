package vn.edu.vti.vmall.service.mall.service;

import vn.edu.vti.vmall.api.common.payload.service.user.response.UserInfoResponse;

public interface UserService {
  UserInfoResponse getUserInfoByUsername(String username);
}
