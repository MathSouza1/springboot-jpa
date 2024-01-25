package com.matheuscardoso.course.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StandardException implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD-MM-YYYY'T'HH:mm:ss'Z'", timezone = "GMT-3")
    private Instant timeStamp;
    private Integer status;
    private String error;
    private String message;
}
