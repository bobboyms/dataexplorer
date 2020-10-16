package br.com.next.dataexplorer.model;

public class AuditDataModel {

    private String auditID;
    private String parentAuditId;
    private Long customerId;
    private String cpf;
    private String branch;
    private String accountNumber;
    private String agentId;
    private String ticketId;
    private String jti;
    private String email;
    private String hostName;
    private String deviceId;

    /* request data */
    private String requestMethod;
    private String requestIP;
    private String requestID;
    private String requestURI;
    private String query;
//    private Map<String, String> requestHeader;
    private String requestContent;
    private String requestContentType;
    private String requestEncode;
    private String exceptionMessage;

    /* response data */
    private Integer responseHttpStatusCode;
    private String responseHttpStatus;
//    private Map<String, String> responseHeader;
    private String responseContent;
    private Integer responseContentSize;

    private Long startTime;
    private String error;
    private Long endTime;


    public String getParentAuditId() {
        return parentAuditId;
    }

    public void setParentAuditId(String parentAuditId) {
        this.parentAuditId = parentAuditId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestIP() {
        return requestIP;
    }

    public void setRequestIP(String requestIP) {
        this.requestIP = requestIP;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public String getRequestContentType() {
        return requestContentType;
    }

    public void setRequestContentType(String requestContentType) {
        this.requestContentType = requestContentType;
    }

    public String getRequestEncode() {
        return requestEncode;
    }

    public void setRequestEncode(String requestEncode) {
        this.requestEncode = requestEncode;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public Integer getResponseHttpStatusCode() {
        return responseHttpStatusCode;
    }

    public void setResponseHttpStatusCode(Integer responseHttpStatusCode) {
        this.responseHttpStatusCode = responseHttpStatusCode;
    }

    public String getResponseHttpStatus() {
        return responseHttpStatus;
    }

    public void setResponseHttpStatus(String responseHttpStatus) {
        this.responseHttpStatus = responseHttpStatus;
    }

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }

    public Integer getResponseContentSize() {
        return responseContentSize;
    }

    public void setResponseContentSize(Integer responseContentSize) {
        this.responseContentSize = responseContentSize;
    }

    public String getAuditID() {
        return auditID;
    }

    public void setAuditID(String auditID) {
        this.auditID = auditID;
    }
}
