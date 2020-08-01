package com.pityubak.founder;

import com.pityubak.founder.data.Parameter;
import com.pityubak.founder.data.ParameterRegistration;
import com.pityubak.founder.data.Instance;
import com.pityubak.founder.service.InstanceService;
import com.pityubak.founder.service.NewInstanceService;
import com.pityubak.founder.service.SingletonInstanceService;

/**
 *
 * @author Pityubak
 */
public class Founder {

    private final InstanceService newInstanceService;
    private final InstanceService singletonService;

    private final ParameterRegistration paramReg;

    public Founder() {
        this.paramReg = new ParameterRegistration();
        this.newInstanceService = new NewInstanceService(paramReg);
        this.singletonService = new SingletonInstanceService(newInstanceService);
    }

    public void registerParameter(Class<?> cls, Parameter prm) {
        paramReg.registerParameter(cls, prm);
    }

    public <Q> Q createNewInstance(final Class<?> from) {
        Instance instance = new Instance.Builder(from).build();
        return newInstanceService.createInstance(instance);
    }

    public <Q> Q createSingleton(final Class<?> from, final String name) {
        Instance instance = new Instance.Builder(from)
                .withName(name)
                .build();
        return singletonService.createInstance(instance);
    }
}
