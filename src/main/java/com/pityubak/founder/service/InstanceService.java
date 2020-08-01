package com.pityubak.founder.service;

import com.pityubak.founder.data.Instance;

/**
 *
 * @author Pityubak
 */
public interface InstanceService {

    <Q> Q createInstance(Instance instance);

}
