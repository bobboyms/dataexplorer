package br.com.next.dataexplorer.model;

public class AuditDataDataFeignModel {

    private String auditID;
    private String requestMethod;
    private String requestURI;
    private String query;
    private String requestContent;

    private Integer responseHttpStatusCode;
    private String responseHttpStatus;
    private String responseContent;
    private Integer responseContentSize;

    private Long elapsedTime;
    private String error;

    public String getAuditID() {
        return auditID;
    }

    public void setAuditID(String auditID) {
        this.auditID = auditID;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
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

    public Long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
