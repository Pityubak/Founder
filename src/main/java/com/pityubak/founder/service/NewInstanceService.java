package com.pityubak.founder.service;

import com.pityubak.founder.data.ParameterRegistration;
import com.pityubak.founder.data.Instance;

/**
 *
 * @author Pityubak
 */
public final class NewInstanceService implements InstanceService {

    private final ParameterRegistration paramsReg;

    public NewInstanceService(ParameterRegistration paramsReg) {
        this.paramsReg = paramsReg;
    }

    @Override
    public <Q> Q createInstance(Instance target) {
        Class<?> cls = target.getCls();
        
        ExceptionService.create()
                .checkClassIsNotNull(cls)
                .throwOccuredException();
        
        Instantiation instantiate = new Instantiation(cls, paramsReg);
        return instantiate.build();
    }

}
