package com.starlinks.colonies.sdk;

import com.starlinks.colonies.api.ColonyAPI;
import com.starlinks.colonies.api.ColonyRepository;
import com.starlinks.colonies.sdk.pojo.ColonyPojoImpl;
import com.starlinks.colonies.sdk.repository.ColonyRepositoryImpl;
import com.starlinks.core.api.StarAPI;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class ColonyImpl implements ColonyAPI {

    private final StarAPI starAPI;

    private ColonyRepository colonyRepository;

    @Override
    public void onActivate() {
        colonyRepository = new ColonyRepositoryImpl();

        colonyRepository.createProcedures(null);

        colonyRepository.insertOrUpdate(
                ColonyPojoImpl.builder()
                        .colonyId(1)
                        .name("Central Colony")
                        .requiredLevel(10)
                        .worldRegion("central-colony-player")
                        .build()
        );

        System.out.println(colonyRepository.findAll().toString());
    }

    @Override
    public void onDeactivate() {
    }
}
