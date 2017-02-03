package com.simple.transfromer.impl;

import com.liferay.portal.kernel.model.User;
import com.simple.model.UserView;
import com.simple.transfromer.Transformer;

public class UserViewTransformer implements Transformer<User, UserView> {

    @Override
    public UserView convert(User user) {
        UserView userView = new UserView();
        userView.setName(user.getFullName());
        userView.setEmail(user.getEmailAddress());
        return userView;
    }
}
