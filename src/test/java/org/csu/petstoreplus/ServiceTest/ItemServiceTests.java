package org.csu.petstoreplus.ServiceTest;

import org.csu.petstoreplus.petstore.entity.Item;
import org.csu.petstoreplus.petstore.service.impl.ItemServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTests
{
    @Resource
    private ItemServiceImpl itemService;

    //对 getItemList 方法进行测试【测试无问题】
    @Test
    public void getItemList()
    {
        List<Item> itemList = itemService.getItemListByProduct("RP-SN-01");
        System.out.println(itemList);
    }

    //对 getItemById 方法进行测试【测试无问题】
    @Test
    public void getItemById()
    {
        Item item = itemService.getItemById("EST-1");
        System.out.println(item);
    }

    //对 insertItem 方法进行测试
//    @Test
//    public void insertItem()
//    {
//        Item item=new Item();
//
//        item.setItemid("Aaa-a1");
//        item.setProductid("FI-SW-01");
//
//        item.setListprice(11.00);
//        item.setUnitcost(13.4);
//
//        item.setSupplier("1");
//        item.setStatus("S");
//        item.setAttr1("test1");
//        item.setAttr2("test2");
//        item.setAttr3("test3");
//        item.setAttr4("test4");
//        item.setAttr5("test5");
//
//        Integer result = itemService.insertItem(item);
//        System.out.println(result);
//    }
//
//    //对 deleteItem 方法进行测试
//    @Test
//    public void deleteItem()
//    {
//        Integer result = itemService.deleteItem("Aaa-a1");
//        System.out.println(result);
//    }
//
//    //对 updateItem 方法进行测试
//    @Test
//    public void updateItem()
//    {
//        Item item=new Item();
//
//        item.setItemid("Aaa-a1");
//        item.setProductid("K9-DL-01");
//
//        item.setListprice(11.0);
//        item.setUnitcost(12.0);
//
//        item.setSupplier("1");
//        item.setStatus("S2");
//        item.setAttr1("test12");
//        item.setAttr2("test22");
//        item.setAttr3("test32");
//        item.setAttr4("test42");
//        item.setAttr5("test52");
//
//        Integer result = itemService.updateItem(item);
//        System.out.println(result);
//    }

    //测试无问题
    @Test
    public void getItemListBySupplierId()
    {
        List<Item> itemList = itemService.getItemListBySupplierId("1");
        System.out.println(itemList);
    }

}
