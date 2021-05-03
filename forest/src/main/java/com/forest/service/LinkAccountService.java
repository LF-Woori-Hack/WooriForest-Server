package com.forest.service;

import com.forest.model.dto.request.ReqLinkAccountDto;
import com.forest.model.dto.request.ReqLoginDto;
import com.forest.model.dto.response.ResLinkAccountDto;
import com.forest.model.entity.habit.Habit;
import com.forest.model.entity.habit.HabitRepository;
import com.forest.model.entity.user.User;
import com.forest.model.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LinkAccountService {

    private final UserRepository userRepository;
    private final HabitRepository habitrepository;

    @Transactional
    public List<ResLinkAccountDto> save(ReqLinkAccountDto reqLinkAccountDto, String token) throws NoSuchElementException {
        Optional<User> user = this.getUser(token);

        if (user.isPresent()) {
            User newUser = this.userRepository.save(new User(user.get(), reqLinkAccountDto));
        }

        List<ResLinkAccountDto> resLinkAccountDtoList = new ArrayList<>();

        for(Integer index=2; index <= 3; index++) {
            Habit habit = this.getHabit(Integer.toUnsignedLong(index));
            ResLinkAccountDto resLinkAccountDto = new ResLinkAccountDto(habit);
            resLinkAccountDtoList.add(resLinkAccountDto);
        }

        return resLinkAccountDtoList;
    }

    public Optional<User> getUser(String token) {
        return this.userRepository.findByToken(token);
    }

    public Habit getHabit(Long id) {
        Optional<Habit> habit = this.habitrepository.findById(id);
        if(habit.isPresent()) {
            return habit.get();
        } else {
            return new Habit();
        }
    }

}
