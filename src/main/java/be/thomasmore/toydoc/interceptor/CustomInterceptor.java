package be.thomasmore.toydoc.interceptor;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomInterceptor implements HandlerInterceptor {

    private final AppUserRepository userRepository;

    @Autowired
    public CustomInterceptor(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            System.out.println("Principal class: " + principal.getClass().getName());
            if (principal instanceof UserDetails) {
                String loginName = ((UserDetails) principal).getUsername();
                request.setAttribute("loginName", loginName);
                System.out.println("LoginName CI: " + loginName);


//                if (principal instanceof AppUser) {
//                    System.out.println("APPUSER IS INSTANCE OF PRINCIPAL");
//                    AppUser appUser = (AppUser) principal;
//                    String firstName = appUser.getFirstName();
//                    System.out.println("FirstName: " + firstName);
//                    request.setAttribute("firstName", firstName);
//                }
//
                    // If the principal is not an instance of AppUser, fetch the AppUser from the repository
                    AppUser appUser = userRepository.findByUsername(loginName);
                    if (appUser != null) {
                        System.out.println("FETCHED PRINCIPAL FROM REP");
//                        String firstName = appUser.getFirstName();
//                        System.out.println("FirstName: " + firstName);
//                        request.setAttribute("firstName", firstName);
                        request.setAttribute("appUser", appUser);
                    }

            }
        }

        return true;
    }
}
