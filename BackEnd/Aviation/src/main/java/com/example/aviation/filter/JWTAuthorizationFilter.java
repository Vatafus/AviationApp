//package com.example.aviation.filter;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.example.aviation.helper.JWTHelper;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.resource.spi.work.SecurityContext;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//
//import static com.example.aviation.constant.JWTUtil.AUTH_HEADER;
//import static com.example.aviation.constant.JWTUtil.SECRET;
//
//public class JWTAuthorizationFilter extends OncePerRequestFilter {
//
//    private JWTHelper jwtHelper;
//
//    public JWTAuthorizationFilter(JWTHelper jwtHelper) {
//        this.jwtHelper = jwtHelper;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String accesstToken = jwtHelper.extractTokenFromHeaderIfExists(request.getHeader(AUTH_HEADER));
//        if(accesstToken != null){
//            Algorithm algorithm = Algorithm.HMAC256(SECRET);
//            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
//            DecodedJWT decodedJWT = jwtVerifier.verify(accesstToken);
//            String email = decodedJWT.getSubject();
//            String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
//            Collection<GrantedAuthority> authorities = new ArrayList<>();
//            for(String role : roles){
//                authorities.add(new SimpleGrantedAuthority(role));
//            }
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,null,authorities);
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            filterChain.doFilter(request,response);
//        }
//        else{
//            filterChain.doFilter(request,response);
//        }
//    }
//}
