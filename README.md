# Brokerclient
Client package for IG rest and streaming APIs.  Aim of the package is to model IG Rest endpoints and streaming endpoints as faithfully as possible.  PAckage is incomplete as of writing.

You can access the API by creating a demo account at
https://www.ig.com/uk/login

#Todos
Onlyy a few of the API and streaming API endpoints are present so far and the package is incomplete.
Refresh token functionality is still ot in place :(
Streaming API not quite there yet, only market heart beat so far.
Some of the API response classes have way to many args in constructors and need to be broken down but still match IGs API model.


# REST API example of usage
The below snippet will fetch Bitcoin market data and prices.

        final ApiClient client = ApiClient.newInstance(
            "YOUR IG API Username",
            "YOUR IG API Passwird",
            "YOUR IG API Key",
            "https://demo-api.ig.com/gateway/deal",
        );

        client.setAuthentication(new OAuthTokenAccess());
        final IGApiSession session = client.authenticate();

        Market service = new Market(client);

        final MarketNavigation marketnavigation = service.marketnavigation(session);
        System.out.println(marketnavigation);

        final MarketNavigation cryptoMarketNode = service.marketnavigation(668394, session);
        System.out.println(cryptoMarketNode);

        final MarketDetailCollection markets =
            service.markets("CS.D.BITCOIN.TODAY.IP", MarketDetailsFilterType.ALL.toString(), session);
        System.out.println(markets.getMarketDetails().size());
        System.out.println(markets.getMarketDetails().get(0).getInstrument().getName());
        System.out.println(markets.getMarketDetails().get(0).getInstrument().getLotSize());
        System.out.println(markets.getMarketDetails().get(0).getDealingRules().getMarketOrderPreference());
        System.out.println(markets.getMarketDetails().get(0).getSnapshot().getPercentageChange());

        final MarketDetail bitcoin = service.markets("CS.D.BITCOIN.TODAY.IP", session);
        System.out.println(bitcoin.getInstrument().getName());
        System.out.println(bitcoin.getInstrument().getCountry());

        final MarketCollection response = service.searchMarkets("Bitcoin", session);
        System.out.println(response.getMarkets().get(0).getEpic());
        System.out.println(response.getMarkets().get(0).getDelayTime());

        // Historical prices
        final HistoricalPriceCollection prices1 = service.prices("CS.D.BITCOIN.TODAY.IP", session);
        System.out.println(prices1.getPrices().get(0).getClosePrice().getAsk());

        final HistoricalPriceCollection prices = service.prices("CS.D.BITCOIN.TODAY.IP", PriceResolution.HOUR.getValue(), session);
        System.out.println(prices.getPrices().get(0).getOpenPrice().getAsk());

        client.logout(session);
        client.close();
        
 You can debug the connection by instantiating the API client in debug mode using a static factory method.
 
         final ApiClient client = ApiClient.newDebugInstance(
            "YOUR IG API Username",
            "YOUR IG API Passwird",
            "YOUR IG API Key",
            "https://demo-api.ig.com/gateway/deal",
            Level.INFO
        );
         
# Streaming API example of usage

Below snippet gets the heart beat from the IG streaming API.

        final ApiClient client = ApiClient.newInstance(
            "YOUR IG API Username",
            "YOUR IG API Passwird",
            "YOUR IG API Key",
            "https://demo-api.ig.com/gateway/deal",
        );

        client.setAuthentication(new SecurityTokenAccess());
        final IGApiSession session = client.authenticate();

        StreamingApiClient streamClient = new StreamingApiClient();
        streamClient.connect(session);

        MarketHeartbeatSubscription subscription = new MarketHeartbeatSubscription(streamClient);

        subscription.open(session);
        subscription.connect();

        Thread.sleep(4000);
        System.out.println(subscription.getUpdateItem());

        Thread.sleep(2000);
        System.out.println(subscription.getUpdateItem());

        Thread.sleep(2000);
        System.out.println(subscription.getUpdateItem());

        subscription.close();
