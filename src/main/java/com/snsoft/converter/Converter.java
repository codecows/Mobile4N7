package com.snsoft.converter;

import java.util.List;

public interface Converter<T, D> {

    T convert2Model(D d);

    D convert2Entity(T t);

    List<T> convert2ModelList(List<D> dList);

    List<D> convert2EntityList(List<T> tList);
}
