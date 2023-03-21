package com.maviron.spring.springdemo.service.impl;

import com.maviron.spring.springdemo.entity.DmpTest;
import com.maviron.spring.springdemo.dao.DmpTestDao;
import com.maviron.spring.springdemo.service.DmpTestService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * 媒体应用包名(DmpTest)表服务实现类
 *
 * @author makejava
 * @since 2023-03-21 10:13:45
 */
@Service("dmpTestService")
public class DmpTestServiceImpl implements DmpTestService {
    @Resource
    private DmpTestDao dmpTestDao;

    /**
     * 新增数据
     *
     * @param dmpTest 实例对象
     * @return 实例对象
     */
    @Override
    public DmpTest insert(DmpTest dmpTest) {
        this.dmpTestDao.insert(dmpTest);
        return dmpTest;
    }
}
