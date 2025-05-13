package com.mahendracandi.github_actions_demo.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(value = "database.properties.db")
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseProperties {
    private String url;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "DatabaseProperties{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
