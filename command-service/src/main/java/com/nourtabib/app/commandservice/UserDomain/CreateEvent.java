package com.nourtabib.app.commandservice.UserDomain;

public class CreateEvent implements Event{
    private User user;

    public CreateEvent(User user) {
        this.user = user;
    }

    public CreateEvent() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getType() {
        return "CREATE";
    }
}
