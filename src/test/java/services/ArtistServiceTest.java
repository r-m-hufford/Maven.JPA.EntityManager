package services;

import entities.Artist;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArtistServiceTest {
    ArtistService artistService;

    @Before
    public void setUp() throws Exception {
        artistService = new ArtistService();
    }

    @Test
    public void findById() {
        //given
        Artist artist = new Artist();

        //when
        artist.setFirstName("Ryan");
        artist.setLastName("Hufford");

        Artist actual = artistService.findById(2L);

        Assert.assertEquals(artist.getFirstName(), actual.getFirstName());
        //then
    }

    @Test
    public void findAll() {
    }
}