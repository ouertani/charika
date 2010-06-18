package net.dikka.charika.blueprint.extender.impl
package beans




import org.specs.SpecificationWithJUnit
import org.specs.mock.Mockito


class PropertySpec extends SpecificationWithJUnit with Mockito {
  """The following attributes/elements are mutually exclusive
   • ref
   • value
   • An inlined object value""" in {
     Property(None,Some("ref"),Some("value"),Some(TestComponent)) must throwA[IllegalArgumentException]
     Property(None,Some("ref"),Some("value"),None) must throwA[IllegalArgumentException]
     Property(None,None,Some("value"),Some(TestComponent)) must throwA[IllegalArgumentException]
     Property(None,Some("ref"),None,Some(TestComponent)) must throwA[IllegalArgumentException]
     Property(None,None,None,None) must throwA[IllegalArgumentException]

     Property(None,Some("ref"),None,None) mustNot throwA[IllegalArgumentException]
     Property(None,None,Some("value"),None)  mustNot throwA[IllegalArgumentException]
     Property(None,None,None,Some(TestComponent)) mustNot throwA[IllegalArgumentException]
  }
}
