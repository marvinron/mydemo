package com.maviron.spring.springdemo.service.impl;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.maviron.spring.springdemo.dao.AdsBrandDao;
import com.maviron.spring.springdemo.entity.AdPlanInfo;
import com.maviron.spring.springdemo.entity.AdsBrand;
import com.maviron.spring.springdemo.entity.Employee;
import com.maviron.spring.springdemo.service.AdsAbBrandService;
import com.maviron.spring.springdemo.service.AdsBrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * (AdsBrand)表服务实现类
 *
 * @author makejava
 * @since 2022-04-07 10:37:51
 */
@Service("adsBrandService")
public class AdsBrandServiceImpl extends AdsAbBrandService<AdPlanInfo,Employee> implements AdsBrandService {
    @Resource
    private AdsBrandDao adsBrandDao;
    private Object lock =new Object();
    //private Lock lock =new ReentrantLock(true);

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
        adsBrand.setId(1);
        //adsBrand.setBrandName("华为");
        //adsBrand.setCategoryId(1);
        //adsBrand.setAdvertiserId(100);
        //adsBrand = this.adsBrandDao.queryById(id);
        List<AdsBrand> adsBrands = this.adsBrandDao.queryAll(adsBrand);
        //int i = adsBrandDao.deleteById(1);
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
    public List<AdsBrand> queryAllByLimit(int offset, int limit) {
        return this.adsBrandDao.queryAllByLimit(offset, limit);
    }

    @Override
    public AdsBrand test(Integer id) {

        long start = System.currentTimeMillis();
        //lock.lock();
        AdsBrand adsBrand = new AdsBrand();
        synchronized (lock){
            adsBrand = queryById(id);
        }
        //lock.unlock();
        long end = System.currentTimeMillis();
        System.out.println((end - start));
        return adsBrand;
    }

    public static void main(String[] args) {
        String replace = UUID.randomUUID().toString().replace("-", "");
        System.out.println(replace);
        MailAccount account = new MailAccount();
        account.setHost("smtp.exmail.qq.com");
        account.setPort(465);
        account.setAuth(true);
        account.setFrom("houlei@gameley.com");
        account.setUser("houlei@gameley.com");
        account.setPass("hGkdHUSHE2QjxwHo");
        account.setSslEnable(true);
        MailUtil.send(account, "houlei@gameley.com", "订单预警邮件","无效包名占比超过阈值，预警值为", false);
    }

    @Override
    public AdPlanInfo convert(String str) {
        return null;
    }

    @Override
    public Employee getResult(String result) {
        return null;
    }
}
