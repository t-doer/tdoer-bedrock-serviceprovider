package com.tdoer.bedrock.serviceprovider.eo.product;

import java.util.Date;

public class ClientTokenEO {
    private Long id;

    private Long clientId;

    private String grantTypes;

    private String autoApprovals;

    private String webRedirectUri;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String sessionPolicy;

    private Long tenantId;

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

    public String getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(String grantTypes) {
        this.grantTypes = grantTypes == null ? null : grantTypes.trim();
    }

    public String getAutoApprovals() {
        return autoApprovals;
    }

    public void setAutoApprovals(String autoApprovals) {
        this.autoApprovals = autoApprovals == null ? null : autoApprovals.trim();
    }

    public String getWebRedirectUri() {
        return webRedirectUri;
    }

    public void setWebRedirectUri(String webRedirectUri) {
        this.webRedirectUri = webRedirectUri == null ? null : webRedirectUri.trim();
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getSessionPolicy() {
        return sessionPolicy;
    }

    public void setSessionPolicy(String sessionPolicy) {
        this.sessionPolicy = sessionPolicy == null ? null : sessionPolicy.trim();
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
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