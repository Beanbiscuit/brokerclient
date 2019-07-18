package com.beanbiscuit.moneytree.brokerclient.api;

import com.beanbiscuit.moneytree.brokerclient.ApiClient;
import com.beanbiscuit.moneytree.brokerclient.ApiException;
import com.beanbiscuit.moneytree.brokerclient.api.authentication.IGApiSession;
import com.beanbiscuit.moneytree.brokerclient.api.reponse.market.*;
import com.beanbiscuit.moneytree.brokerclient.api.request.ApiQuery;

/**
 * See Markets section for more information about the IG markets REST endpoint.
 *
 * https://labs.ig.com/rest-trading-api-reference
 */
public class Market {

    private static final String VERSION = "VERSION";

    private final ApiClient client;
    private final ApiQuery query = new ApiQuery();

    public Market(ApiClient client) {
        this.client = client;
    }

    /**
     * Returns all top-level nodes (market categories) in the market navigation hierarchy.
     *
     * Uses version 1 of the endpoint.
     *
     * @param session A valid API session.
     * @throws ApiException
     */
    public MarketNavigation marketnavigation(IGApiSession session) throws ApiException {
        query.setHeader(VERSION, "1");
        final MarketNavigation navigation =
            (MarketNavigation) this.client.get("/marketnavigation", query, session, MarketNavigation.class);

        this.clear();
        return navigation;
    }

    /**
     * Returns all sub-nodes of the given node in the market navigation hierarchy.
     *
     * Uses version 1 of the endpoint.
     *
     * @param nodeId A market node id.
     * @param session A valid API session.
     * @return Contains all sub nodes of the given nodes.
     * @throws ApiException
     */
    public MarketNavigation marketnavigation(long nodeId, IGApiSession session) throws ApiException {
        query.setHeader(VERSION, "1");

        final MarketNavigation navigation =
            (MarketNavigation) this.client.get(
                "/marketnavigation/" + nodeId,
                query,
                session,
                MarketNavigation.class
            );

        this.clear();
        return navigation;
    }

    /**
     * Returns the details of the given markets.
     *
     * Uses version 2 of the endpoint.
     *
     * The epics of the market to be retrieved, separated by a comma. Max number of epics is limited to 50.
     * [Constraint: Pattern(regexp="^(?>(?:[A-Za-z0-9._]){6,30},?){0,200}$")]
     *
     * @param epics The epics string.
     * @param filter Filter for the market details.
     * @param session The user API session.
     * @return A collection of markets and associated information.
     * @throws ApiException
     */
    public MarketDetailCollection markets(String epics, String filter, IGApiSession session) throws ApiException {
        query.setHeader(VERSION, "2");
        query.setParameter("epics", epics);
        query.setParameter("filter", filter);

        final MarketDetailCollection detailsCollection =
            (MarketDetailCollection) this.client.get("/markets", query, session, MarketDetailCollection.class);

        this.clear();
        return detailsCollection;
    }

    /**
     * Returns the details of the given market.
     *
     * Uses version 3 of the endpoint.
     *
     * @param epic The epic of the market to be retrieved.
     * @param session A valid API session.
     * @return Detail about the epic including instrument dealing rules and snapshot.
     * @throws ApiException
     */
    public MarketDetail markets(String epic, IGApiSession session) throws ApiException {
        query.setHeader(VERSION, "3");

        final MarketDetail marketDetail =
            (MarketDetail) this.client.get("/markets/" + epic, query, session, MarketDetail.class);

        this.clear();
        return marketDetail;
    }

    /**
     * Returns all markets matching the search term.
     *
     * Uses version 1 of the endpoint.
     *
     * @param searchTerm The term to be used in the search.
     * @param session A valid API session.
     * @return A collection of markets.
     * @throws ApiException
     */
    public MarketCollection searchMarkets(String searchTerm, IGApiSession session) throws ApiException {
        query.setHeader(VERSION, "1");
        query.setParameter("searchTerm", searchTerm);

        MarketCollection markets =
            (MarketCollection) this.client.get("/markets", query, session, MarketCollection.class);

        this.clear();
        return markets;
    }

    /**
     * Returns historical prices for a particular instrument. By default returns the minute prices within the last 10
     * minutes.
     *
     * Uses version 3 of the endpoint.
     *
     * @param epic The epic of the market to be retrieved.
     * @param session A valid API session.
     * @return A collection of historical prices for the given criteria.
     * @throws ApiException
     */
    public HistoricalPriceCollection prices(String epic, IGApiSession session) throws ApiException {
        query.setHeader(VERSION, "3");

        return this.fetchHistoricalPrices(epic, session);
    }

