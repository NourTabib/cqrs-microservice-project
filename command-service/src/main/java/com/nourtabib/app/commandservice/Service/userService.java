package com.nourtabib.app.commandservice.Service;

import com.nourtabib.app.commandservice.Entity.UserEntity;
import com.nourtabib.app.commandservice.EventHandler.EventHandler;
import com.nourtabib.app.commandservice.Repo.userRepository;
import com.nourtabib.app.commandservice.UserDomain.CreateEvent;
import com.nourtabib.app.commandservice.UserDomain.DeleteEvent;
import com.nourtabib.app.commandservice.UserDomain.UpdateEvent;
import com.nourtabib.app.commandservice.UserDomain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userService {

    private EventHandler eventHandler;
    private userRepository userRepository;
    @Autowired
    public userService(userRepository userRepository,EventHandler eventHandler){
        this.userRepository = userRepository;
        this.eventHandler = eventHandler;
    }
    public UserEntity createUser(User user){
        UserEntity saveUser = userRepository.save(new UserEntity(user.getFirstName(),
                                                                 user.getLastName(),
                                                                 user.getUsername(),
                                                                 user.getPassword()
        ));
        user.setId(saveUser.getId());
        CreateEvent event = new CreateEvent(user);
        eventHandler.publishEvent(event);
        return saveUser;

    }
    public UserEntity updateUser(User user){
        if(userRepository.findById(user.getId()).isPresent()){
            UserEntity saveUser = userRepository.save(new UserEntity(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getUsername(),
                    user.getPassword()
            ));
            UpdateEvent event = new UpdateEvent(user);
            eventHandler.publishEvent(event);
            return saveUser;
        }
        else return null;

    }
    public void deleteUser(Long id){
        Optional<UserEntity> deletedUser = userRepository.findById(id);
        if(deletedUser.isPresent()){
            User user = new User(
                    deletedUser.get().getId(),
                    deletedUser.get().getFirstName(),
                    deletedUser.get().getLastName(),
                    deletedUser.get().getUsername(),
                    deletedUser.get().getPassword()
            );
            DeleteEvent event = new DeleteEvent(user);
            eventHandler.publishEvent(event);
            return ;
        }

        return;
    }
}
