package com.starlinks.colonies.sdk.pojo;

import com.starlinks.colonies.api.pojo.ColonyPojo;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public final class ColonyPojoImpl implements ColonyPojo {

    private final int colonyId;
    private final String name, worldRegion;
    private final int requiredLevel;
}