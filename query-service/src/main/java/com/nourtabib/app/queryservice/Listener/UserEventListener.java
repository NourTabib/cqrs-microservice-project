package com.nourtabib.app.queryservice.Listener;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nourtabib.app.queryservice.Entity.UserEntity;
import com.nourtabib.app.queryservice.Repository.UserRepository;
import com.nourtabib.app.queryservice.UserDomain.CreateEvent;
import com.nourtabib.app.queryservice.UserDomain.DeleteEvent;
import com.nourtabib.app.queryservice.UserDomain.UpdateEvent;
import com.nourtabib.app.queryservice.UserDomain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserEventListener {


    private static final Logger LOGGER = LoggerFactory.getLogger(
            UserEventListener.class
    );
    private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;

    private final UserRepository userRepository;

    @Autowired
    public UserEventListener(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "${kafka.topic.name}",groupId = "query-service")
    void listener(String message){
        try{
            Map<String,String> userEvent = objectMapper.readValue(message,Map.class);
            if(userEvent.get("type").equals("CREATE")){
                CreateEvent createUserEvent = objectMapper.readValue(message,CreateEvent.class);
                User user = createUserEvent.getUser();
                UserEntity saveUser = new UserEntity(
                        user.getId(),
                        user.getUsername(),
                        user.getPassword(),
                        user.getFirstName(),
                        user.getLastName()
                        );
                userRepository.save(saveUser);
            } else if (userEvent.get("type").equals("UPDATE")) {
                UpdateEvent updateUserEvent = objectMapper.readValue(message,UpdateEvent.class);
                User user = updateUserEvent.getUser();
                if(userRepository.findById(user.getId()).isPresent()){
                    String docId = userRepository.findById(user.getId()).get().get_id();;
                    UserEntity saveUser = new UserEntity(
                            docId,
                            user.getId(),
                            user.getUsername(),
                            user.getPassword(),
                            user.getFirstName(),
                            user.getLastName()
                    );
                    userRepository.save(saveUser);
                }else{
                    System.out.println("User Doesnt Exist");
                }

            }else if (userEvent.get("type").equals("DELETE")) {
                DeleteEvent deleteUserEvent = objectMapper.readValue(message,DeleteEvent.class);
                User user = deleteUserEvent.getUser();
                userRepository.deleteById(user.getId());
            }else{
                System.out.println("Unknown Event Type");
            }
        }catch(Exception e){
            LOGGER.error("UserListener Exception",e);
        }
    }
}
