package vttp.ssf.day18.model;


public class Carpark {

    private int id;
    private String carpark;
    private String category;
    private String weekdayRate1;
    private String weekdayRate2;
    private String saturdayRate;
    private String sundayPhRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCarpark() {
        return carpark;
    }

    public void setCarpark(String carpark) {
        this.carpark = carpark;
    }

    public String getWeekdayRate1() {
        return weekdayRate1;
    }

    public void setWeekdayRate1(String weekdayRate1) {
        this.weekdayRate1 = weekdayRate1;
    }

    public String getWeekdayRate2() {
        return weekdayRate2;
    }

    public void setWeekdayRate2(String weekdayRate2) {
        this.weekdayRate2 = weekdayRate2;
    }

    public String getSaturdayRate() {
        return saturdayRate;
    }

    public void setSaturdayRate(String saturdayRate) {
        this.saturdayRate = saturdayRate;
    }

    public String getSundayPhRate() {
        return sundayPhRate;
    }

    public void setSundayPhRate(String sundayPhRate) {
        this.sundayPhRate = sundayPhRate;
    }

    @Override
    public String toString() {
        return "Carpark{" +
                "id=" + id +
                ", carpark='" + carpark + '\'' +
                ", category='" + category + '\'' +
                ", weekdayRate1='" + weekdayRate1 + '\'' +
                ", weekdayRate2='" + weekdayRate2 + '\'' +
                ", saturdayRate='" + saturdayRate + '\'' +
                ", sundayPhRate='" + sundayPhRate + '\'' +
                '}';
    }


}
