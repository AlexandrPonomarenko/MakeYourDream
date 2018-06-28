package com.validator;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator{

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User)o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty");
        if(user.getLogin().length() < 6 || user.getLogin().length() > 32){
            errors.rejectValue("login", "Size.userForm.login");
        }

        if(userService.findByLogin(user.getLogin())  != null){
            errors.rejectValue("login", "Duplicate.userForm.login");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if(user.getPassword().length() < 8 || user.getPassword().length() > 32){
            errors.rejectValue("password", "Size.userForm.password");
        }

        if(!(user.getPasswordTwo().equals(user.getPassword()))){
            errors.rejectValue("passwordTwo", "Diff.userForm.passwordTwo");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if(user.getName().length() < 3 || user.getName().length() > 32){
            errors.rejectValue("email", "Size.userForm.email");
        }

        if(userService.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email", "Duplicate.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if(user.getName().length() < 4 || user.getName().length() > 32){
            errors.rejectValue("name", "Size.userForm.name");
        }
    }
}
