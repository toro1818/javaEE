package bjtu.ebookshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import bjtu.ebookshop.security.MyAuthenticationProvider;
import bjtu.ebookshop.security.PasswordEncoderImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用方法级别的权限认证
public class securityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    MyAuthenticationProvider myAuthenticationProvider;


    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/bower_components/**", "/dist/**", "/plugins/**"); //write your resource directory name
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/index")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/login","/index").permitAll()
                .antMatchers("/bookList").hasAuthority("normal")
                .antMatchers("/book/{id}/delete").hasAuthority("admin")
                .antMatchers("/book/{id}/edit").hasAuthority("admin")
                .antMatchers("/bookList/add").hasAuthority("admin")
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies(
                        "JSESSIONID"
                );
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(myAuthenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PasswordEncoderImpl();
    }
}
