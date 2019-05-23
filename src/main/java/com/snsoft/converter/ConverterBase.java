package com.snsoft.converter;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class ConverterBase<T, D> implements Converter<T, D> {

    public abstract T convert2Model(D d);

    public abstract D convert2Entity(T t);

    public final List<T> convert2ModelList(List<D> dList) {
        ArrayList<T> ts = new ArrayList<>();
        if (CollectionUtils.isEmpty(dList)) {
            return ts;
        }
        dList.forEach(p -> ts.add(convert2Model(p)));
        return ts;
    }

    public final List<D> convert2EntityList(List<T> tList) {
        ArrayList<D> ts = new ArrayList<>();
        if (CollectionUtils.isEmpty(tList)) {
            return ts;
        }
        tList.forEach(p -> ts.add(convert2Entity(p)));
        return ts;
    }
}
