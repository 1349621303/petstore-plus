package org.csu.petstoreplus.ServiceTest;

import org.csu.petstoreplus.petstore.entity.Inventory;
import org.csu.petstoreplus.petstore.service.impl.InventoryServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InventoryServiceTests {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;
    //private MockHttpSession session;

    //起到一个初始化 MockMVC 的作用
    @Before
    public void setupMock()
    {
        mvc = MockMvcBuilders.webAppContextSetup(wac).addFilter(((request, response, chain) -> {
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        })).build();
    }

    @Resource
    private InventoryServiceImpl inventoryService;

    //测试无问题
    @Test
    public void getQtyBySupplier()
    {
        Inventory inventory = inventoryService.getQtyByItemId("EST-10");
        System.out.println(inventory);
    }

    //测试无问题
//    @Test
//    public void updateQtyBySupplier(){
//        Inventory inventory = new Inventory();
//        inventory.setItemid("EST-25");
//        inventory.setQty(100);
//        Integer result = inventoryService.updateQtyBySupplier(inventory);
//        System.out.println(result);
//    }


}
