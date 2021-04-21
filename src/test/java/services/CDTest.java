package services;

import entities.Artist;
import entities.CD;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class CDTest {

    private CdService service;

    @Before
    public void setUp() throws Exception {
        service = new CdService();
    }

    @Test
    public void findByIdTest() {
        //given
        CD cd = new CD();

        //when
        cd.setTitle("zipcode");
        cd.setPrice(1.99);

        CD actual = service.findById(1L);

        Assert.assertEquals(cd.getPrice(), actual.getPrice());
        //then
    }

    @Test
    public void findAllTest() {

        for (CD cd : service.findAll()) {
            System.out.println(cd);
        }
    }

    @Test
    public void updateTest() {

        CD cd = new CD();
        cd.setTitle("sounding");
        cd.setPrice(2.99);
        cd.setDescription("future tracks");
        cd.setYear(2032L);

        service.update(4L, cd);
        String expected = "sounding";
        String actual = service.findById(4l).getTitle();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void create() {
        CD cd = new CD();

        cd.setYear(1995L);
        cd.setDescription("classic audio");
        cd.setTitle("mixtape");
        cd.setPrice(21.99);

        service.create(cd);

        Long actual = service.findById(5L).getYear();
        Long expected = 1995L;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deleteTest() {
        service.delete(5L);

        Assert.assertEquals(null, service.findById(5L));

    }
}
