package entities;

public class Country {
    String Code; //PK
    String Name;
    String Continent;
    String Region;
    float SurfaceArea;
    int IndepYear;
    int Population;
    float LifeExpectancy;
    float GNP;
    float GNPOld;
    String LocalName;
    String GovernmentForm;
    String HeadOfState;
    int Capital;
    String Code2;

    public String getCode() {
        return this.Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getContinent() {
        return this.Continent;
    }

    public void setContinent(String Continent) {
        this.Continent = Continent;
    }

    public String getRegion() {
        return this.Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public float getSurfaceArea() {
        return this.SurfaceArea;
    }

    public void setSurfaceArea(float SurfaceArea) {
        this.SurfaceArea = SurfaceArea;
    }

    public int getIndepYear() {
        return this.IndepYear;
    }

    public void setIndepYear(int IndepYear) {
        this.IndepYear = IndepYear;
    }

    public int getPopulation() {
        return this.Population;
    }

    public void setPopulation(int Population) {
        this.Population = Population;
    }

    public float getLifeExpectancy() {
        return this.LifeExpectancy;
    }

    public void setLifeExpectancy(float LifeExpectancy) {
        this.LifeExpectancy = LifeExpectancy;
    }

    public float getGNP() {
        return this.GNP;
    }

    public void setGNP(float GNP) {
        this.GNP = GNP;
    }

    public float getGNPOld() {
        return this.GNPOld;
    }

    public void setGNPOld(float GNPOld) {
        this.GNPOld = GNPOld;
    }

    public String getLocalName() {
        return this.LocalName;
    }

    public void setLocalName(String LocalName) {
        this.LocalName = LocalName;
    }

    public String getGovernmentForm() {
        return this.GovernmentForm;
    }

    public void setGovernmentForm(String GovernmentForm) {
        this.GovernmentForm = GovernmentForm;
    }

    public String getHeadOfState() {
        return this.HeadOfState;
    }

    public void setHeadOfState(String HeadOfState) {
        this.HeadOfState = HeadOfState;
    }

    public int getCapital() {
        return this.Capital;
    }

    public void setCapital(int Capital) {
        this.Capital = Capital;
    }

    public String getCode2() {
        return this.Code2;
    }

    public void setCode2(String Code2) {
        this.Code2 = Code2;
    }

    @Override
    public String toString() {
        return "{" +
            " Code='" + getCode() + "'" +
            ", Name='" + getName() + "'" +
            ", Continent='" + getContinent() + "'" +
            ", Region='" + getRegion() + "'" +
            ", SurfaceArea='" + getSurfaceArea() + "'" +
            ", IndepYear='" + getIndepYear() + "'" +
            ", Population='" + getPopulation() + "'" +
            ", LifeExpectancy='" + getLifeExpectancy() + "'" +
            ", GNP='" + getGNP() + "'" +
            ", GNPOld='" + getGNPOld() + "'" +
            ", LocalName='" + getLocalName() + "'" +
            ", GovernmentForm='" + getGovernmentForm() + "'" +
            ", HeadOfState='" + getHeadOfState() + "'" +
            ", Capital='" + getCapital() + "'" +
            ", Code2='" + getCode2() + "'" +
            "}";
    }
}
