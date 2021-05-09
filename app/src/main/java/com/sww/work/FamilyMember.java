package com.sww.work;

/**
 * @description:
 * @author: shaowenwen
 * @create: 2021/05/07 16:59
 */
public class FamilyMember {

    public String sister;
    public String brother;

    public FamilyMember(String sister, String brother) {
        this.sister = sister;
        this.brother = brother;
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "sister='" + sister + '\'' +
                ", brother='" + brother + '\'' +
                '}';
    }

}
