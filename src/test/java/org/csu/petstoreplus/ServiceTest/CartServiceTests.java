package org.csu.petstoreplus.ServiceTest;

import org.csu.petstoreplus.petstore.entity.Cart;
import org.csu.petstoreplus.petstore.service.impl.CartServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTests {
    @Resource
    private CartServiceImpl cartService;

    //对getCartList进行测试【测试无问题】
//    @Test
//    public void getCartList(){
//        List<Cart> categoryList = cartService.getCartList("2");
//        System.out.println(categoryList);
//    }
//
//    @Test
//    public void getCartItem(){
//        Cart cart = cartService.getCartItem("1","1");
//        System.out.println(cart);
//    }

    @Test
    public void insertTheItemToCart(){
        Cart cart = new Cart();
        cart.setUserid("22");
        cart.setItemid("EST-10");
        cart.setProductid("3");
        cart.setName("3");
        cart.setInstock(true);
        cart.setQuantity(2);
        cart.setListprice(33.00);
        cart.setTotal(66.00);
        String result = cartService.insertTheItemToCart(cart);
        System.out.println(result);
    }

//    @Test
//    public void updateItemNumberInCart(){
//        Cart cart = new Cart();
//        cart.setUserid("2");
//        cart.setItemid("EST-10");
//
//        cart.setProductid("4");
//        cart.setName("32");
//        cart.setInstock(true);
//        cart.setQuantity(2);
//        cart.setListprice(33.00);
//        cart.setTotal(66.00);
//        int result = cartService.updateItemNumberInCart(cart);
//        System.out.println(result);
//    }
//
//    @Test
//    public void deleteTheItemOutCart(){
//        int result = cartService.deleteTheItemOutCart("2","EST-10");
//        System.out.println(result);
//    }
//
//    @Test
//    public void deleteAllItemOutCart(){
//        int result = cartService.deleteAllItemOutCart("11");
//        System.out.println(result);
//    }

}
