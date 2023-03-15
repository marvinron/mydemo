package com.maviron.spring.springdemo.service.impl;

import com.maviron.spring.springdemo.dao.DmpTagNewDao;
import com.maviron.spring.springdemo.entity.DmpTagNew;
import com.maviron.spring.springdemo.service.DmpTagNewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * DMP标签（新）(DmpTagNew)表服务实现类
 *
 * @author makejava
 * @since 2023-03-07 14:42:54
 */
@Service("dmpTagNewService")
public class DmpTagNewServiceImpl implements DmpTagNewService {
    @Resource
    private DmpTagNewDao dmpTagNewDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DmpTagNew queryById(Integer id) {
        return this.dmpTagNewDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<DmpTagNew> queryAllByLimit(int offset, int limit) {
        return this.dmpTagNewDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dmpTagNew 实例对象
     * @return 实例对象
     */
    @Override
    public DmpTagNew insert(DmpTagNew dmpTagNew) {
        this.dmpTagNewDao.insert(dmpTagNew);
        return dmpTagNew;
    }

    /**
     * 修改数据
     *
     * @param dmpTagNew 实例对象
     * @return 实例对象
     */
    @Override
    public DmpTagNew update(DmpTagNew dmpTagNew) {
        this.dmpTagNewDao.update(dmpTagNew);
        return this.queryById(dmpTagNew.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dmpTagNewDao.deleteById(id) > 0;
    }

    @Override
    public List<DmpTagNew> queyyAll() {
        return this.dmpTagNewDao.queryAll();
    }
}
