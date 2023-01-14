package com.nourtabib.app.commandservice.UserDomain;

public class DeleteEvent implements Event{
    private User user;

    public DeleteEvent() {
    }

    public DeleteEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String getType() {
        return "DELETE";
    }
}
