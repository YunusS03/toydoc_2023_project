package be.thomasmore.toydoc.services;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Role;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser save(AppUser appUser){
        return appUserRepository.save(appUser);
    }
    public Optional<AppUser> findByEmail(String email){
        return appUserRepository.findByEmail(email);
    }
}
