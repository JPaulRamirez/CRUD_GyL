package org.gyl.crudgyl.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
        int status,
        String error,
        String message
) {
}
