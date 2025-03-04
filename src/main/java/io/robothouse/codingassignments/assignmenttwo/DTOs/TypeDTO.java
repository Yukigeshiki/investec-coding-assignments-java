package io.robothouse.codingassignments.assignmenttwo.DTOs;

import jakarta.validation.constraints.NotNull;

public record TypeDTO(@NotNull String code, @NotNull String name) {
}
