package org.csu.petstoreplus.petstore.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 观星
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    //order table
    @TableId
    private int orderid; //原来类型为 Integer
    private String userid;
    private Date orderdate; //原来类型为 LocalDate
    private String shipaddr1;
    private String shipaddr2;
    private String shipcity;
    private String shipstate;
    private String shipzip;
    private String shipcountry;
    private String billaddr1;
    private String billaddr2;
    private String billcity;
    private String billstate;
    private String billzip;
    private String billcountry;
    private String courier;
    private double totalprice; //原来类型为 BigDecimal
    private String billtofirstname;
    private String billtolastname;
    private String shiptofirstname;
    private String shiptolastname;
    private String creditcard;
    private String exprdate;
    private String cardtype;
    private String locale;
    private String itemid;
    private String imgUrl;

    public Orders initOrder(Account account) {

        Orders orders = new Orders();
        orders.userid = account.getUserid();
        orders.orderdate = new Date();

        orders.shiptofirstname = account.getFirstname();
        orders.shiptolastname = account.getLastname();
        orders.shipaddr1 = account.getAddr1();
        orders.shipaddr2 = account.getAddr2();
        orders.shipcity = account.getCity();
        orders.shipstate = account.getState();
        orders.shipzip = account.getZip();
        orders.shipcountry = account.getCountry();

        orders.billtofirstname = account.getFirstname();
        orders.billtolastname = account.getLastname();
        orders.billaddr1 = account.getAddr1();
        orders.billaddr2 = account.getAddr2();
        orders.billcity = account.getCity();
        orders.billstate = account.getState();
        orders.billzip = account.getZip();
        orders.billcountry = account.getCountry();

        orders.creditcard = "999 9999 9999 9999";
        orders.exprdate = "12/03";
        orders.cardtype = "Visa";
        orders.courier = "UPS";
        orders.locale = "CA";

        return orders;
    }

}
