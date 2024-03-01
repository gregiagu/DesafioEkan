package io.github.gregiagu.ekan.faults;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RecipientNotFoundFault {
    private int status;
    private String message;
    private long timestamp;
}
