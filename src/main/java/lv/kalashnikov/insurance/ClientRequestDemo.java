package lv.kalashnikov.insurance;

import lv.kalashnikov.insurance.core.domain.Entity;
import lv.kalashnikov.insurance.core.domain.Item;
import lv.kalashnikov.insurance.core.domain.Policy;
import lv.kalashnikov.insurance.core.domain.RiskType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ClientRequestDemo {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        List<Policy> policies = List.of(getPolicy1(), getPolicy2(), getPolicy3());
        String url = "https://insurance-calculator.9kcl8bj71rd4k.eu-central-1.cs.amazonlightsail.com:443/calculator/";

        policies.stream()
                .parallel()
                .map(policy -> sendRequest(restTemplate, url, policy))
                .forEach(System.out::println);

//        Double premium1 = restTemplate.postForObject(url, getPolicy1(), Double.class);
//        Double premium2 = restTemplate.postForObject(url, getPolicy2(), Double.class);
//        Double premium3 = restTemplate.postForObject(url, getPolicy3(), Double.class);
//        System.out.println("=====================================================================================================");
//        System.out.println("POLICY 1 PREMIUM IS: " + premium1);
//        System.out.println("POLICY 2 PREMIUM IS: " + premium2);
//        System.out.println("POLICY 3 PREMIUM IS: " + premium3);

    }

    private static Double sendRequest(RestTemplate restTemplate, String url, Policy policy) {
        return restTemplate.postForObject(url, policy, Double.class);
    }

    private static Policy getPolicy1() {
        Item item1 = new Item("Item1", 100, RiskType.FIRE);
        Item item2 = new Item("Item2", 8, RiskType.THEFT);
        List<Item> list1 = List.of(item1, item2);
        Entity entity1 = new Entity("Home1", list1);
        List<Entity> entities = List.of(entity1);
        return new Policy("1", true, entities);
    }

    private static Policy getPolicy2() {
        Item item3 = new Item("Item3", 500, RiskType.FIRE);
        Item item4 = new Item("Item4", 102.51, RiskType.THEFT);
        List<Item> list2 = List.of(item3, item4);
        Entity entity2 = new Entity("Home2", list2);
        List<Entity> entities = List.of(entity2);
        return new Policy("2", true, entities);
    }

    private static Policy getPolicy3() {
        Item item1 = new Item("Item1", 100, RiskType.FIRE);
        Item item2 = new Item("Item2", 8, RiskType.THEFT);
        Item item3 = new Item("Item3", 500, RiskType.FIRE);
        Item item4 = new Item("Item4", 102.51, RiskType.THEFT);
        List<Item> list1 = List.of(item1, item2);
        List<Item> list2 = List.of(item3, item4);
        Entity entity1 = new Entity("Home1", list1);
        Entity entity2 = new Entity("Home2", list2);
        List<Entity> entities = List.of(entity1, entity2);
        return new Policy("3", true, entities);
    }

}