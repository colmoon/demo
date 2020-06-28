package com.anhen.jackson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible =
  true)
@JsonSubTypes({@JsonSubTypes.Type(value = StartEvent.class, name = "startEvent"),
        @JsonSubTypes.Type(value = EndEvent.class, name = "endEvent")})
public class BaseElement {

  String id;

  String type;
}
