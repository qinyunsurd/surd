package com.gulang.surd.base;

import java.util.List;

/**
 * @author : gulang
 * Create Date : 2017/8/9
 * Company     : Garden Plus
 * Description :
 */
public interface BaseService<K,V> {
    /**
     * 通过一个实体对象,多条件进行查询
     * @param v Entity
     * @return Object
     */
    V getObjectByEntity(V v);

    /**
     * 添加一个对象
     * @param v 要保存的对象
     * @return  影响行数
     */
    int saveObject(V v);

    /**
     * 批量插入对象
     * @param vs 插入的集合
     * @return 影响行数
     */
    int insertBatch(List<V> vs);

    /**
     * 根据主键进行删除
     * @param k
     * @return
     */
    int removeObject(K k);

    /**
     * 更新
     * @param v
     * @return
     */
    int updateObject(V v);
}
