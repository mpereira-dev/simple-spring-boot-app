package com.boot;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * JUnit & Mockito examples
 */
public class ShipwreckControllerTest {

    @InjectMocks
    private ShipwreckController sc;

    @Mock
    private ShipwreckRepository shipwreckRepository;

    @Before
    public void init(){
        // Look at the mocks and see if they need to be setup together
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testShipwreckGet(){
        Shipwreck sw = new Shipwreck();
                  sw.setId(1L);
        // Provide the mocking behavior, when findOne is called on repo, returned the stubbed object
        // Now we don't need db or spring container and can properly unit test instead of integration test
        when(shipwreckRepository.findOne(1L)).thenReturn(sw);

        Shipwreck wreck = sc.get(1L);

        // Verify that the mock method is called exactly 1 time
        verify(shipwreckRepository).findOne(1L);

        //assertEquals(1L, wreck.getId().longValue());
        assertThat(wreck.getId(), is(1L));
    }
}