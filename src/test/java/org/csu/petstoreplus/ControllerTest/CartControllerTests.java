package org.csu.petstoreplus.ControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.csu.petstoreplus.petstore.entity.Cart;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartControllerTests {
    // MockMVC 的固定写法，用于测试控制器
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;
    private MockHttpSession session;

    //起到一个初始化 MockMVC 的作用
    @Before
    public void setupMock()
    {
        //mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        mvc = MockMvcBuilders.webAppContextSetup(wac).addFilter(((request, response, chain) -> {
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        })).build();
//        session = new MockHttpSession();
//        Account account=new Account();
//        account.setUserid("2");
//        session.setAttribute("account",account); //拦截器那边会判断用户是否登录，所以这里注入一个用户
    }

    //对控制器 getCartList 方法进行测试【测试无问题】
//    @Test
//    public void getCartList() throws Exception
//    {
//
//        mvc.perform(MockMvcRequestBuilders.get("/getCartList?userId=2")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .session(session))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }

//    @Test
//    public void deleteTheItemOutCart() throws Exception
//    {
//        Map<String,String> map=new HashMap<>();
//        map.put("userid","2");
//        map.put("itemid","2");
//
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(map);
//        mvc.perform(MockMvcRequestBuilders.post("/deleteTheItemOutCart")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json)
//                .session(session))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }

    @Test
    public void insertTheItemToCart() throws Exception{
        Cart cart = new Cart();
        cart.setUserid("22133");
        cart.setItemid("EST-10");
        cart.setProductid("22");
        cart.setName("22");
        cart.setInstock(true);
        cart.setQuantity(2);
        cart.setListprice(2.00);
        cart.setTotal(4.00);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(cart);

        mvc.perform(MockMvcRequestBuilders.post("/insertTheItemToCart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

//    @Test
//    public void updateCart() throws Exception{
//        Cart cart = new Cart();
//        cart.setUserid("22");
//        cart.setItemid("EST-10");
//        cart.setProductid("22");
//        cart.setName("2233");
//        cart.setInstock(true);
//        cart.setQuantity(20);
//        cart.setListprice(2.00);
//        cart.setTotal(40.00);
//
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(cart);
//
//        mvc.perform(MockMvcRequestBuilders.post("/updateCart")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json)
//                .session(session))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }



}
