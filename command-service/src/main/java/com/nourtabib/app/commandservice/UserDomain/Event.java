package com.nourtabib.app.commandservice.UserDomain;

import java.util.Date;

public interface Event {
     String getType();
    default Date getCreatedDate(){
        return new Date();
    }

}
