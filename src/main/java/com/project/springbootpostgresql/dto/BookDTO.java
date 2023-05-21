package com.project.springbootpostgresql.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    @NotBlank(message = "ID is mandatory")
    private String id;
    @NotBlank(message = "Title is mandatory")
    private String title;
    @NotBlank(message = "Author is mandatory")
    private String author;
    @NotBlank(message = "Category is mandatory")
    private String category;

    @NotNull(message = "Quantity is mandatory")
    @Positive(message = "Quantity must be greater than 0")
    private int quantity;

    @NotNull(message = "Price is mandatory")
    @Min(value = 1, message = "Price must be greater than 0")
    private float price;
}
