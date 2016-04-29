package com.threeamstudios.theorangeloop;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Josh M on 3/25/2016.
 */
public class Organization {
    // Fields Regarding organization
    private static String orgName;
    private static Integer orgSize;
    private static ArrayList<Member> orgMembers;

    public Organization(){
        this.orgName = null;
        orgSize = 0;
        orgMembers = null;
    }

    public Organization(String orgName, Integer orgSize, ArrayList<Member> orgMembers){
        this.orgName = orgName;
        this.orgSize = orgSize;
        this.orgMembers = orgMembers;
    }

    // Additional getters and setters which calls OrganizationController
    public String getOrgName() {
        return orgName;
    }
    public Integer getOrgSize() {
        return orgSize;
    }
    public ArrayList<Member> getOrgMembers() {
        return orgMembers;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setOrgSize(Integer orgSize) {
        Organization.orgSize = orgSize;
    }

    public void setOrgMembers(ArrayList<Member> orgMembers) {
        Organization.orgMembers = orgMembers;
    }
}
