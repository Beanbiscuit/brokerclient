package com.beanbiscuit.moneytree.brokerclient.api.reponse.market;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Historical price response metadata data.
 */
public class HistoricalPriceMetadata {

    @JsonProperty("pageData")
    private final PagingMetadata pageData;
    @JsonProperty("size")
    private final int size;
    @JsonProperty("allowance")
    private final HistoricalPriceDataAllowance allowance;

    public HistoricalPriceMetadata(PagingMetadata pageData, int size, HistoricalPriceDataAllowance allowance) {
        this.pageData = pageData;
        this.size = size;
        this.allowance = allowance;
    }

    public HistoricalPriceMetadata() {
        this.pageData = null;
        this.size = 0;
        this.allowance = null;
    }

    public PagingMetadata getPageData() {
        return pageData;
    }

    public int getSize() {
        return size;
    }

    /**
     *
     * @return
     */
    public HistoricalPriceDataAllowance getAllowance() {
        return allowance;
    }
}
