package com.forest.service;

import com.forest.model.dto.response.ResNestDetailDto;
import com.forest.model.entity.nest.Nest;
import com.forest.model.entity.nest.NestRepository;
import com.forest.model.entity.user.User;
import com.forest.model.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NestService {

    private final NestRepository nestRepository;
    private final UserRepository userRepository;

    public List<ResNestDetailDto> getNestList(Long id) {
        List<ResNestDetailDto> resNestDetailDtoList = new ArrayList<>();
        List<Nest> nestList = this.nestRepository.findAllByHabitId(id);
        for (Iterator<Nest> itr = nestList.iterator(); itr.hasNext();) {
            ResNestDetailDto resNestDetailDto = new ResNestDetailDto(itr.next());
            resNestDetailDtoList.add(resNestDetailDto);
        }
        return resNestDetailDtoList;
    }

    public void join(Long id, String token) {
        Optional<Nest> nest = this.nestRepository.findById(id);

        if(nest.isPresent()) {
            Long nestId = nest.get().id;
            Long habitId = nest.get().habitId;

            Optional<User> user = this.userRepository.findByToken(token);

            if(user.isPresent()) {
                this.userRepository.save(User.from(user.get(), habitId, nestId));
            }
        }
    }

}
