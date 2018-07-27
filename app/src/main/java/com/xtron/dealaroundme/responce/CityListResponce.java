package com.xtron.dealaroundme.responce;

/**
 * Created by xtron on 28-02-2017.
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "city_id",
        "city_parent_id",
        "city_name"
})
public class CityListResponce {

    @JsonProperty("city_id")
    private String cityId;
    @JsonProperty("city_parent_id")
    private String cityParentId;
    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("city_id")
    public String getCityId() {
        return cityId;
    }

    @JsonProperty("city_parent_id")
    public String getCityParentId() {
        return cityParentId;
    }

    @JsonProperty("city_name")
    public String getCityName() {
        return cityName;
    }

}
