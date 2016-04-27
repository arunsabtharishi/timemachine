package com.dragonfly.timemachine.contents;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsertContentsRequest {
    String contents;

    String contentDate;

    String userName;

}