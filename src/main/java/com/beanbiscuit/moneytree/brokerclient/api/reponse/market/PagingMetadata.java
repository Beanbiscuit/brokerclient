package com.beanbiscuit.moneytree.brokerclient.api.reponse.market;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Historical prices response set paging data.
 */
public class PagingMetadata {

    @JsonProperty("pageNumber")
    private final int pageNumber;
    @JsonProperty("pageSize")
    private final int pageSize;
    @JsonProperty("totalPages")
    private final int totalPages;

    public PagingMetadata(int pageNumber, int pageSize, int totalPages) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
    }

    public PagingMetadata() {
        this.pageNumber = 0;
        this.pageSize = 0;
        this.totalPages = 0;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
