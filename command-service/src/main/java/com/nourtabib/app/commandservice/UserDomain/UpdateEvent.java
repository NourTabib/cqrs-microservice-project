package com.nourtabib.app.commandservice.UserDomain;

public class UpdateEvent implements Event{
    private User user;
    @Override
    public String getType() {
        return "UPDATE";
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public UpdateEvent() {
    }

    public UpdateEvent(User user) {
        this.user = user;
    }
}
