package net.dikka.charika.blueprint.extender.impl
package parser

import org.specs.SpecificationWithJUnit
import org.specs.mock.Mockito
import  net.dikka.charika.blueprint.extender.impl.beans._

class BeanParserSpec extends SpecificationWithJUnit with Mockito {



  """custructor with argument""" in {

    val xml = <bean id="id" class="clazz">
      <argument value="arg1" />
              </bean>

    new BeanParser().parseElement(xml
    ) mustEqual Bean("id",
                     Eager,
                     mock[Scope] ,
                     mock [ConstructionParam],
                     mock[Construction],
                     mock [Callback])
  }
    
}
