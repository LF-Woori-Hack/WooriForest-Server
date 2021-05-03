package com.forest.service;

import com.forest.CommonException;
import com.forest.model.entity.user.User;
import com.forest.model.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TestService {
    private UserRepository userRepository;

//    public User getUser(Long id) {
//        User user = new User();
//        if(user == null){
//            try {
//                throw new CommonException();
//            } catch (CommonException e) {
//                System.out.println("에러!!");
//                e.printStackTrace();
//            }
//        }
//        return user;
//    }
}

