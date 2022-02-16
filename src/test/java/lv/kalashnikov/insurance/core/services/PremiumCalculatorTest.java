package lv.kalashnikov.insurance.core.services;

import lv.kalashnikov.insurance.config.SpringCoreConfig;
import lv.kalashnikov.insurance.core.domain.Entity;
import lv.kalashnikov.insurance.core.domain.Item;
import lv.kalashnikov.insurance.core.domain.Policy;
import lv.kalashnikov.insurance.core.domain.RiskType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringCoreConfig.class})
public class PremiumCalculatorTest {

    @Autowired private ApplicationContext context;
    @Autowired private PremiumCalculator calculator;

    @Test
    public void contextMustNotBeNull() {
        assertNotNull(context);
    }

    @Test
    public void shouldCalculateOneObjectPolicyPremium1() {
        Item item1 = new Item("Item1", 100, RiskType.FIRE);
        Item item2 = new Item("Item2", 8, RiskType.THEFT);
        List<Item> list = List.of(item1, item2);
        Entity entity = new Entity("Home", list);
        List<Entity> entities = List.of(entity);
        Policy policy = new Policy("1", true, entities);
        assertEquals(2.28, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateOneObjectPolicyPremium2() {
        Item item1 = new Item("Item1", 500, RiskType.FIRE);
        Item item2 = new Item("Item2", 102.51, RiskType.THEFT);
        List<Item> list = List.of(item1, item2);
        Entity entity = new Entity("Home", list);
        List<Entity> entities = List.of(entity);
        Policy policy = new Policy("2", true, entities);
        assertEquals(17.13, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateOneObjectPolicyPremium3() {
        Item item1 = new Item("Item1", 25, RiskType.FIRE);
        Item item2 = new Item("Item2", 5, RiskType.THEFT);
        Item item3 = new Item("Item3", 15.5, RiskType.FIRE);
        List<Item> list = List.of(item1, item2, item3);
        Entity entity = new Entity("Home", list);
        List<Entity> entities = List.of(entity);
        Policy policy = new Policy("3", true, entities);
        assertEquals(1.12, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateOneObjectPolicyPremium4() {
        Item item1 = new Item("Item1", 2.5, RiskType.THEFT);
        Item item2 = new Item("Item2", 7, RiskType.THEFT);
        Item item3 = new Item("Item3", 3.2, RiskType.THEFT);
        List<Item> list = List.of(item1, item2, item3);
        Entity entity = new Entity("Home", list);
        List<Entity> entities = List.of(entity);
        Policy policy = new Policy("4", true, entities);
        assertEquals(1.40, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateOneObjectPolicyPremium5() {
        Item item1 = new Item("Item1", 2.5, RiskType.THEFT);
        Item item2 = new Item("Item2", 7, RiskType.THEFT);
        Item item3 = new Item("Item3", 10, RiskType.THEFT);
        List<Item> list = List.of(item1, item2, item3);
        Entity entity = new Entity("Home", list);
        List<Entity> entities = List.of(entity);
        Policy policy = new Policy("5", true, entities);
        assertEquals(0.98, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateOneObjectPolicyPremium6() {
        Item item1 = new Item("Item1", 10, RiskType.FIRE);
        Item item2 = new Item("Item2", 23.25, RiskType.FIRE);
        Item item3 = new Item("Item3", 43.98, RiskType.FIRE);
        List<Item> list = List.of(item1, item2, item3);
        Entity entity = new Entity("Home", list);
        List<Entity> entities = List.of(entity);
        Policy policy = new Policy("6", true, entities);
        assertEquals(1.08, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateOneObjectPolicyPremium7() {
        Item item1 = new Item("Item1", 10, RiskType.FIRE);
        Item item2 = new Item("Item2", 23.25, RiskType.FIRE);
        Item item3 = new Item("Item3", 75, RiskType.FIRE);
        List<Item> list = List.of(item1, item2, item3);
        Entity entity = new Entity("Home", list);
        List<Entity> entities = List.of(entity);
        Policy policy = new Policy("7", true, entities);
        assertEquals(2.60, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateOneObjectPolicyPremium8() {
        Item item1 = new Item("Item1", 25, RiskType.FIRE);
        Item item2 = new Item("Item2", 25, RiskType.FIRE);
        Item item3 = new Item("Item3", 50, RiskType.FIRE);
        List<Item> list = List.of(item1, item2, item3);
        Entity entity = new Entity("Home", list);
        List<Entity> entities = List.of(entity);
        Policy policy = new Policy("8", true, entities);
        assertEquals(1.4, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateOneObjectPolicyPremium9() {
        Item item1 = new Item("Item1", 25, RiskType.FIRE);
        Item item2 = new Item("Item2", 25, RiskType.FIRE);
        Item item3 = new Item("Item3", 50.01, RiskType.FIRE);
        List<Item> list = List.of(item1, item2, item3);
        Entity entity = new Entity("Home", list);
        List<Entity> entities = List.of(entity);
        Policy policy = new Policy("9", true, entities);
        assertEquals(2.40, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateOneObjectPolicyPremium10() {
        Item item1 = new Item("Item1", 3, RiskType.THEFT);
        Item item2 = new Item("Item2", 7, RiskType.THEFT);
        Item item3 = new Item("Item3", 5, RiskType.THEFT);
        List<Item> list = List.of(item1, item2, item3);
        Entity entity = new Entity("Home", list);
        List<Entity> entities = List.of(entity);
        Policy policy = new Policy("10", true, entities);
        assertEquals(0.75, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateOneObjectPolicyPremium11() {
        Item item1 = new Item("Item1", 3, RiskType.THEFT);
        Item item2 = new Item("Item2", 7, RiskType.THEFT);
        Item item3 = new Item("Item3", 4.99, RiskType.THEFT);
        List<Item> list = List.of(item1, item2, item3);
        Entity entity = new Entity("Home", list);
        List<Entity> entities = List.of(entity);
        Policy policy = new Policy("11", true, entities);
        assertEquals(1.65, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateOneObjectPolicyPremium12() {
        Item item1 = new Item("Item1", 3, RiskType.THEFT);
        Item item2 = new Item("Item2", 7, RiskType.THEFT);
        Item item3 = new Item("Item3", 4.99, RiskType.THEFT);
        Item item4 = new Item("Item4", 25, RiskType.FIRE);
        Item item5 = new Item("Item5", 75, RiskType.FIRE);
        List<Item> list = List.of(item1, item2, item3, item4, item5);
        Entity entity = new Entity("Home", list);
        List<Entity> entities = List.of(entity);
        Policy policy = new Policy("12", true, entities);
        assertEquals(3.05, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateOneObjectPolicyPremium13() {
        Item item1 = new Item("Item1", 3, RiskType.THEFT);
        Item item2 = new Item("Item2", 7, RiskType.THEFT);
        Item item3 = new Item("Item3", 5, RiskType.THEFT);
        Item item4 = new Item("Item4", 25, RiskType.FIRE);
        Item item5 = new Item("Item5", 75, RiskType.FIRE);
        List<Item> list = List.of(item1, item2, item3, item4, item5);
        Entity entity = new Entity("Home", list);
        List<Entity> entities = List.of(entity);
        Policy policy = new Policy("13", true, entities);
        assertEquals(2.15, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateOneObjectPolicyPremium14() {
        Item item1 = new Item("Item1", 3, RiskType.THEFT);
        Item item2 = new Item("Item2", 7, RiskType.THEFT);
        Item item3 = new Item("Item3", 4.99, RiskType.THEFT);
        Item item4 = new Item("Item4", 25.01, RiskType.FIRE);
        Item item5 = new Item("Item5", 75, RiskType.FIRE);
        List<Item> list = List.of(item1, item2, item3, item4, item5);
        Entity entity = new Entity("Home", list);
        List<Entity> entities = List.of(entity);
        Policy policy = new Policy("14", true, entities);
        assertEquals(4.05, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateOneObjectPolicyPremium15() {
        Item item1 = new Item("Item1", 3, RiskType.THEFT);
        Item item2 = new Item("Item2", 7, RiskType.THEFT);
        Item item3 = new Item("Item3", 5, RiskType.THEFT);
        Item item4 = new Item("Item4", 25.01, RiskType.FIRE);
        Item item5 = new Item("Item5", 75, RiskType.FIRE);
        List<Item> list = List.of(item1, item2, item3, item4, item5);
        Entity entity = new Entity("Home", list);
        List<Entity> entities = List.of(entity);
        Policy policy = new Policy("15", true, entities);
        assertEquals(3.15, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateMultipleObjectsPolicyPremium1() {
        Item item1 = new Item("Item1", 3, RiskType.THEFT);
        Item item2 = new Item("Item2", 7, RiskType.THEFT);
        Item item3 = new Item("Item3", 5, RiskType.THEFT);
        Item item4 = new Item("Item4", 25.01, RiskType.FIRE);
        Item item5 = new Item("Item5", 75, RiskType.FIRE);
        Item item6 = new Item("Item6", 32.25, RiskType.FIRE);
        Item item7 = new Item("Item7", 23, RiskType.THEFT);
        Item item8 = new Item("Item8", 15, RiskType.FIRE);
        List<Item> list1 = List.of(item1);
        List<Item> list2 = List.of(item2, item3, item4, item5, item6, item7, item8);
        Entity entity1 = new Entity("Home1", list1);
        Entity entity2 = new Entity("Home2", list2);
        List<Entity> entities = List.of(entity1, entity2);
        Policy policy = new Policy("16", true, entities);
        assertEquals(5.43, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateMultipleObjectsPolicyPremium2() {
        Item item1 = new Item("Item1", 3, RiskType.THEFT);
        Item item2 = new Item("Item2", 7, RiskType.THEFT);
        Item item3 = new Item("Item3", 5, RiskType.THEFT);
        Item item4 = new Item("Item4", 25.01, RiskType.FIRE);
        Item item5 = new Item("Item5", 75, RiskType.FIRE);
        Item item6 = new Item("Item6", 32.25, RiskType.FIRE);
        Item item7 = new Item("Item7", 23, RiskType.THEFT);
        Item item8 = new Item("Item8", 15, RiskType.FIRE);
        List<Item> list1 = List.of(item1, item5, item8);
        List<Item> list2 = List.of(item2, item3, item4, item6, item7);
        Entity entity1 = new Entity("Home1", list1);
        Entity entity2 = new Entity("Home2", list2);
        List<Entity> entities = List.of(entity1, entity2);
        Policy policy = new Policy("17", true, entities);
        assertEquals(5.43, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateMultipleObjectsPolicyPremium3() {
        Item item1 = new Item("Item1", 3, RiskType.THEFT);
        Item item2 = new Item("Item2", 2, RiskType.THEFT);
        Item item3 = new Item("Item3", 1, RiskType.THEFT);
        Item item4 = new Item("Item4", 25.01, RiskType.FIRE);
        Item item5 = new Item("Item5", 75, RiskType.FIRE);
        Item item6 = new Item("Item6", 32.25, RiskType.FIRE);
        Item item7 = new Item("Item7", 8.99, RiskType.THEFT);
        Item item8 = new Item("Item8", 15, RiskType.FIRE);
        List<Item> list1 = List.of(item1, item5, item8);
        List<Item> list2 = List.of(item2, item3, item4, item6, item7);
        Entity entity1 = new Entity("Home1", list1);
        Entity entity2 = new Entity("Home2", list2);
        List<Entity> entities = List.of(entity1, entity2);
        Policy policy = new Policy("18", true, entities);
        assertEquals(5.18, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateMultipleObjectsPolicyPremium4() {
        Item item1 = new Item("Item1", 3, RiskType.THEFT);
        Item item2 = new Item("Item2", 7, RiskType.THEFT);
        Item item3 = new Item("Item3", 5, RiskType.THEFT);
        Item item4 = new Item("Item4", 25, RiskType.FIRE);
        Item item5 = new Item("Item5", 15, RiskType.FIRE);
        Item item6 = new Item("Item6", 48, RiskType.FIRE);
        Item item7 = new Item("Item7", 23, RiskType.THEFT);
        Item item8 = new Item("Item8", 12, RiskType.FIRE);
        List<Item> list1 = List.of(item1, item5, item8);
        List<Item> list2 = List.of(item2, item3, item4, item6, item7);
        Entity entity1 = new Entity("Home1", list1);
        Entity entity2 = new Entity("Home2", list2);
        List<Entity> entities = List.of(entity1, entity2);
        Policy policy = new Policy("19", true, entities);
        assertEquals(3.3, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateMultipleObjectsPolicyPremium5() {
        Item item1 = new Item("Item1", 1500, RiskType.THEFT);
        Item item2 = new Item("Item2", 425, RiskType.THEFT);
        Item item3 = new Item("Item3", 5250.25, RiskType.THEFT);
        Item item4 = new Item("Item4", 5000, RiskType.FIRE);
        Item item5 = new Item("Item5", 25750, RiskType.FIRE);
        Item item6 = new Item("Item6", 8500, RiskType.FIRE);
        Item item7 = new Item("Item7", 350.50, RiskType.THEFT);
        Item item8 = new Item("Item8", 1150, RiskType.FIRE);
        List<Item> list1 = List.of(item1, item2, item3, item7);
        List<Item> list2 = List.of(item4, item5, item6, item8);
        Entity entity1 = new Entity("Home1", list1);
        Entity entity2 = new Entity("Home2", list2);
        List<Entity> entities = List.of(entity1, entity2);
        Policy policy = new Policy("20", true, entities);
        assertEquals(1345.89, calculator.calculate(policy), 0.001);
    }

    @Test
    public void shouldCalculateMultipleObjectsPolicyPremium6() {
        Item item1 = new Item("Item1", 3, RiskType.THEFT);
        Item item2 = new Item("Item2", 2, RiskType.THEFT);
        Item item3 = new Item("Item3", 1, RiskType.THEFT);
        Item item4 = new Item("Item4", 25.01, RiskType.FIRE);
        Item item5 = new Item("Item5", 75, RiskType.FIRE);
        Item item6 = new Item("Item6", 32.25, RiskType.FIRE);
        Item item7 = new Item("Item7", 8.99, RiskType.THEFT);
        Item item8 = new Item("Item8", 15, RiskType.FIRE);
        List<Item> list1 = List.of(item1, item4);
        List<Item> list2 = List.of(item2, item5, item8);
        List<Item> list3 = List.of(item3, item6, item7);
        Entity entity1 = new Entity("Home1", list1);
        Entity entity2 = new Entity("Home2", list2);
        Entity entity3 = new Entity("Home3", list3);
        List<Entity> entities = List.of(entity1, entity2, entity3);
        Policy policy = new Policy("21", true, entities);
        assertEquals(5.18, calculator.calculate(policy), 0.001);
    }

}