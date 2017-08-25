package io.searchbox5.core.search.aggregation;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.searchbox5.core.SearchResult;

public class TopHitsAggregation extends SearchResult {

    protected String name;
    protected JsonObject jsonRoot;
    public static final String TYPE = "top_hits";

    public TopHitsAggregation(String name, JsonObject topHitAggregation) {
	super(new Gson());
	this.name = name;
	
	this.setSucceeded(true);
	this.setJsonObject(topHitAggregation);
	//this.setJsonString(topHitAggregation.getAsString());
	this.setPathToResult("hits/hits/_source");
    }

    public String getName() {
	return name;
    }
}
