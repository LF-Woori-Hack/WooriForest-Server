package com.forest.service;

import com.forest.model.dto.request.ReqLoginDto;
import com.forest.model.dto.response.ResLoginDto;
import com.forest.model.entity.user.User;
import com.forest.model.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final UserRepository repository;

    public String save(ReqLoginDto reqLoginDto) {
        Optional<User> user = this.getUser(reqLoginDto.deviceId);
        if(user.isPresent()) {
            return user.get().token;
        } else {
            Long current = System.currentTimeMillis();
            String token = reqLoginDto.deviceId + Long.toString(current);
            this.repository.save(User.from(reqLoginDto, token));
            return token;
        }
    }

    public List<User> getUser() {
        List<User> user = this.repository.findAll();
        return user;
    }

    public User getUser(Long id) {
        Optional<User> user = this.repository.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return new User();
        }
    }

    public Optional<User> getUser(String deviceId) {
        Optional<User> user = this.repository.findByDeviceId(deviceId);
        return user;
    }

}
