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
