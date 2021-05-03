package com.forest.model.entity.woori;

public enum APIType {

    AccTransList("/oai/wb/v1/finance/getAccTransList", 1L),
    CellCerti("/oai/wb/v1/login/getCellCerti", 2L),
    ExecuteCellCerti("/oai/wb/v1/login/executeCellCerti", 3L);

    private String type;
    private Long primaryKey;

    APIType(String type, Long primaryKey) {
        this.type = type;
        this.primaryKey = primaryKey;

    }

    public String getType() {
        return type;
    }

    public Long getPrimaryKey() {
        return primaryKey;
    }
}