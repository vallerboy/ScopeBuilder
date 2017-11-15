package pl.oskarpolak.springsec.models;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component // @Component = @Service = @Configuration = @Bean = @Repostiory
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User {
    private String name;

    public User() {
        name = "PAWEL";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
