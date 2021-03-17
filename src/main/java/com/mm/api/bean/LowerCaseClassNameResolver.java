package com.mm.api.bean;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;
import com.google.gson.Gson;

public class LowerCaseClassNameResolver extends TypeIdResolverBase {

    public LowerCaseClassNameResolver() { }

    @Override
    public String idFromValue(Object o) { return o.getClass().getSimpleName(); }

    @Override
    public String idFromValueAndType(Object o, Class<?> aClass) { return idFromValue(o); }

    @Override
    public JsonTypeInfo.Id getMechanism() { return JsonTypeInfo.Id.CUSTOM; }

    @Override
    public String toString() { return new Gson().toJson(this); }

}
