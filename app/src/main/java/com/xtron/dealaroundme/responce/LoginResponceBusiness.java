package com.xtron.dealaroundme.responce;

/**
 * Created by pranav on 27-02-2017.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "disclaimer",
        "success",
        "ack"
})
public class LoginResponceBusiness {

    @JsonProperty("id")
    private String id;
    @JsonProperty("disclaimer")
    private String disclaimer;
    @JsonProperty("success")
    private String success;
    @JsonProperty("ack")
    private String ack;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("disclaimer")
    public String getDisclaimer() {
        return disclaimer;
    }

    @JsonProperty("success")
    public String getSuccess() {
        return success;
    }

    @JsonProperty("ack")
    public String getAck() {
        return ack;
    }

}
