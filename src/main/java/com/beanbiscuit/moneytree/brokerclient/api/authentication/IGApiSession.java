package com.beanbiscuit.moneytree.brokerclient.api.authentication;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.ir.annotations.Ignore;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IGApiSession {

    private final String timezoneOffset;
    private final String accountId;
    private final String activeAccountId;
    private final String clientId;
    private final String lightstreamerEndpoint;
    private final String errorCode;
    private OauthToken oauthToken;
    private String XSecurityToken;
    private String cst;

    /**
     * @param timezoneOffset
     * @param accountId
     * @param activeAccountId
     * @param clientId
     * @param endpoint
     * @param token
     * @param errorCode
     */
    public IGApiSession(
        String timezoneOffset,
        String accountId,
        String activeAccountId,
        String clientId,
        String endpoint,
        OauthToken token,
        String errorCode
    ) {
        this.timezoneOffset = timezoneOffset;
        this.accountId = accountId;
        this.activeAccountId = activeAccountId;
        this.clientId = clientId;
        this.lightstreamerEndpoint = endpoint;
        this.oauthToken = token;
        this.errorCode = errorCode;
    }

    public IGApiSession() {
        this.timezoneOffset = null;
        this.accountId = null;
        this.clientId = null;
        this.lightstreamerEndpoint = null;
        this.oauthToken = null;
        this.errorCode = null;
        this.activeAccountId = null;
    }

    @JsonGetter("currentAccountId")
    public String getActiveAccountId() {
        return activeAccountId;
    }

    @JsonGetter("timezoneOffset")
    public String getTimezoneOffset() {
        return timezoneOffset;
    }

    @JsonGetter("errorCode")
    public String getErrorCode() {return errorCode; }

    @JsonGetter("accountId")
    public String getAccountId() {
        return accountId;
    }

    @JsonGetter("clientId")
    public String getClientId() {
        return clientId;
    }

    @JsonGetter("lightstreamerEndpoint")
    public String getLightstreamerEndpoint() {
        return lightstreamerEndpoint;
    }

    /**
     * @deprecated Would be false positive on V", no error code in response
     * @return
     */
    @Ignore
    public boolean isError() {
        return(errorCode != null);
    }

    /**
     * Returns the streamer password in the format;
     *
     * CST-token|XST-security_token
     *
     * Format is required by the Lightstreamer service when connecting.
     *
     * @return
     */
    public String getStreamerPassword() {
        return "CST-" + this.getCst() + "|XST-" + this.getXSecurityToken();
    }

    public OauthToken getOauthToken() {
        return oauthToken;
    }

    public void setOauthToken(OauthToken oauthToken) {
        this.oauthToken = oauthToken;
    }

    public String getXSecurityToken() {
        return XSecurityToken;
    }

    public void setXSecurityToken(String XSecurityToken) {
        this.XSecurityToken = XSecurityToken;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }
}
