package com.threeamstudios.theorangeloop;

/**
 * Created by Josh M on 3/25/2016.
 */
public class OrganizationController {
    public Boolean popularClub(Organization organization){
        if(organization.getOrgSize() > 20){
            return true;
        }else {
            return false;
        }
    }

}
