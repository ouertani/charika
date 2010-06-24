package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.BeanMetadata

trait TBeanMetadata extends BeanMetadata with TTarget with TComponentMetadata


abstract class ABeanMetadata(classNmae:String,
                             initMethod:String ,
                             destroyMethod:String,
                             beanArguments:List[TBeanArgument],
                             beanProperties:List[TBeanProperty],
                             factoryMethod:String,
                             factoryComponent:TTarget,
                             scope:Scope) extends TComponentMetadata {



}

class BeanMetadataImpl(
  id :String ,
  activation:Activation ,
  dependsOns:List[String],
  classNmae:String,
  initMethod:String ,
  destroyMethod:String,
  beanArguments:List[TBeanArgument],
  beanProperties:List[TBeanProperty],
  factoryMethod:String,
  factoryComponent:TTarget,
  scope:Scope
) extends IComponentMetadata(id  , activation , dependsOns) {

  need(id != null, "Id must not be null!")
  need(activation != null, "Activation must not be null!")
  need(scope != null, "Scope must not be null!")

  if(scope == Prototype) {
    need (destroyMethod ==null ,"The destroyMethod must not be set when the scope is prototype.")
    need (activation == Lazy, "The activation must not be set to eager if the bean also has prototype scope.")
  }
}





