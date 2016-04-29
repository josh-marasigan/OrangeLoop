package com.threeamstudios.theorangeloop;

import java.util.ArrayList;
import com.threeamstudios.theorangeloop.Params;

/**
 * Created by Josh M on 3/25/2016.
 */
public class OrganizationController {
    public static Boolean popularClub(Organization organization){
        if(organization.getOrgSize() > 20){
            return true;
        }else {
            return false;
        }
    }
    public static String bestOrganization(){
        Organization bestOrg = new Organization();
        bestOrg.setOrgSize(-1);
        if(Params.ORGANIZATIONLIST.size()== 0){
            return null;
        }for(int i = 0; i < Params.ORGANIZATIONLIST.size(); i +=1){
            if(Params.ORGANIZATIONLIST.get(i).getOrgSize() > bestOrg.getOrgSize()){
                bestOrg = Params.ORGANIZATIONLIST.get(i);
            }
        }
        return bestOrg.getOrgName();
    }


}
