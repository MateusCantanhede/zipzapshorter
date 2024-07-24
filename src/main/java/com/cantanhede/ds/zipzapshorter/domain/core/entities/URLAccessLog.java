package com.cantanhede.ds.zipzapshorter.domain.core.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
public class URLAccessLog {
    private long id;
    private String shortUrlId;
    private OffsetDateTime accessDate;
    private String ipAddress;
    private String userAgent;

    public URLAccessLog(long id, String shortUrlId, OffsetDateTime accessDate, String ipAddress, String userAgent) {
        this.id = id;
        this.shortUrlId = shortUrlId;
        this.accessDate = accessDate;
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
    }

}
