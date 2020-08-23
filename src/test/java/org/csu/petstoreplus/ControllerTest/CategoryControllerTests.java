package org.csu.petstoreplus.ControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.csu.petstoreplus.petstore.entity.Category;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryControllerTests
{
    // MockMVC 的固定写法，用于测试控制器
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;
    private MockHttpSession session;

    //起到一个初始化 MockMVC 的作用
    @Before
    public void setupMock()
    {
        mvc = MockMvcBuilders.webAppContextSetup(wac).addFilter(((request, response, chain) -> {
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        })).build();

    }

    //对控制器getCategoryList方法进行测试【测试无问题】
    @Test
    public void getCategoryList() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/getCategoryList")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //对控制器getCategoryById方法进行测试【测试无问题】
    @Test
    public void getCategoryById() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/getCategoryById?categoryId=FISH")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //对控制器insertCategory方法进行测试【测试无问题】
    @Test
    public void insertCategory() throws Exception
    {
        Category category = new Category();
        category.setCatid("DRAGON");
        category.setName("Dragon-Golden");
        category.setDescn("This is a golden dragon");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(category);

        mvc.perform(MockMvcRequestBuilders.post("/insertCategory")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //对控制器updateCategory方法进行测试【测试无问题】
    @Test
    public void updateCategory() throws Exception {
        //准备测试数据，可以用json字符串，也可以用类实体，推荐用类实体，比较直观，不容易出错
        //String json="{\"catid\":\"DRAGON\",\"name\":\"UPDATE-NAME\",\"descn\":\"UPDATE-DESCN\"}";
        Category category=new Category();
        category.setCatid("DRAGON");
        category.setName("UPDATE-NAME");
        category.setDescn("UPDATE-DESCN");
        //将类对象中的值转换为json
        ObjectMapper mapper = new ObjectMapper();
        String json =mapper.writeValueAsString(category);
        //修改url测试
        mvc.perform(MockMvcRequestBuilders.put("/updateCategory")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.jsonPath("$.descn").value("chinese fox6"))
                .andDo(MockMvcResultHandlers.print());
    }

    //对控制器deleteCategory方法进行测试【测试无问题】
    @Test
    public void deleteCategory() throws Exception {
        //准备测试数据，可以用json字符串，也可以用类实体，推荐用类实体，比较直观，不容易出错
        //String json="{\"catid\":\"DRAGON\"}";
        Category category=new Category();
        category.setCatid("DRAGON");

        //将类对象中的值转换为json
        ObjectMapper mapper = new ObjectMapper();
        String json =mapper.writeValueAsString(category);
        //修改url测试
        mvc.perform(MockMvcRequestBuilders.delete("/deleteCategory")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}









