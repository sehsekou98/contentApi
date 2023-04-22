package Contentapi.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;


import java.time.LocalDateTime;

public record Content(
        @Id
        Integer id,
        @NotBlank
        String title,
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {

}
