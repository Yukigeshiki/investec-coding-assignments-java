package io.robothouse.codingassignments.assignmenttwo.DTOs;

import jakarta.validation.constraints.NotNull;

public record ProvinceOrStateDTO(@NotNull String code, @NotNull String name) {
}
