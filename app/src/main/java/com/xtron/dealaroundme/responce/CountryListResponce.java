package com.xtron.dealaroundme.responce;

/**
 * Created by pranav on 28-02-2017.
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cou_parent_id",
        "cou_id",
        "cou_name"
})
public class CountryListResponce {

    @JsonProperty("cou_parent_id")
    private String couParentId;
    @JsonProperty("cou_id")
    private String couId;
    @JsonProperty("cou_name")
    private String couName;

    @JsonProperty("cou_parent_id")
    public String getCouParentId() {
        return couParentId;
    }

    @JsonProperty("cou_id")
    public String getCouId() {
        return couId;
    }

    @JsonProperty("cou_name")
    public String getCouName() {
        return couName;
    }

}
