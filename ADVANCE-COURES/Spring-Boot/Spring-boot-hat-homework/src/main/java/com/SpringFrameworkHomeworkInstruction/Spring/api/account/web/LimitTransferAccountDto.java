package com.SpringFrameworkHomeworkInstruction.Spring.api.account.web;

import lombok.Builder;

@Builder
public record LimitTransferAccountDto(
        String uuid, String actName, Double balance, Double transferLimit
) {
}
