//package com.papei.movie_ticket_reservations.config;
//
//import com.papei.movie_ticket_reservations.pojo.dto.UserDto;
//import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
//import org.springframework.security.oauth2.server.resource.introspection.OAuth2IntrospectionAuthenticatedPrincipal;
//import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class GoogleOpaqueTokenIntrospector implements OpaqueTokenIntrospector {
//
//    private final WebClient userInfoClient;
//
//    public GoogleOpaqueTokenIntrospector(WebClient userInfoClient) {
//        this.userInfoClient = userInfoClient;
//    }
//
//    @Override
//    public OAuth2AuthenticatedPrincipal introspect(String token) {
//       UserDto user =  userInfoClient.get()
//                .uri(uriBuilder -> uriBuilder.path("/oauth2/v2/userinfo").queryParam("access_token", token).build())
//                .retrieve()
//                .bodyToMono(UserDto.class)
//                .block();
//       Map<String, Object> attributes = new HashMap<>();
//       attributes.put("sub", user.getSub());
//       attributes.put("name", user.getName());
//       return new OAuth2IntrospectionAuthenticatedPrincipal(user.getName(), attributes, null);
//    }
//
//}
