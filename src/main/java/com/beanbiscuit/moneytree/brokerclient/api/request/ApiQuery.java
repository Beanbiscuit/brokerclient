package com.beanbiscuit.moneytree.brokerclient.api.request;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores key value pairs for sending in a post or get request.
 * Provides pagination and time period criteria.
 * Coverts all entices into a query string that can be used in GET or POST requests.
 * Allows passing of additional headers for individual endpoint requests
 */
public class ApiQuery {

    private Pagination pagination;
    private TimePeriod timePeriod;
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> parameters = new HashMap<>();

    /**
     *
     * @return
     */
    public String getQueryParameters() {
        StringBuilder paramString = new StringBuilder();

        this.parameters.forEach((k,v)->{
            paramString.append(k);
            paramString.append("=");
            paramString.append(v);
            paramString.append("&");
        });

        if (paramString.length() > 0) {
            // Remove any trailing & if params have been set.
            return paramString.toString().substring(0, paramString.length() - 1);
        }

        return paramString.toString();
    }

    /**
     *
     * @param headerName
     * @param headerValue
     * @return
     */
    public ApiQuery setHeader(String headerName, String headerValue) {
        this.headers.put(headerName, headerValue);
        return this;
    }

    /**
     *
     * @param paramName
     * @param paramValue
     * @return
     */
    public ApiQuery setParameter(String paramName, String paramValue) {
        this.parameters.put(paramName, paramValue);
        return this;
    }

    /**
     *
     * @return
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     *
     * @return
     */
    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    /**
     *
     * @return
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     *
     * @return
     */
    public Map<String, String> getParameters() {
        return parameters;
    }

    /**
     *
     * @param pagination
     * @return
     */
    public ApiQuery setPagination(Pagination pagination) {
        this.pagination = pagination;
        return this;
    }

    /**
     *
     * @param timePeriod
     * @return
     */
    public ApiQuery setTimePeriod(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
        return this;
    }
}
