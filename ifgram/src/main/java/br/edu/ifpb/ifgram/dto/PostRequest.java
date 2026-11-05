package br.edu.ifpb.ifgram.dto;

import jakarta.validation.constraints.NotBlank;

public record PostRequest(
        @NotBlank
        String imagemUrl,

        ) {


}
