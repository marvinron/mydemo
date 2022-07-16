package com.maviron.spring.springdemo.service.impl;
import com.maviron.spring.springdemo.dao.AdsBrandDao;
import com.maviron.spring.springdemo.entity.AdsBrand;
import com.maviron.spring.springdemo.service.AdsBrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * (AdsBrand)表服务实现类
 *
 * @author makejava
 * @since 2022-04-07 10:37:51
 */
@Service("adsBrandService")
public class AdsBrandServiceImpl implements AdsBrandService {
    @Resource
    private AdsBrandDao adsBrandDao;
    private Lock lock = new ReentrantLock(true);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public AdsBrand queryById(Integer id) {
        //lock.lock();
        System.out.printf("线程%s进入方法%s\n",Thread.currentThread().getName(),"starting");
        AdsBrand adsBrand = new AdsBrand();
        adsBrand.setId(2);
        adsBrand.setBrandName("华为");
        adsBrand.setCategoryId(1);
        adsBrand.setAdvertiserId(100);
        //adsBrand = this.adsBrandDao.queryById(id);
        List<AdsBrand> adsBrands = this.adsBrandDao.queryAll(adsBrand);
        //if(adsBrand != null){
        //    adsBrand.setAdvertiserId(7666);
        //    int update = adsBrandDao.update(adsBrand);
        //}
        //lock.unlock();
        return adsBrands.get(0);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AdsBrand> queryAllByLimit(int offset, int limit) {
        return this.adsBrandDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param adsBrand 实例对象
     * @return 实例对象
     */
    @Override
    public AdsBrand insert(AdsBrand adsBrand) {
        this.adsBrandDao.insert(adsBrand);
        return adsBrand;
    }

    /**
     * 修改数据
     *
     * @param adsBrand 实例对象
     * @return 实例对象
     */
    @Override
    public AdsBrand update(AdsBrand adsBrand) {
        this.adsBrandDao.update(adsBrand);
        return this.queryById(adsBrand.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.adsBrandDao.deleteById(id) > 0;
    }
}
