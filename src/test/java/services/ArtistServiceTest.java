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
        artist.setFirstName("ryan");
        artist.setLastName("hufford");

        Artist actual = artistService.findById(2L);

        Assert.assertEquals(artist.getFirstName(), actual.getFirstName());
        //then
    }

    @Test
    public void findAll() {

        System.out.println(artistService.findAll());
    }

    @Test
    public void updateTest() {

        Artist artist = new Artist();
        artist.setFirstName("Sam");
        artist.setLastName("Samuel");

        artistService.update(10L, artist);
        String expected = "Sam";
        String actual = artistService.findById(10l).getFirstName();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void createTest() {
        Artist artist = new Artist();
        artist.setFirstName("Bo");
        artist.setLastName("Jangles");
        artist.setInstrument("vocals");

        artistService.create(artist);
        String expected = "Bo";
        String actual = artistService.findById(11L).getFirstName();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deleteTest() {

        artistService.delete(12L);

        Assert.assertEquals(null, artistService.findById(11L));
    }

}