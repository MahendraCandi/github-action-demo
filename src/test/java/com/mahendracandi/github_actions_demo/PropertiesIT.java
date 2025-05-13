package com.mahendracandi.github_actions_demo;

import com.mahendracandi.github_actions_demo.properties.DatabaseProperties;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PropertiesIT {

    @Autowired
    private DatabaseProperties properties;

    @Test
    @DisplayName("Test properties injection from Github Env")
    void testPropertiesInjection() {
        Assertions.assertThat(properties.getUrl()).isEqualTo("localhost");
        Assertions.assertThat(properties.getUsername()).isEqualTo("user");
        Assertions.assertThat(properties.getPassword()).isEqualTo("password");
    }
}