    /**
     * Returns historical prices for a particular instrument. By default returns the minute prices within the last 10
     * minutes.
     *
     * Price resolution (MINUTE, MINUTE_2, MINUTE_3, MINUTE_5, MINUTE_10, MINUTE_15, MINUTE_30, HOUR, HOUR_2, HOUR_3,
     * HOUR_4, DAY, WEEK, MONTH)
     *
     * Uses version 3 of the endpoint.
     *
     * @param epic The epic of the market to be retrieved.
     * @param resolution Defines the resolution of requested prices.
     * @param session A valid API session.
     * @return A collection of historical prices for the given criteria.
     * @throws ApiException
     */
    public HistoricalPriceCollection prices(String epic, String resolution, IGApiSession session) throws ApiException {
        query.setHeader(VERSION, "3");
        query.setParameter("resolution", resolution);

        return this.fetchHistoricalPrices(epic, session);
    }

    /**
     * Returns a list of historical prices for the given epic, resolution and date range.
     *
     * Uses version 3 of the endpoint.
     *
     * @param epic The epic of the market to be retrieved.
     * @param resolution Defines the resolution of requested prices.
     * @param from Start date time (yyyy-MM-dd'T'HH:mm:ss).
     * @param to End date time (yyyy-MM-dd'T'HH:mm:ss).
     * @param pageSize Page size (disable paging = 0).
     * @param pageNumber Page number.
     * @param session A valid API session.
     * @return A collection of historical prices for the given criteria.
     * @throws ApiException
     */
    public HistoricalPriceCollection prices(String epic, String resolution, String from, String to, int pageSize, int pageNumber, IGApiSession session) throws ApiException {
        query.setHeader(VERSION, "3");
        query.setParameter("resolution", resolution);
        query.setParameter("from", from);
        query.setParameter("to", to);
        query.setParameter("pageSize", String.valueOf(pageSize));
        query.setParameter("pageNumber", String.valueOf(pageNumber));

        return this.fetchHistoricalPrices(epic, session);
    }

    /**
     * Returns a list of historical prices for the given epic, resolution and date points.
     *
     * Uses version 3 of the endpoint.
     *
     * @param epic The epic of the market to be retrieved.
     * @param resolution Defines the resolution of requested prices.
     * @param max Limits the number of price points (not applicable if a date range has been specified).
     * @param pageSize Page size (disable paging = 0).
     * @param pageNumber Page number.
     * @param session A valid API session.
     * @return A collection of historical prices for the given criteria.
     * @throws ApiException
     */
    public HistoricalPriceCollection prices(String epic, String resolution, int max, int pageSize, int pageNumber, IGApiSession session) throws ApiException {
        query.setHeader(VERSION, "3");
        query.setParameter("resolution", resolution);
        query.setParameter("max", String.valueOf(max));
        query.setParameter("pageSize", String.valueOf(pageSize));
        query.setParameter("pageNumber", String.valueOf(pageNumber));

        return this.fetchHistoricalPrices(epic, session);
    }

    /**
     * Returns a list of historical prices for the given epic, resolution and number of data points.
     *
     * Uses version 2 of the endpoint.
     *
     * @param epic The epic of the market to be retrieved.
     * @param resolution Defines the resolution of requested prices.
     * @param numPoints Number of data points required.
     * @param session A valid API session.
     * @return A collection of historical prices for the given criteria.
     * @throws ApiException
     */
    public HistoricalPriceCollection prices(String epic, String resolution, String numPoints, IGApiSession session) throws ApiException {
        query.setHeader(VERSION, "2");
        query.setParameter("resolution", resolution);
        query.setParameter("numPoints", numPoints);

        return this.fetchHistoricalPrices(epic, session);
    }

    /**
     * Returns a list of historical prices for the given epic, resolution and date range.
     *
     * Uses version 2 of the endpoint.
     *
     * @param epic The epic of the market to be retrieved.
     * @param resolution Defines the resolution of requested prices.
     * @param startDate Start date (yyyy-MM-dd HH:mm:ss)
     * @param endDate End date (yyyy-MM-dd HH:mm:ss)
     * @param session A valid API session.
     * @return A collection of historical prices for the given criteria.
     * @throws ApiException
     */
    public HistoricalPriceCollection prices(String epic, String resolution, String startDate, String endDate, IGApiSession session) throws ApiException {
        query.setHeader(VERSION, "2");
        query.setParameter("resolution", resolution);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        return this.fetchHistoricalPrices(epic, session);
    }

    /**
     * Fetches collection of historical prices from the prices endpoint.
     *
     * @param epic The epic of the market to be retrieved.
     * @param session A valid API session.
     * @return A collection of historical prices for the given criteria.
     * @throws ApiException
     */
    private HistoricalPriceCollection fetchHistoricalPrices(String epic, IGApiSession session) throws ApiException {
        final HistoricalPriceCollection response = (HistoricalPriceCollection)
            this.client.get("/prices/" + epic, query, session, HistoricalPriceCollection.class);

        this.clear();
        return response;
    }

    /**
     * Clear internal parameter and header maps.
     */
    private void clear() {
        query.getHeaders().clear();
        query.getParameters().clear();
    }
}