package com.folio.claimset;

public class ClaimSetEnum {

    //Mandatory claimset with predefined values
    public enum MandatoryClaimSet {

        SUBJECT("folio jwt"),
        ISSUER("FolioDx");

        public String getValue() {
            return value;
        }

        private String value;
        private MandatoryClaimSet(String value) {
            this.value = value;
        }
    };

    //Csutom claimset
    public enum CustomClaimSet {
        SPONSOR_FIRMID("75004"),
        SPONSOR_NAME("DA DAVIDSON");
        private String value;
        public String getValue() {
            return value;
        }
        private CustomClaimSet(String value) {
            this.value = value;
        }
    }


}
