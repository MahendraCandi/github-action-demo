package com.mahendracandi.github_actions_demo.dtos;

import lombok.*;

@Getter
@Setter
public class ResultDto {
    private String message;
    private PropertiesDto testProperties;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PropertiesDto {
        private String url;
        private String username;
        private String password;

    }
}
