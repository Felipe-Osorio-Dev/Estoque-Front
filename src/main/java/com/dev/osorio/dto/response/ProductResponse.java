package com.dev.osorio.dto.response;

import java.time.LocalDate;

public record ProductResponse(String codProduct, String name, Integer unit, LocalDate validate) {
}
