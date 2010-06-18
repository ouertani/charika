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

object TestComponent extends Component ("id:String", Eager, List())

class ArgumentSpec extends SpecificationWithJUnit with Mockito {
  """ The following attributes and elements are mutually exclusive:
   • ref
   • value
   • An inlined object value""" in {

    Argument(None,None,Some("ref"),Some("value"),Some(TestComponent)) must throwA[IllegalArgumentException]
    Argument(None,None,Some("ref"),Some("value"),None) must throwA[IllegalArgumentException]
    Argument(None,None,None,Some("value"),Some(TestComponent)) must throwA[IllegalArgumentException]
    Argument(None,None,Some("ref"),None,Some(TestComponent)) must throwA[IllegalArgumentException]
    Argument(None,None,None,None,None) must throwA[IllegalArgumentException]

    Argument(None,None,Some("ref"),None,None) mustNot throwA[IllegalArgumentException]
    Argument(None,None,None,Some("value"),None)  mustNot throwA[IllegalArgumentException]
    Argument(None,None,None,None,Some(TestComponent)) mustNot throwA[IllegalArgumentException]
  }
}
