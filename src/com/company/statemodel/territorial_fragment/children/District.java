package com.company.statemodel.territorial_fragment.children;

import com.company.statemodel.city.children.DistrictCity;
import com.company.statemodel.city.children.VillageCity;
import com.company.statemodel.territorial_fragment.TerritorialFragment;

import java.util.ArrayList;

public class District extends TerritorialFragment {

    /* Класс описывает район. */

    private DistrictCity districtCenter;
    private ArrayList<VillageCity> districtCitys;

    public District()
    {
        districtCenter = new DistrictCity();
        districtCitys = new ArrayList<VillageCity>();
    }

    public District(DistrictCity districtCenter, ArrayList<VillageCity> districtCitys) {
        this.districtCenter = districtCenter;
        this.districtCitys = districtCitys;
    }

    public District(String name, DistrictCity districtCenter, ArrayList<VillageCity> districtCitys) {
        super(name);
        this.districtCenter = districtCenter;
        this.districtCitys = districtCitys;
    }

    public DistrictCity getDistrictCenter() {
        return districtCenter;
    }

    public void setDistrictCenter(DistrictCity districtCenter) {
        this.districtCenter = districtCenter;
    }

    public ArrayList<VillageCity> getDistrictCitys() {
        return districtCitys;
    }

    public void setDistrictCitys(ArrayList<VillageCity> districtCitys) {
        this.districtCitys = districtCitys;
    }

    public void addVillageCity(VillageCity villageCity)
    {
        this.districtCitys.add(villageCity);
    }

    public void addVillageCitys(VillageCity...villageCitys)
    {
        for (VillageCity villageCity : villageCitys)
        {
            addVillageCity(villageCity);
        }
    }

    public void addVillageCitys(ArrayList<VillageCity> villageCitys)
    {
        districtCitys.addAll(villageCitys);
    }

    public void removeVillageCity(VillageCity villageCity)
    {
        districtCitys.remove(villageCity);
    }

    public void clearDistrictCitys()
    {
        districtCitys.clear();
    }

    public long getPopulation()
    {
        long allPopulation = districtCenter.getPopulation();
        for (VillageCity villageCity : districtCitys)
        {
            allPopulation += villageCity.getPopulation();
        }
        return allPopulation;
    }

    public double getArea()
    {
        double commonArea = districtCenter.getArea();
        for (VillageCity villageCity : districtCitys)
        {
            commonArea += villageCity.getArea();
        }
        return commonArea;
    }

    @Override
    public String toString() {
        return "Тип территории: " + getName()
                + ". Районный центр: " + districtCenter
                + ". Населенные пункты в его составе: "
                + districtCitys.toString();
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }
}