package app.springJPA.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;

@Builder
public record ProductRequest(
        @NotNull
        @NotEmpty
        String title,

        String description,
        String imageUrl,
        @Positive
        float price) {
}
