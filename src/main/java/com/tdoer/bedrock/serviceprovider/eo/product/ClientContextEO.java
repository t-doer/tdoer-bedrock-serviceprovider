package com.tdoer.bedrock.serviceprovider.eo.product;

import java.util.Date;

public class ClientContextEO {
    private Long id;

    private Long clientId;

    private String contextPath;

    private String entryAppCode;

    private String entryNavItem;

    private String entryLanguage;

    private Long tenantId;

    private String enabled;

    private Long createdBy;

    private Date createdAt;

    private Long updatedBy;

    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath == null ? null : contextPath.trim();
    }

    public String getEntryAppCode() {
        return entryAppCode;
    }

    public void setEntryAppCode(String entryAppCode) {
        this.entryAppCode = entryAppCode == null ? null : entryAppCode.trim();
    }

    public String getEntryNavItem() {
        return entryNavItem;
    }

    public void setEntryNavItem(String entryNavItem) {
        this.entryNavItem = entryNavItem == null ? null : entryNavItem.trim();
    }

    public String getEntryLanguage() {
        return entryLanguage;
    }

    public void setEntryLanguage(String entryLanguage) {
        this.entryLanguage = entryLanguage == null ? null : entryLanguage.trim();
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}