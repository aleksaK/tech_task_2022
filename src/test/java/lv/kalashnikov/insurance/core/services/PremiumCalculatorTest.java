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

    @Autowired
    private ApplicationContext context;
    @Autowired private PremiumCalculator calculator;

    @Test
    public void start() {
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

}