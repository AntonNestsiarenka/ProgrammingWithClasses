package com.company.statemodel;

import java.util.ArrayList;

public class Region extends TerritorialFragment {

    private RegionalCity regionalCenter;
    private ArrayList<District> districts;

    public Region()
    {
        regionalCenter = new RegionalCity();
        districts = new ArrayList<District>();
    }

    public Region(RegionalCity regionalCenter, ArrayList<District> districts) {
        this.regionalCenter = regionalCenter;
        this.districts = districts;
    }

    public Region(String name, RegionalCity regionalCenter, ArrayList<District> districts) {
        super(name);
        this.regionalCenter = regionalCenter;
        this.districts = districts;
    }

    public RegionalCity getRegionalCenter() {
        return regionalCenter;
    }

    public void setRegionalCenter(RegionalCity regionalCenter) {
        this.regionalCenter = regionalCenter;
    }

    public ArrayList<District> getDistricts() {
        return districts;
    }

    public void setDistricts(ArrayList<District> districts) {
        this.districts = districts;
    }

    public void addDistrict(District district)
    {
        districts.add(district);
    }

    public void addDistricts(District...districts)
    {
        for (District district : districts)
        {
            addDistrict(district);
        }
    }

    public void addDistricts(ArrayList<District> districts)
    {
        this.districts.addAll(districts);
    }

    public void removeDistrict(District district)
    {
        districts.remove(district);
    }

    public void clearDistricts()
    {
        districts.clear();
    }

    public long getPopulation()
    {
        long allPopulation = regionalCenter.getPopulation();
        for (District district : districts)
        {
            allPopulation += district.getPopulation();
        }
        return allPopulation;
    }

    public double getArea()
    {
        double commonArea = regionalCenter.getArea();
        for (District district : districts)
        {
            commonArea += district.getArea();
        }
        return commonArea;
    }

    @Override
    public String toString() {
        return "Тип территории: " + getName()
                + ". Областной центр: " + regionalCenter
                + ". Районы в его составе: "
                + districts.toString();
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }
}