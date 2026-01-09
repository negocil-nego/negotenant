package com.negocil.nego_tenant.shared.repo

import com.negocil.nego_tenant.shared.model.ConcreteModel

interface ConcreteRepo<T: ConcreteModel>: CommonRepo<T>