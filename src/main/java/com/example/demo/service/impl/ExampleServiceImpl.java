package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.ExampleEntity;
import com.example.demo.mapper.ExampleMapper;
import com.example.demo.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * (Example)业务层实现
 *
 * @author code generation
 * @date 2019-11-22 20:33:06
 * @since JDK1.8
 */
@Slf4j
@Service
public class ExampleServiceImpl extends ServiceImpl<ExampleMapper, ExampleEntity> implements ExampleService {

    @Override
    public void saveBatch() throws RuntimeException {
        log.debug("------------ExampleServiceImpl------------>saveBatchSizeOne:{}", "开始批量插入");
        this.saveBatch(getBatch(), 1);
        log.debug("------------ExampleServiceImpl------------>saveBatchSizeOne:{}", "批量插入完成");
    }


    /**
     * 创建批量待插入数据
     *
     * @return List<ExampleEntity>${@link List<ExampleEntity>}
     * @author example
     * @date 2019-11-22 20:39
     */
    private List<ExampleEntity> getBatch() {
        List<ExampleEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExampleEntity entity = new ExampleEntity();
            entity.setPhone("1908977876" + i);
            entity.setUserName("test" + (i + 1));
            list.add(entity);
        }
        return list;
    }
}