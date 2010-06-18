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


class PropertySpec extends SpecificationWithJUnit with Mockito {
  """The following attributes/elements are mutually exclusive
   • ref
   • value
   • An inlined object value""" in {
     val TestComponent=Some(mock[Component])
     Property(None,Some("ref"),Some("value"),TestComponent) must throwA[IllegalArgumentException]
     Property(None,Some("ref"),Some("value"),None) must throwA[IllegalArgumentException]
     Property(None,None,Some("value"),TestComponent) must throwA[IllegalArgumentException]
     Property(None,Some("ref"),None,TestComponent) must throwA[IllegalArgumentException]
     Property(None,None,None,None) must throwA[IllegalArgumentException]

     Property(None,Some("ref"),None,None) mustNot throwA[IllegalArgumentException]
     Property(None,None,Some("value"),None)  mustNot throwA[IllegalArgumentException]
     Property(None,None,None,TestComponent) mustNot throwA[IllegalArgumentException]
  }
}
