package com.economy.dto.output;

public class QrCodePixParaPagamento {
    private float id;
    private String status;
    private String qrCode;
    private String qrCodeBase64;

    public QrCodePixParaPagamento(float id, String status, String qrCode, String qrCodeBase64) {
        this.id = id;
        this.status = status;
        this.qrCode = qrCode;
        this.qrCodeBase64 = qrCodeBase64;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getQrCodeBase64() {
        return qrCodeBase64;
    }

    public void setQrCodeBase64(String qrCodeBase64) {
        this.qrCodeBase64 = qrCodeBase64;
    }
}
