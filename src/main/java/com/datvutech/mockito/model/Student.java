package com.datvutech.mockito.model;

public class Student {
    private String username;

    private String fullName;

    private String password;

    private String transcript;

    private boolean enrolled;

    public Student() {
    }

    public Student(String username, String fullName, String password, String transcript, boolean enrolled) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.transcript = transcript;
        this.enrolled = enrolled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public void setEnrolled(boolean enroled) {
        this.enrolled = enroled;
    }
}
