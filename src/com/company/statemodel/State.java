package com.company.statemodel;

import java.util.ArrayList;

public class State extends TerritorialFragment{

    private Capital capital;
    private ArrayList<Region> regions;

    public State()
    {
        capital = new Capital();
        regions = new ArrayList<Region>();
    }

    public State(Capital capital, ArrayList<Region> regions) {
        this.capital = capital;
        this.regions = regions;
    }

    public State(String name, Capital capital, ArrayList<Region> regions) {
        super(name);
        this.capital = capital;
        this.regions = regions;
    }

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }

    public void addRegion(Region region)
    {
        regions.add(region);
    }

    public void addRegions(Region...regions)
    {
        for (Region region : regions)
        {
            addRegion(region);
        }
    }

    public void addRegions(ArrayList<Region> regions)
    {
        this.regions.addAll(regions);
    }

    public void removeRegion(Region region)
    {
        regions.remove(region);
    }

    public void clearRegions()
    {
        regions.clear();
    }

    public long getPopulation()
    {
        long allPopulation = capital.getPopulation();
        for (Region region : regions)
        {
            allPopulation += region.getPopulation();
        }
        return allPopulation;
    }

    public int getNumberOfRegions()
    {
        return regions.size();
    }

    public double getArea()
    {
        double commonArea = capital.getArea();
        for (Region region : regions)
        {
            commonArea += region.getArea();
        }
        return commonArea;
    }

    public void printAllRegions()
    {
        for (Region region : regions)
        {
            System.out.print(region.getRegionalCenter() + "\n");
        }
    }

    @Override
    public String toString() {
        return "Тип территории: " + getName()
                + ". Столица: " + capital
                + ". Области в его составе: "
                + regions.toString();
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }
}