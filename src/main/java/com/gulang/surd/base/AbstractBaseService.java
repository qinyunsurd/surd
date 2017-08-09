package com.gulang.surd.base;

import java.util.List;

/**
 * @author: gulang
 * Create Date : 2017/8/9
 * Company     : Garden Plus
 * Description :
 */
public abstract class AbstractBaseService<K,V> {

    protected abstract BaseDao<K,V> getDao();
    /**
     * 通过一个实体对象,多条件进行查询
     * @param v Entity
     * @return Object
     */
    public V getObjectByEntity(final V v){
        return  getDao().getObjectByEntity(v);
    }

    /**
     * 添加一个对象
     * @param v 要保存的对象
     * @return  影响行数
     */
    public int saveObject(V v) {
        return getDao().saveObject(v);
    }

    /**
     * 批量插入对象
     * @param vs 插入的集合
     * @return 影响行数
     */
    public int insertBatch(List<V> vs) {
        return getDao().insertBatch(vs);
    }

    /**
     * 根据主键进行删除
     * @param k
     * @return
     */
    public int removeObject(K k) {
        return getDao().removeObject(k);
    }

    /**
     * 更新
     * @param v
     * @return
     */
    public int updateObject(V v) {
        return getDao().updateObject(v);
    }

}
