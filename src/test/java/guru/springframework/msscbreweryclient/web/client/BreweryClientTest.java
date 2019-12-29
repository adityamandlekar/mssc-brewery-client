package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerByIdtest() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeertest() {
        BeerDto beerDto= BeerDto.builder().beerName("New Beer").build();
        URI uri= client.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }


    @Test
    void updateBeertest() {
        BeerDto beerDto= BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(), beerDto);
    }


    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }
}