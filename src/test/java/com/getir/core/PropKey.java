package com.getir.core;

public enum PropKey {

    URL("url"),
    EMULATOR("emulator"),
    PLATFORM("platform"),
    PLATFORM_VERSION("platformVersion");

    private String propVal;

    PropKey(String propVal) {
        this.propVal = propVal;
    }

    public String getPropVal() {
        return propVal;
    }
}
