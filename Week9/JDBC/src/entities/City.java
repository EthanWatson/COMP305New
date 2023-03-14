package entities;

public class City {
    Integer ID; //PK
    String Name;
    String CountryCode;
    String District;
    Integer Population;

    public Integer getID() {
        return this.ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCountryCode() {
        return this.CountryCode;
    }

    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    public String getDistrict() {
        return this.District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public Integer getPopulation() {
        return this.Population;
    }

    public void setPopulation(Integer Population) {
        this.Population = Population;
    }

    @Override
    public String toString() {
        return "City [CountryCode = " + CountryCode + ", Disctrict=" + District + 
            ", ID=" + ID + ", Name" + Name + ", Population=" + Population + "]";
    }
}
