package net.dikka.charika.blueprint
package reflect



import org.osgi.service.blueprint.reflect._
import scala.collection.JavaConversions._
import scala.xml.Node


sealed trait TValueMetadata extends ValueMetadata with TNonNullMetadata {
  val value:Option[String]
  val tipe:Option[String]
  override def  getStringValue():String= value.getOrElse(null)
  override def  getType():String=tipe.getOrElse(null)

}

case class Value( value:Option[String] , tipe:Option[String] ) extends  TValueMetadata

private [this] object ValueMetadataBuilder {
  def << =  new ValueMetadataBuilder()
}

private [this] class ValueMetadataBuilder {
  private [this] var value:Option[String]=None
  private [this] var tipe:Option[String]=None

  def withValue(value :String) = {
    if(value != null) {
      this.value=Some(value)
    }
    this
  }
  def withType(tipe : String) ={
    if(tipe !=null){
      this.tipe=Some(tipe)
    }
    this
  }

  def >>  = Value(value,tipe)


 
}

class ValueMetadataParser extends ComponentParser [Value]  {
  import ValueMetadataBuilder._
  override def parseElement ( value:Node):Value ={
    <<  withValue(value \ "@value" text)  withType(value \ "@type" text) >>
  }
}


  