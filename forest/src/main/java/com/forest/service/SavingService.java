package com.forest.service;

import com.forest.model.dto.request.ReqLoginDto;
import com.forest.model.dto.request.ReqSavingJoinDto;
import com.forest.model.dto.response.ResSavingDto;
import com.forest.model.entity.nest.NestRepository;
import com.forest.model.entity.saveMoney.SaveMoney;
import com.forest.model.entity.saveMoney.SaveMoneyRepository;
import com.forest.model.entity.user.User;
import com.forest.model.entity.user.UserRepository;
import com.forest.model.entity.userSaveMoney.UserSaveMoney;
import com.forest.model.entity.userSaveMoney.UserSaveMoneyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SavingService {

    private final UserRepository userRepository;
    private final SaveMoneyRepository saveMoneyRepository;
    private final UserSaveMoneyRepository userSaveMoneyRepository;

    public void save(ReqSavingJoinDto reqSavingJoinDto, String token) {

        Optional<User> user = this.userRepository.findByToken(token);
        SaveMoney saveMoney = SaveMoney.from(reqSavingJoinDto);
        this.saveMoneyRepository.save(saveMoney);

        if(user.isPresent()) {
            this.userSaveMoneyRepository.save(new UserSaveMoney(user.get().id, saveMoney.id));
        }
    }

    public ResSavingDto getSaveMoney(String token) {
        Optional<User> user = this.userRepository.findByToken(token);

        if(user.isPresent()) {
            UserSaveMoney userSaveMoney = this.userSaveMoneyRepository.findByUserId(user.get().id);

            Optional<SaveMoney> saveMoney = this.saveMoneyRepository.findById(userSaveMoney.saveMoneyId);

            if(saveMoney.isPresent()) {
                ResSavingDto resSavingDto = new ResSavingDto(saveMoney.get());
                return resSavingDto;
            }
        }
        return new ResSavingDto();
    }

}
