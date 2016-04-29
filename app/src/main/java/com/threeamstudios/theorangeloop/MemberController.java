package com.threeamstudios.theorangeloop;
import com.threeamstudios.theorangeloop.Params;
/**
 * Created by Josh M on 3/25/2016.
 */
public class MemberController {

    public static Boolean busyMember(Member member){
        if(member.getOrganizationList().size() > Params.busyMember){
            return true;
        }else{
            return false;
        }
    }
    public static String bestOrgOfMem(Member member){
        Organization tmp = new Organization();
        if(member.getOrganizationList().size()!= 0){
            tmp = member.getOrganizationList().get(0);
            for(int i = 1; i < member.getOrganizationList().size(); i +=1) {
                if(member.getOrganizationList().get(i).getOrgSize() > tmp.getOrgSize()){
                    tmp = member.getOrganizationList().get(i);
                }
            }
            return tmp.getOrgName();
        }
        else{
            return null;
        }
    }


}
