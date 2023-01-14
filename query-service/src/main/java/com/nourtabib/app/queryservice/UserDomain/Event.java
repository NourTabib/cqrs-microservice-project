package com.nourtabib.app.queryservice.UserDomain;

import java.util.Date;

public interface Event {
     String getType();
    default Date getCreatedDate(){
        return new Date();
    }

}
