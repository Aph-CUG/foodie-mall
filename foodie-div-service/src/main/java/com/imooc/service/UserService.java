package com.imooc.service;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import org.springframework.stereotype.Service;


public interface UserService {
    public boolean queryUsernameIsExist(String username);

    /*
     创建用户
     */
    public Users createUser(UserBO userBO);
}
