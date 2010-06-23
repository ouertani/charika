package net.dikka.charika.blueprint
package reflect

import net.dikka.charika.blueprint.extender.impl.beans._
import org.osgi.service.blueprint.reflect._
import scala.collection.JavaConversions._

import net.dikka.charika.blueprint.extender.impl._
import net.dikka.charika.blueprint.extender.impl.beans._
import scala.xml.Node

trait TBeanMetadata extends BeanMetadata with TTarget with TComponentMetadata {

  val factoryComponent:TTarget
  val scope:Scope
  override def   getFactoryComponent():Target=factoryComponent

  override def getScope()=scope.scope

}

case class Bean (id:String,
                 activation:Activation,
                 scope:Scope ,
                 constructionParam: ConstructionParam,
                 construction :Construction,
                 callback :Callback)
extends Component(id,
                  activation,
                  constructionParam.
                  dependsOn) {

  need(id != null, "Id must not be null!")
  need(activation != null, "Activation must not be null!")
  need(scope != null, "Scope must not be null!")

  if(scope == Prototype) {
    need (callback.destroyMethod isEmpty,"The destroyMethod must not be set when the scope is prototype.")
    need (activation == Lazy, "The activation must not be set to eager if the bean also has prototype scope.")
  }
}


class BeanBuilder {
  private[this] var id:String=null
  private[this] var activation:Activation=Eager
  private[this] var scope:Scope = Singleton
  private[this] var constructionParam: ConstructionParam=new ConstructionParamBuilder()
  private[this] var construction :Construction= new ConstructionBuilder()
  private[this] var callback :Callback= new CallbackBuilder()


  def withId(id :String)={
    this.id=id
    this
  }
  def withActivation(activation:Activation)={
    this.activation=activation
    this
  }

  def withScope(scope:Scope)={
    this.scope=scope
    this
  }

  def withConstructionParam(constructionParam:ConstructionParam)={
    this.constructionParam=constructionParam
    this
  }

  def withConstruction(cosntruction :Construction)={
    this.construction= construction
    this
  }
  def withCallback(callback:Callback)={
    this.callback=callback
    this
  }


  def build = Bean (id, activation, scope, constructionParam,construction,callback)
}


class BeanParser extends ComponentParser [Bean] {

  override def parseElement ( node:Node):Bean ={


    Bean( node \ "@id"  text,
         activation = node \ "@activation" text,
         scope = node \ "@scope" text ,
         node,
         node,
         node
    )
  }
}
