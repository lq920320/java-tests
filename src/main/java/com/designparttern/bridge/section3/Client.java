package com.designparttern.bridge.section3;

/**
 * @author zetu
 * @desc
 * @date 2021/3/14
 */
public class Client {

    public static void main(String[] args) {
        House house = new House();
        System.out.println("------房地产公司是这么运行的------");
        // 先找到我的公司
        HouseCrop houseCrop = new HouseCrop(house);
        // 看我怎么赚钱
        houseCrop.makeMoney();

        System.out.println("");
        // 山寨公司山产的产品很多，不过我只要指定产品就成了
        System.out.println("------山寨公司是这么运行的------");
        ShanZhaiCrop shanZhaiIPodCrop = new ShanZhaiCrop(new IPod());
        shanZhaiIPodCrop.makeMoney();

        ShanZhaiCrop shanZhaiClothesCrop = new ShanZhaiCrop(new Clothes());
        shanZhaiClothesCrop.makeMoney();
    }
}
