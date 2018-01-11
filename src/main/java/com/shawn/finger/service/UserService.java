package com.shawn.finger.service;



import com.shawn.finger.dao.UserDAO;
import com.shawn.finger.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceMybatis")
public class UserService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDAO lotteryInfoDAO;


    public UserVO getById(String id){
        return lotteryInfoDAO.getById(id);
    }



}
