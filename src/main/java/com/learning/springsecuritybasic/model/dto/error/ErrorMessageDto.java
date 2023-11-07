package com.learning.springsecuritybasic.model.dto.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessageDto {
    private String errorMessage;
    private String technicalErrorMessage;
}
