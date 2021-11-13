package softuni.angular.services;

import softuni.angular.exception.GlobalBadRequest;
import softuni.angular.exception.GlobalServiceException;
import softuni.angular.views.user.UserLoginInView;
import softuni.angular.views.user.UserLoginOutView;
import softuni.angular.views.user.UserRegisterInView;
import softuni.angular.views.user.UserTableOutView;

import java.util.List;

/**
 * Project: backend
 * Created by: GKirilov
 */
public interface UserService {
    void register(UserRegisterInView inView) throws GlobalServiceException;

    List<UserLoginOutView> login(UserLoginInView inView) throws GlobalServiceException;

    List<UserTableOutView> getAll() throws GlobalServiceException;

    void addRemoveAdminRole(Long id) throws GlobalServiceException, GlobalBadRequest;

    void deleteUserByUserId(Long id) throws GlobalServiceException, GlobalBadRequest;
}
