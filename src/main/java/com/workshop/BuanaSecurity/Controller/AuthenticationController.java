package com.workshop.BuanaSecurity.Controller;

import com.workshop.BuanaSecurity.Dao.UserDao;
import com.workshop.BuanaSecurity.Dto.AuthenticationRequest;
import com.workshop.BuanaSecurity.Statval.IApplicationConstant;
import com.workshop.BuanaSecurity.Config.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(IApplicationConstant.ApplicationContext.AUTHENTICATION.AUTH)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtils jwtUtils;

    @PostMapping(IApplicationConstant.ENDPOINT.AUTHENTICATE)
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
      final UserDetails user = userDao.findByUserEmail(authenticationRequest.getEmail());
      if (user != null ) {
         return ResponseEntity.ok(jwtUtils.generateToken(user));
     }
         return ResponseEntity.status(400).body("Some error has occurred");
    }
}
