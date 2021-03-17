package com.designparttern.bridge.section2;

import com.designparttern.bridge.section1.HouseCrop;

/**
 * @author zetu
 * @desc
 * @date 2021/3/14
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("------房地产公司是这么运行的------");
        // 先找到我的公司
        com.designparttern.bridge.section1.HouseCrop houseCrop = new HouseCrop();
        // 看我怎么赚钱
        houseCrop.makeMoney();

        System.out.println("");

        System.out.println("------山寨公司是这么运行的------");
        IPodCrop iPodCrop = new IPodCrop();
        iPodCrop.makeMoney();
    }
}
