package br.com.nemeia.pc.webscraper.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreTest {

    @Test
    public void instantiate() {
        Store store = Store.KABUM;
        Assertions.assertEquals("KaBuM!", store.toString());
    }

}
