package com.github.pengliangs.oauth.config;


import com.github.pengliangs.oauth.constant.SecurityConstants;
import com.github.pengliangs.oauth.handler.AuthenticationFailureHandler;
import com.github.pengliangs.oauth.handler.AuthenticationSuccessHandler;

import com.github.pengliangs.oauth.handler.MyAccessDeniedHandler;
import com.github.pengliangs.oauth.handler.MyAuthExceptionEntryPoint;
import com.github.pengliangs.oauth.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * 安全配置
 *
 * @author pengliang on 2018-07-25 17:13
 */
@Configuration
@EnableWebSecurity
public class Oauth2SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;


    /**
     * 配置如何通过拦截器保护请求
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
                http
                        .formLogin()
                        .loginPage(SecurityConstants.LOGIN_PAGE)
                        .loginProcessingUrl(SecurityConstants.AUTHENTICATION_FORM)
                        .successHandler(authenticationSuccessHandler)
                        .failureHandler(authenticationFailureHandler)
                        .and()
                        .exceptionHandling()
                        .accessDeniedHandler(new MyAccessDeniedHandler())
                        .authenticationEntryPoint(new MyAuthExceptionEntryPoint())
                        .and()
                        .authorizeRequests();

        registry.antMatchers(securityProperties.getIgnore().getUrls()).permitAll();

        registry.antMatchers(SecurityConstants.LOGIN_PAGE).permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    /**
     * 配置user-detail服务
     * auth.inMemoryAuthentication() .withUser("pengliang") .password(passwordEncoder().encode("123456")) .roles("read","admin","user");
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }


    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

/*    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/img/**", "/lib/**");
    }*/

}
