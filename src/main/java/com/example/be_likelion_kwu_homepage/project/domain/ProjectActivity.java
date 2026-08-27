package com.example.be_likelion_kwu_homepage.project.domain;
import java.util.Arrays;
public enum ProjectActivity {
    IDEATHON("아이디어톤"), CENTRAL_HACKATHON("중앙해커톤"), REGIONAL_HACKATHON("권역별 연합해커톤");
    private final String value;
    ProjectActivity(String value) { this.value = value; }
    public String getValue() { return value; }
    public static ProjectActivity from(String value) { return Arrays.stream(values()).filter(a -> a.value.equals(value)).findFirst().orElseThrow(() -> new IllegalArgumentException("Unsupported activity")); }
}
