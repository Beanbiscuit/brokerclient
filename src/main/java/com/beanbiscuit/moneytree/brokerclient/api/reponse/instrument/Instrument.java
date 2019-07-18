package com.beanbiscuit.moneytree.brokerclient.api.reponse.instrument;

import com.beanbiscuit.moneytree.brokerclient.api.reponse.market.MarginDepositBand;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Instrument {

    @JsonProperty("chartCode")
    private final String chartCode;
    @JsonProperty("contractSize")
    private final String contractSize;
    /**
     * True if controlled risk trades are allowed
     */
    @JsonProperty("controlledRiskAllowed")
    private final boolean controlledRiskAllowed;
    @JsonProperty("country")
    private final String country;
    @JsonProperty("currencies")
    private List<Currency> currencies = new ArrayList<>();
    @JsonProperty("epic")
    private final String epic;
    @JsonProperty("expiry")
    private final String expiry;
    @JsonProperty("expiryDetails")
    private final ExpiryDetail expiryDetails;
    @JsonProperty("forceOpenAllowed")
    private final boolean forceOpenAllowed;
    @JsonProperty("limitedRiskPremium")
    private final LimitedRiskPremium limitedRiskPremium;
    @JsonProperty("lotSize")
    private final float lotSize;
    @JsonProperty("marginDepositBands")
    private final List<MarginDepositBand> marginDepositBands = new ArrayList<>();
    @JsonProperty("marginFactor")
    private final float marginFactor;
    /**
     * Constant, describes the dimension for a dealing rule value. PERCENTAGE, POINTS
     */
    @JsonProperty("marginFactorUnit")
    private final String marginFactorUnit;
    @JsonProperty("marketId")
    private final String marketId;
    @JsonProperty("name")
    private final String name;
    /**
     * Reuters news code.
     */
    @JsonProperty("newsCode")
    private final String newsCode;
    /**
     * Meaning of one pip
     */
    @JsonProperty("onePipMeans")
    private final String onePipMeans;
    @JsonProperty("openingHours")
    private final OpeningHour openingHours;
    @JsonProperty("rolloverDetails")
    private final RolloverDetail rolloverDetails;
    @JsonProperty("slippageFactor")
    private final SlippageFactor slippageFactor;
    @JsonProperty("specialInfo")
    private final List<String> specialInfo = new ArrayList<>();
    /**
     * For sprint markets only, the maximum value to be specified as the expiry of a sprint markets trade
     */
    @JsonProperty("sprintMarketsMaximumExpiryTime")
    private final float sprintMarketsMaximumExpiryTime;
    /**
     * For sprint markets only, the minimum value to be specified as the expiry of a sprint markets trade
     */
    @JsonProperty("sprintMarketsMinimumExpiryTime")
    private final float sprintMarketsMinimumExpiryTime;
    /**
     * True if stops and limits are allowed
     */
    @JsonProperty("stopsLimitsAllowed")
    private final boolean stopsLimitsAllowed;
    /**
     * True if streaming prices are available, i.e. the market is open and the client has appropriate permissions
     */
    @JsonProperty("streamingPricesAvailable")
    private final boolean streamingPricesAvailable;
    /**
     * Constant, instrument type e.g. COMMODITIES, CURRENCIES, INDICES e.g.
     */
    @JsonProperty("type")
    private final String type;
    /**
     * Unit used to qualify the size of a trade;
     *
     * AMOUNT
     * CONTRACTS
     * SHARES
     */
    @JsonProperty("unit")
    private final String unit;
    @JsonProperty("valueOfOnePip")
    private final String valueOfOnePip;

    public Instrument(
        String chartCode,
        String contractSize,
        boolean controlledRiskAllowed,
        String country,
        String epic,
        String expiry,
        ExpiryDetail expiryDetail,
        boolean forceOpenAllowed,
        LimitedRiskPremium limitedRiskPremium,
        float lotSize,
        float marginFactor,
        String marginFactorUnit,
        String marketId,
        String name,
        String newsCode,
        String onePipMeans,
        OpeningHour openingHours,
        RolloverDetail rolloverDetails,
        SlippageFactor slippageFactor,
        float sprintMarketsMaximumExpiryTime,
        float sprintMarketsMinimumExpiryTime,
        boolean stopsLimitsAllowed,
        boolean streamingPricesAvailable,
        String type,
        String unit,
        String valueOfOnePip
    ) {
        this.chartCode = chartCode;
        this.contractSize = contractSize;
        this.controlledRiskAllowed = controlledRiskAllowed;
        this.country = country;
        this.epic = epic;
        this.expiry = expiry;
        this.expiryDetails = expiryDetail;
        this.forceOpenAllowed = forceOpenAllowed;
        this.limitedRiskPremium = limitedRiskPremium;
        this.lotSize = lotSize;
        this.marginFactor = marginFactor;
        this.marginFactorUnit = marginFactorUnit;
        this.marketId = marketId;
        this.name = name;
        this.newsCode = newsCode;
        this.onePipMeans = onePipMeans;
        this.openingHours = openingHours;
        this.rolloverDetails = rolloverDetails;
        this.slippageFactor = slippageFactor;
        this.sprintMarketsMaximumExpiryTime = sprintMarketsMaximumExpiryTime;
        this.sprintMarketsMinimumExpiryTime = sprintMarketsMinimumExpiryTime;
        this.stopsLimitsAllowed = stopsLimitsAllowed;
        this.streamingPricesAvailable = streamingPricesAvailable;
        this.type = type;
        this.unit = unit;
        this.valueOfOnePip = valueOfOnePip;
    }

    public Instrument() {
        this.chartCode = null;
        this.contractSize = null;
        this.controlledRiskAllowed = false;
        this.country = null;
        this.epic = null;
        this.expiry = null;
        this.expiryDetails = null;
        this.forceOpenAllowed = false;
        this.limitedRiskPremium = null;
        this.lotSize = 0;
        this.marginFactor = 0;
        this.marginFactorUnit = null;
        this.marketId = null;
        this.name = null;
        this.newsCode = null;
        this.onePipMeans = null;
        this.openingHours = null;
        this.rolloverDetails = null;
        this.slippageFactor = null;
        this.sprintMarketsMaximumExpiryTime = 0;
        this.sprintMarketsMinimumExpiryTime = 0;
        this.stopsLimitsAllowed = false;
        this.streamingPricesAvailable = false;
        this.type = null;
        this.unit = null;
        this.valueOfOnePip = null;
    }

    public String getChartCode() {
        return chartCode;
    }

    public String getContractSize() {
        return contractSize;
    }

    public boolean isControlledRiskAllowed() {
        return controlledRiskAllowed;
    }

    public String getCountry() {
        return country;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public String getEpic() {
        return epic;
    }

    public String getExpiry() {
        return expiry;
    }

    public ExpiryDetail getExpiryDetails() {
        return expiryDetails;
    }

    public boolean isForceOpenAllowed() {
        return forceOpenAllowed;
    }

    public LimitedRiskPremium getLimitedRiskPremium() {
        return limitedRiskPremium;
    }

    public float getLotSize() {
        return lotSize;
    }

    public List<MarginDepositBand> getMarginDepositBands() {
        return marginDepositBands;
    }

    public float getMarginFactor() {
        return marginFactor;
    }

    public String getMarginFactorUnit() {
        return marginFactorUnit;
    }

    public String getMarketId() {
        return marketId;
    }

    public String getName() {
        return name;
    }

    public String getNewsCode() {
        return newsCode;
    }

    public String getOnePipMeans() {
        return onePipMeans;
    }

    public OpeningHour getOpeningHours() {
        return openingHours;
    }

    public RolloverDetail getRolloverDetails() {
        return rolloverDetails;
    }

    public SlippageFactor getSlippageFactor() {
        return slippageFactor;
    }

    public List<String> getSpecialInfo() {
        return specialInfo;
    }

    public float getSprintMarketsMaximumExpiryTime() {
        return sprintMarketsMaximumExpiryTime;
    }

    public float getSprintMarketsMinimumExpiryTime() {
        return sprintMarketsMinimumExpiryTime;
    }

    public boolean isStopsLimitsAllowed() {
        return stopsLimitsAllowed;
    }

    public boolean isStreamingPricesAvailable() {
        return streamingPricesAvailable;
    }

    public String getType() {
        return type;
    }

    public String getUnit() {
        return unit;
    }

    public String getValueOfOnePip() {
        return valueOfOnePip;
    }
}
