/**
 * Copyright (c) 2010 DIKKA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License, v. 2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/
 *
 * Contributors:
 *   Slim Ouertani   - initial API and implementation
 *
 */
package net.dikka.charika.blueprint.extender.impl
package beans

import org.specs.SpecificationWithJUnit
import org.specs.mock.Mockito



class BeanSpec extends SpecificationWithJUnit with Mockito {

  """ The destroyMethod mustNot be set when the scope is prototype."""  in {
     Bean("id", Lazy, Prototype,
             ConstructionParam(List(),List(),List()),
             Construction( Some("class"), Some(" initMethod:String,"), Some(" destroyMethod")),
             Callback (None,Some(" factoryRef:String,"))
    )   must throwA[IllegalArgumentException]
  }





  """ The activation must not be set to eager if the bean also has prototype scope.""" in {
     Bean("id",
             Eager,
             Prototype,
             ConstructionParam(List(),List(),List()),
             Construction(Some("class"),  None, None),
             Callback(None, None)
    ) must throwA[IllegalArgumentException]

  }

  """The following combinations of arguments are valid, all other combinations are invalid:
• className
• className, factory-method
• factory-ref, factory-method
""" in {
    Bean ("id",  Lazy, Singleton,
          ConstructionParam(List(),List(),List()),
          Construction(Some("class"), None,None),
          Callback( Some("init"), Some("destroy"))
    )


    Bean ("id",
          Lazy,
          Singleton,
          ConstructionParam(List(),List(),List()),
          Construction(Some("class"), Some("factory-method"),None),
          Callback(None, None)
    )


    Bean ("id",
          Lazy,
          Singleton,
          ConstructionParam(List(),List(),List()),
          Construction(None, Some("factory-method"),Some("factory-ref")),
          Callback(None, None)
    )


    Bean ("id",
          Lazy,
          Singleton,
          ConstructionParam(List(),List(),List()),
          Construction(None, None,None),
          Callback(None, None)
    )must throwA[IllegalArgumentException]

    Bean ("id",
          Lazy,
          Singleton,
          ConstructionParam(List(),List(),List()),
          Construction(Some(""), Some(""),Some("")),
          Callback(None, None)
    )must throwA[IllegalArgumentException]
  }
}

 
  
