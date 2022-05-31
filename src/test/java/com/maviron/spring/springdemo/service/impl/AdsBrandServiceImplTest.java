package com.maviron.spring.springdemo.service.impl;

import com.maviron.spring.springdemo.dao.AdsBrandDao;
import com.maviron.spring.springdemo.entity.AdsBrand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;

import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class AdsBrandServiceImplTest {
    @Mock
    AdsBrandDao adsBrandDao;

    @InjectMocks
    AdsBrandServiceImpl adsBrandServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testQueryById() throws Exception {
        when(adsBrandDao.queryById(anyInt())).thenReturn(new AdsBrand());
        when(adsBrandDao.update(any())).thenReturn(0);

        AdsBrand result = adsBrandServiceImpl.queryById(Integer.valueOf(0));
        Assert.assertEquals(new AdsBrand(), result);
    }

    @Test
    public void testQueryAllByLimit() throws Exception {
        when(adsBrandDao.queryAllByLimit(anyInt(), anyInt())).thenReturn(Arrays.<AdsBrand>asList(new AdsBrand()));

        List<AdsBrand> result = adsBrandServiceImpl.queryAllByLimit(0, 0);
        Assert.assertEquals(Arrays.<AdsBrand>asList(new AdsBrand()), result);
    }

    @Test
    public void testInsert() throws Exception {
        when(adsBrandDao.insert(any())).thenReturn(0);

        AdsBrand result = adsBrandServiceImpl.insert(new AdsBrand());
        Assert.assertEquals(new AdsBrand(), result);
    }

    @Test
    public void testUpdate() throws Exception {
        when(adsBrandDao.queryById(anyInt())).thenReturn(new AdsBrand());
        when(adsBrandDao.update(any())).thenReturn(0);

        AdsBrand result = adsBrandServiceImpl.update(new AdsBrand());
        Assert.assertEquals(new AdsBrand(), result);
    }

    @Test
    public void testDeleteById() throws Exception {
        when(adsBrandDao.deleteById(anyInt())).thenReturn(0);

        boolean result = adsBrandServiceImpl.deleteById(Integer.valueOf(0));
        Assert.assertEquals(true, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme