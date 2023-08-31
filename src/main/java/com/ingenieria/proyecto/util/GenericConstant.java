package com.ingenieria.proyecto.util;

public class GenericConstant {
    // =============================================================================================
    // CODIGO DE ERROR DEL CLIENTE Y SERVIDOR
    // =============================================================================================
    // CLIENT ERRORS
    public static final String BAD_REQUEST = "400";
    public static final String UNAUTHORIZED = "401";
    public static final String FORBIDDEN = "403";
    public static final String NOT_FOUND = "404";
    public static final String METHOD_NOT_ALLOWED = "405";
    public static final String NOT_ACCEPTABLE = "406";
    public static final String CONFLICT = "409";
    public static final String UNPROCESSABLE_ENTITY = "422";
    public static final String EXPECTATION_FAILED = "417";
    public static final Float NR_VUELTO_DEFAULT = (float) 0;

    // SERVER ERRORS
    public static final String INTERNAL_SERVER_ERROR = "500";
    public static final String NOT_IMPLEMENTED = "501";
    public static final String BAD_GATEWAY = "503";
    public static final String SERVICE_UNAVAILABLE = "504";
    public static final String GATEWAY_TIMEOUT = "505";
    public static final String NOT_VALIDATED = "506";

    // ERRORS
    public static final String PREFIX_SERVER_ERROR = "SRV-";
    public static final String PREFIX_CLIENT_ERROR = "CLI-";

    // STATE
    public static final String STATE_ACTIVE = "1";
    public static final String STATE_INACTIVE = "0";


    // =============================================================================================
    // DATABASE
    // =============================================================================================
    public static final String SCHEMA_NAME = "proyecto_ingenieria";
    public static final String TAB_NAME_PRODUCTOS = "productos";

    // =============================================================================================
    // API
    // =============================================================================================
    public static final String API_VERSION = "/v1";
    public static final String RESOURCE_GENERIC = API_VERSION + "/reconocimiento-productos";
    public static final String RESOURCE_GENERIC_ID = "/{id}";

    public static final String RESOURCE_PRODUCTOS = "/productos";
    public static final String RESOURCE_PRODUCTOS_CODIGO = RESOURCE_PRODUCTOS + "/{codigo}";

}