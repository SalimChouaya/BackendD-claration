package com.PrixDeTransfert.Backend.dto;

public record SignUpDto (String firstName, String lastName, String login, char[] password) { }