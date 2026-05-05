package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto;

import java.time.Instant;
import java.util.List;

public class PedidoSqsEventDTO {

    private String zipCode;
    private Integer customerId;
    private List<ItemDTO> orderItems;
    private String origin;
    private Instant occurredAt;

    public static class ItemDTO {
        private Integer sku;
        private Integer amount;

        public Integer getSku() { return sku; }
        public void setSku(Integer sku) { this.sku = sku; }

        public Integer getAmount() { return amount; }
        public void setAmount(Integer amount) { this.amount = amount; }
    }

    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public List<ItemDTO> getOrderItems() { return orderItems; }
    public void setOrderItems(List<ItemDTO> orderItems) { this.orderItems = orderItems; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public Instant getOccurredAt() { return occurredAt; }
    public void setOccurredAt(Instant occurredAt) { this.occurredAt = occurredAt; }
}