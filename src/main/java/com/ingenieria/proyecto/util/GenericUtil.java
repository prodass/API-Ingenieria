package com.ingenieria.proyecto.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public final class GenericUtil {
    public String codigoGenerado(String prefijo){
        UUID uuid = UUID.randomUUID();
        return prefijo + "-" + uuid.toString();
    }
}
