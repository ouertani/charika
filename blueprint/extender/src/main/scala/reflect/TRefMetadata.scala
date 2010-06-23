

package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect._
import scala.collection.JavaConversions._
import scala.xml.Node

trait TRefMetadata extends RefMetadata with TTarget with TNonNullMetadata{
  val ref:Option[String]
  override def  getComponentId= ref.getOrElse(null)
}
case class Ref(ref:Option[String]) extends TRefMetadata

class RefMetadataParser extends ComponentParser [TRefMetadata]  {

  override def parseElement ( value:Node):TRefMetadata ={
    val ref=value \ "@ref" text;
    if(ref !=null)Ref(Some(ref))
    else Ref(None)

  }
}
