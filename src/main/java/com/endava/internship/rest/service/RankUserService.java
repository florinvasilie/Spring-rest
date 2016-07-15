package com.endava.internship.rest.service;

import com.endava.internship.rest.model.RankUser;
import com.endava.internship.rest.model.User;
import com.endava.internship.rest.repository.RankUserRepository;
import com.endava.internship.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fvasile on 7/15/2016.
 */
@Service
public class RankUserService {
    @Autowired
    private RankUserRepository rankUserRepository;

    public List<RankUser> getRankUsers(){
        return rankUserRepository.list();
    }

    public RankUser getRankUser(Integer id){
        return this.rankUserRepository.getRankUser(id);
    }
    public void saveRankUser(RankUser rankUser){
        rankUserRepository.saveRankUser(rankUser);
    }
}
