package com.threeamstudios.theorangeloop;

/**
 * Created by Josh M on 3/25/2016.
 */
public class Organization {
    // Fields Regarding organization
    private static String orgName;
    private static Integer orgSize;
    private static ArrayList<Member> orgMembers;

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
}
