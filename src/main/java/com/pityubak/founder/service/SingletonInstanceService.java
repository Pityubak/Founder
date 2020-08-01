package com.pityubak.founder.service;

import com.pityubak.founder.data.Instance;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pityubak
 */
public final class SingletonInstanceService implements InstanceService {

    private final InstanceService service;
    public final Map<String, Object> singletons = new HashMap<>();

    public SingletonInstanceService(InstanceService service) {
        this.service = service;
    }

    @Override
    public synchronized <Q> Q createInstance(final Instance instance) {
        final Class<?> from = instance.getCls();
        final String className = instance.getName();
        
        ExceptionService.create()
                .checkNameIsNotNull(className)
                .checkClassIsNotNull(from)
                .throwOccuredException();

        Object obj = singletons.get(className);

        if (obj == null) {
            obj = service.createInstance(instance);
        }

        singletons.put(className, obj);
        return (Q) obj;
    }

}
