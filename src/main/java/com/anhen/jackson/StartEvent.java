package com.anhen.jackson;

import lombok.Data;
import lombok.ToString;

@ToString(callSuper = true)
@Data
public class StartEvent extends BaseElement{

  private String startEvent;

  private String startInfo;

}