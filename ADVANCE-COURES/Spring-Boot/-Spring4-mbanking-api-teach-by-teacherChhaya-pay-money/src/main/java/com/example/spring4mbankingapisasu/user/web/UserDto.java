package com.example.spring4mbankingapisasu.user.web;

import lombok.Builder;
public record UserDto(String name , String gender, String studentCard,Boolean isStudent ) {

}
