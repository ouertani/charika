package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect._
import scala.xml.Node
sealed trait TReferenceMetadata extends ReferenceMetadata with TTarget with TServiceReferenceMetadata {
  val componentId :Option[String]
  override def getComponentId:String=componentId.getOrElse(null)
}
case class Reference(componentId :Option[String]) extends TReferenceMetadata

class ReferenceMetadataParser extends ComponentParser [TReferenceMetadata]  {
  import ValueMetadataBuilder._
  override def parseElement ( ref:Node):Value ={
    <<  withValue(ref \ "@ref" text)  withType(value \ "@type" text) >>
  }
}