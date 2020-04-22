package com.starlinks.colonies.sdk.repository;

import com.starlinks.colonies.api.ColonyRepository;
import com.starlinks.colonies.api.pojo.ColonyPojo;
import com.starlinks.core.api.database.jdbc.StarDatabaseProvider;
import lombok.Getter;

import java.util.Collection;
import java.util.WeakHashMap;
import java.util.function.Supplier;

public final class ColonyRepositoryImpl implements ColonyRepository {

    private final WeakHashMap<Integer, ColonyPojo> colonyCache = new WeakHashMap<>();

    @Getter
    private StarDatabaseProvider provider;

    public void createProcedures(StarDatabaseProvider provider) {
        this.provider = provider;
    }

    @Override
    public Collection<ColonyPojo> findAll() {
        return colonyCache.values();
    }

    @Override
    public ColonyPojo find(Integer key) {
        return colonyCache.get(key);
    }

    @Override
    public void insert(ColonyPojo instance) {
        //not implemented
    }

    @Override
    public void update(ColonyPojo instance) {
        //not implemented
    }

    @Override
    public void insertOrUpdate(ColonyPojo instance) {
        colonyCache.put(instance.getColonyId(), instance);
    }

    @Override
    public void findOrInsert(Integer key, Supplier<ColonyPojo> supplier) {
    }

    @Override
    public void findAndDelete(Integer key) {
    }
}
