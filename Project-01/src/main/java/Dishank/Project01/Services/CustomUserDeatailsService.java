//package Dishank.Project01.Services;
//
//import Dishank.Project01.Configurations.CustomUserDetails;
//import Dishank.Project01.Entity.User;
//import Dishank.Project01.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDeatailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user= userRepository.findByEmail(email);
//        if(user==null){
//            throw new UsernameNotFoundException("Email not found!");
//        }
//        return new CustomUserDetails(user);
//    }
//}
