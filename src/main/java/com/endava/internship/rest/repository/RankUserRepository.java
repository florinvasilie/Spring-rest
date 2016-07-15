package com.endava.internship.rest.repository;

import com.endava.internship.rest.model.RankUser;
import com.endava.internship.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fvasile on 7/15/2016.
 */
@Repository
public class RankUserRepository {
    @Autowired
    private UserRepository userRepository;
    private List<RankUser> rankUsers = new ArrayList<>();

    public List<RankUser> list(){
        return this.rankUsers;
    }
    public void saveRankUser(RankUser rankUser){
        rankUsers.add(rankUser);
    }
    public RankUser getRankUser(Integer id){
        for (RankUser user : list()){
            if(id==user.getId()) return user;
        }
        return null;
    }
    @PostConstruct
    public void init(){
        User user1=new User(1,"Florin");
        User user2=new User(2,"Paul");
        List<User> users=userRepository.list();
        users.add(user1);
        users.add(user2);
        List<User> users1=new ArrayList<>();
        User user3=new User(1,"Florin");
        User user4=new User(2,"Paul");
        users1.add(user3);
        users1.add(user4);

        RankUser rankUser1=new RankUser(users,1,"admin");

        List<User> rank=rankUser1.getUsers();
        for(User user:rank) {
            System.out.println(user.getUsername()+user.getId());
        }
    }
}
