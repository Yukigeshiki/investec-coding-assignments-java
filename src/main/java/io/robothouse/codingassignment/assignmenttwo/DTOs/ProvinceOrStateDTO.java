package io.robothouse.codingassignment.assignmenttwo.DTOs;

import jakarta.validation.constraints.NotNull;

public record ProvinceOrStateDTO(@NotNull String code, @NotNull String name) {
}
