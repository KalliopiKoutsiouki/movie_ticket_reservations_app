package com.papei.movie_ticket_reservations.controller;

//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.gson.GsonFactory;
import com.papei.movie_ticket_reservations.model.security.AuthRequest;
import com.papei.movie_ticket_reservations.pojo.dto.TokenDto;
import com.papei.movie_ticket_reservations.pojo.dto.UrlDto;
import com.papei.movie_ticket_reservations.service.impl.JwtService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;

@CrossOrigin(maxAge = 3600)
@RestController
//@SecurityRequirement(name = "Authorization")
@RequestMapping({"/auth"})
public class AuthController {

//    @Value("${spring.security.oauth2.resourceserver.opaque-token.client-id}")
//    private String clientId
//            = "409672159858-77ue31tdiduh4r0ap8o1vb1moud74p9r.apps.googleusercontent.com";
//
//
////    @Value("${spring.security.oauth2.resourceserver.opaque-token.client-secret")
//    private String clientSecret = "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";

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    //this is the backend acting as client that sends the url for google auth from google
    // to the front end
    //GOOGLE AUTH
//    @GetMapping("/url")
//    public ResponseEntity<UrlDto> auth() {
//       String url = new GoogleAuthorizationCodeRequestUrl(
//                clientId,
//                "http://localhost:4200",
//                Arrays.asList("email","profile", "openid"))
//                .build();
//       return ResponseEntity.ok(new UrlDto(url));
//    }

    // backend executes a callback to google to receive the token using the code
    // from the post-authentication params in url in front.
    // GOOGLE AUTH
//    @GetMapping("/callback")
//    public ResponseEntity<TokenDto> callback(@RequestParam("code") String code) {
//        String token;
//        try {
//           token =  new GoogleAuthorizationCodeTokenRequest(
//                    new NetHttpTransport(),
//                    new GsonFactory(),
//                    clientId,
//                    clientSecret,
//                    code.substring(1),
//                    "http://localhost:4200")
//                    .execute().getAccessToken();
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//        return ResponseEntity.ok(new TokenDto(token));
//    }


    @GetMapping("/user/userProfile")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }



}
