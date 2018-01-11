package com.shawn.finger.dao;

import com.shawn.finger.vo.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

    UserVO getById(String userId);
}
