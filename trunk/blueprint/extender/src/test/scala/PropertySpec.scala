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


class PropertySpec extends SpecificationWithJUnit with Mockito {
  """The following attributes/elements are mutually exclusive
   • ref
   • value
   • An inlined object value""" in {
     val testComponent=Some(mock[Component])
     Property(None,Some("ref"),Some("value"),testComponent) must throwA[ComponentDefinitionException]
     Property(None,Some("ref"),Some("value"),None) must throwA[ComponentDefinitionException]
     Property(None,None,Some("value"),testComponent) must throwA[ComponentDefinitionException]
     Property(None,Some("ref"),None,testComponent) must throwA[ComponentDefinitionException]
     Property(None,None,None,None) must throwA[ComponentDefinitionException]

     Property(None,Some("ref"),None,None) mustNot throwA[ComponentDefinitionException]
     Property(None,None,Some("value"),None)  mustNot throwA[ComponentDefinitionException]
     Property(None,None,None,testComponent) mustNot throwA[ComponentDefinitionException]
  }
}
