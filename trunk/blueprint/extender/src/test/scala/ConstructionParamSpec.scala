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




import org.osgi.service.blueprint.container.ComponentDefinitionException
import org.specs.SpecificationWithJUnit
import org.specs.mock.Mockito
import org.mockito.Matchers._

class ConstructionParamSpec extends SpecificationWithJUnit with Mockito {
  """index must be > 0.""" in {
    val component=Some(mock[Component])
    val arg1 =Argument(Some(-1),None, None,None,component)
    val arguments = List(arg1)
    ConstructionParam(List(),arguments,List())must throwA[ComponentDefinitionException]
  }


  """Either all arguments have a specified index or none have a specified index.""" in {
    val component=Some(mock[Component])
    val arg1 =Argument(Some(0),None, None,None,component)
    val arg2 =Argument(None,None, None,None,component)
    val arguments = List(arg1,arg2)
    ConstructionParam(List(),arguments,List())must throwA[ComponentDefinitionException]
  }



  """Either all arguments have a specified index or none have a specified index.""" in {
    val component=Some(mock[Component])
    val arg1 =Argument(Some(0),None, None,None,component)
    val arg2 =Argument(None,None, None,None,component)
    val arguments = List(arg1,arg2)
    ConstructionParam(List(),arguments,List())must throwA[ComponentDefinitionException]
  }


  """If indexes are specified, they must be unique and run from 0..(n-1), where n is the number of arguments.""" in {
    val component=Some(mock[Component])
    val arg1 =Argument(Some(0),None, None,None,component)
    val arg2 =Argument(Some(2),None, None,None,component)
    val arguments = List(arg1,arg2)
    ConstructionParam(List(),arguments,List())must throwA[ComponentDefinitionException]
  }


  """If indexes are specified, they must be unique and run from 0..(n-1), where n is the number of arguments.""" in {
    val component=Some(mock[Component])
    val arg1 =Argument(Some(1),None, None,None,component)
    val arg2 =Argument(Some(2),None, None,None,component)
    val arguments = List(arg1,arg2)
    ConstructionParam(List(),arguments,List())must throwA[ComponentDefinitionException]
  }

  """If indexes are specified, they must be unique and run from 0..(n-1), where n is the number of arguments.""" in {
    val component=Some(mock[Component])
    val arg1 =Argument(Some(0),None, None,None,component)
    val arg2 =Argument(Some(1),None, None,None,component)
    val arg3 =Argument(Some(1),None, None,None,component)
    val arguments = List(arg1,arg2,arg3)
    ConstructionParam(List(),arguments,List())must throwA[ComponentDefinitionException]
  }


  """If indexes are specified, they must be unique and run from 0..(n-1), where n is the number of arguments.""" in {
    val component=Some(mock[Component])
    val arg1 =Argument(Some(0),None, None,None,component)
    val arg2 =Argument(Some(0),None, None,None,component)
    val arg3 =Argument(Some(1),None, None,None,component)
    val arguments = List(arg1,arg2,arg3)
    ConstructionParam(List(),arguments,List())must throwA[ComponentDefinitionException]
  }

  """If indexes are specified, they must be unique and run from 0..(n-1), where n is the number of arguments.""" in {
    val component=Some(mock[Component])
    val arg1 =Argument(Some(0),None, None,None,component)
    val arg2 =Argument(Some(1),None, None,None,component)
    val arg3 =Argument(Some(2),None, None,None,component)
    val arguments = List(arg1,arg2,arg3)
    ConstructionParam(List(),arguments,List())mustNot throwA[ComponentDefinitionException]
  }
}
