package com.ms.email.dto;

import java.util.UUID;

public record EmailRecordDt0(UUID userId,
                             String emailTo,
                             String subject,
                             String text) {
}
