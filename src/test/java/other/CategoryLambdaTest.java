package other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuqian
 * @date 2019/4/22  16:22
 */
public class CategoryLambdaTest {

    @Test
    public void categoryLambda() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(getCategories()));

        List<DealCategory> categoryChain = getFullChain(13);
        System.out.println(objectMapper.writeValueAsString(categoryChain));

        List<DealCategory> categoryChain1 = getFullChain(8);
        System.out.println(objectMapper.writeValueAsString(categoryChain1));
    }

    @Test
    public void filterSubClassTest() throws JsonProcessingException {
        // 当一个列表里既有子类 id 又有父类 id，那么过滤掉 子类 id ，剩余 父类 id
        ObjectMapper objectMapper = new ObjectMapper();
        List<Integer> categoryIds1 = new ArrayList<Integer>() {{
            add(6);   // parentId: 1
            add(13);  // parentId: 6
            add(7);   // parentId: 1
            add(4);   // parentId: 0
            add(5);   // parentId: 0
            add(11);  // parentId: 5
        }};
        System.out.println(objectMapper.writeValueAsString(categoryIds1));
        // expect: [6, 7, 4, 5]
        List<Integer> afterFilter = filterSubClass(categoryIds1);
        System.out.println(objectMapper.writeValueAsString(afterFilter));
        categoryIds1.add(1);
        List<Integer> afterFilter2 = filterSubClass(categoryIds1);
        System.out.println(objectMapper.writeValueAsString(afterFilter2));
    }

    private List<Integer> filterSubClass(List<Integer> categoryIds) {
        List<Integer> needToFilter = new ArrayList<>();
        categoryIds.forEach(categoryId -> {
            List<Integer> fullChainId = getFullChainId(categoryId);
            List<Integer> parentChainId = fullChainId.stream().filter(x -> !x.equals(categoryId)).collect(Collectors.toList());
            List<Integer> data = new ArrayList<>(categoryIds);
            data.retainAll(parentChainId);
            if (data.size() > 0) {
                needToFilter.add(categoryId);
            }
        });
        return categoryIds.stream().filter(x -> !needToFilter.contains(x)).collect(Collectors.toList());
    }

    private List<DealCategory> getCategories() {

        List<DealCategory> dealCategories = getAllData();  // 这条语句可能是从缓存中或者是从数据库中直接拉去符合条件的数据

        List<DealCategory> roots = dealCategories.stream().filter(dealCategory -> (dealCategory.getParentId() == 0)).collect(Collectors.toList());   //  过滤出 父节点为0 所有分类
        //  过滤出所有的字节点
        List<DealCategory> subs = dealCategories.stream().filter(dealCategory -> dealCategory.getParentId() != 0).collect(Collectors.toList());

        //  对根分类进行遍历操作 -------->>>>>>>> 递归操作

        roots.forEach(root -> buildSubs(root, subs));
        return roots;
    }

    private static void buildSubs(DealCategory Parent, List<DealCategory> subs) {
        List<DealCategory> children = subs.stream().filter(sub -> (sub.getParentId().equals(Parent.getId()))).collect(Collectors.toList());  //  获取子节点中属于父节点的分类
        //  递归判断开始
        if (!CollectionUtils.isEmpty(children)) { //  说明是有子类
            Parent.setChildren(children);   //  把该分类下的子类都构建关联关系
            children.forEach(child -> buildSubs(child, subs));//  再次递归构建
        }
    }

    private List<DealCategory> getFullChain(Integer childId) {
        List<DealCategory> dealCategories = getAllData();
        List<DealCategory> categoryChain = new ArrayList<>();
        DealCategory dealCategory = dealCategories.stream().filter(category -> childId.equals(category.getId())).findFirst().orElse(null);
        if (dealCategory != null) {
            categoryChain.add(dealCategory);
            Integer parentId = dealCategory.getParentId();
            while (parentId != 0) {
                Integer finalParentId = parentId;
                DealCategory parentCategory = dealCategories.stream().filter(category -> finalParentId.equals(category.getId())).findFirst().orElse(null);
                if (parentCategory != null) {
                    parentId = parentCategory.getParentId();
                    categoryChain.add(parentCategory);
                }
            }
        }
        return categoryChain;
    }

    private List<Integer> getFullChainId(Integer childId) {
        List<DealCategory> fullChain = getFullChain(childId);
        return fullChain.stream().map(DealCategory::getId).collect(Collectors.toList());
    }

    @Data
    private class DealCategory {
        private Integer id;
        private Integer parentId;
        private List<DealCategory> children;
    }

    private List<DealCategory> getAllData() {
        return new ArrayList<DealCategory>() {{
            add(new DealCategory() {{
                setId(1);
                setParentId(0);
            }});
            add(new DealCategory() {{
                setId(2);
                setParentId(0);
            }});
            add(new DealCategory() {{
                setId(3);
                setParentId(0);
            }});
            add(new DealCategory() {{
                setId(4);
                setParentId(0);
            }});
            add(new DealCategory() {{
                setId(5);
                setParentId(0);
            }});
            add(new DealCategory() {{
                setId(6);
                setParentId(1);
            }});
            add(new DealCategory() {{
                setId(7);
                setParentId(1);
            }});
            add(new DealCategory() {{
                setId(8);
                setParentId(3);
            }});
            add(new DealCategory() {{
                setId(9);
                setParentId(4);
            }});
            add(new DealCategory() {{
                setId(10);
                setParentId(4);
            }});
            add(new DealCategory() {{
                setId(11);
                setParentId(5);
            }});
            add(new DealCategory() {{
                setId(12);
                setParentId(4);
            }});
            add(new DealCategory() {{
                setId(13);
                setParentId(6);
            }});
            add(new DealCategory() {{
                setId(13);
                setParentId(6);
            }});
        }};
    }
}
