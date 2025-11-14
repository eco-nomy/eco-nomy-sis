package com.economy.domain.service;

import java.math.BigDecimal;
import java.util.Map;

public interface PixService {
    public Map<String, Object> createPixQRCode(Long corpId, BigDecimal amount);
    public Map<String, Object> sendPixPayout(String pixKey, BigDecimal amount);
    public PixWithdrawal createWithdrawalRecord(Long userId, String pixKey, BigDecimal amount);
}
