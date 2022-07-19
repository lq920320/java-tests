package other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * HashSet处理
 *
 * @author zetu
 * @date 2022/7/15
 */
public class SetTest {

    @Test
    public void setTest() {
        List<Sku> skuList = getTestList();

        Set<String> colorSet = skuList.stream().map(Sku::getColor).collect(Collectors.toSet());
        Set<String> specSet = skuList.stream().map(Sku::getSpec).collect(Collectors.toSet());

        System.out.println(colorSet);
        System.out.println(specSet);

        System.out.println("=========================");
        Set<String> colorSet2 = new LinkedHashSet<>();
        Set<String> specSet2 = new LinkedHashSet<>();
        for (Sku sku : skuList) {
            colorSet2.add(sku.getColor());
            specSet2.add(sku.getSpec());
        }
        System.out.println(colorSet2);
        System.out.println(specSet2);
    }

    private List<Sku> getTestList() {
        return new ArrayList<Sku>() {{
            add(new Sku(){{ setColor("红色"); setSpec("S");}});
            add(new Sku(){{ setColor("红色"); setSpec("M");}});
            add(new Sku(){{ setColor("红色"); setSpec("L");}});
            add(new Sku(){{ setColor("红色"); setSpec("XL");}});
            add(new Sku(){{ setColor("红色"); setSpec("XXL");}});
            add(new Sku(){{ setColor("白色"); setSpec("S");}});
            add(new Sku(){{ setColor("白色"); setSpec("M");}});
            add(new Sku(){{ setColor("白色"); setSpec("L");}});
            add(new Sku(){{ setColor("白色"); setSpec("XL");}});
            add(new Sku(){{ setColor("白色"); setSpec("XXL");}});
            add(new Sku(){{ setColor("黑色"); setSpec("S");}});
            add(new Sku(){{ setColor("黑色"); setSpec("M");}});
            add(new Sku(){{ setColor("黑色"); setSpec("L");}});
            add(new Sku(){{ setColor("黑色"); setSpec("XL");}});
            add(new Sku(){{ setColor("黑色"); setSpec("XXL");}});
            add(new Sku(){{ setColor("绿色"); setSpec("S");}});
            add(new Sku(){{ setColor("绿色"); setSpec("M");}});
            add(new Sku(){{ setColor("绿色"); setSpec("L");}});
            add(new Sku(){{ setColor("绿色"); setSpec("XL");}});
            add(new Sku(){{ setColor("绿色"); setSpec("XXL");}});
            add(new Sku(){{ setColor("紫色"); setSpec("S");}});
            add(new Sku(){{ setColor("紫色"); setSpec("M");}});
            add(new Sku(){{ setColor("紫色"); setSpec("L");}});
            add(new Sku(){{ setColor("紫色"); setSpec("XL");}});
            add(new Sku(){{ setColor("紫色"); setSpec("XXL");}});
        }};
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Sku {
        private String color;
        private String spec;
    }
}
