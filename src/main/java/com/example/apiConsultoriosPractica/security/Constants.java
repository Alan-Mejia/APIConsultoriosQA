package com.example.apiConsultoriosPractica.security;

public class Constants {
    // Spring Security

    //public static final String LOGIN_URL = "";
    public static final String HEADER_AUTHORIZATION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    // JWT

    public static final String ISSUER_INFO = "https://atos.net/es-mx/mexico";
    public static final String SUPER_SECRET_KEY = "api-asincrona-practica-atos";
    public static final long TOKEN_EXPIRATION_TIME = 604_800_000; // 7 days



}
