package entities;

public class Language {
    PK countryLanguage;
    Boolean isOfficial;
    Float percentage;

    public Language(String code, String language, Boolean isOfficial, Float percentage) {
        countryLanguage = new PK(code, language);
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public static class PK {
        public PK(String countryCode, String language) {
            this.countryCode = countryCode;
            this.language = language;
        }

        String countryCode;
        String language;
    }

    @Override
    public String toString() {
        return "countryCode: " + countryLanguage.countryCode + ", isOfficial: " + isOfficial 
            + ", percentage:" + percentage + ", language:" + countryLanguage.language;
    }

    public PK getCountryLanguage() {
        return this.countryLanguage;
    }

    public void setCountryLanguage(PK countryLanguage) {
        this.countryLanguage = countryLanguage;
    }

    public Boolean getIsOfficial() {
        return this.isOfficial;
    }

    public void setIsOfficial(Boolean isOfficial) {
        this.isOfficial = isOfficial;
    }

    public Float getPercentage() {
        return this.percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}