package com.project.springbootpostgresql.dto;

import jakarta.validation.constraints.*;
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
    @Size(min = 5, max = 30, message = "Category must be between 10 and 200 characters")
    private String category;
    @Positive(message = "Quantity must be greater than 0")
    private int quantity;

    @Min(value = 10, message = "Price should not be less than 10.")
    @Max(value = 150, message = "Price should not be greater than 10000.")
    private float price;


}
