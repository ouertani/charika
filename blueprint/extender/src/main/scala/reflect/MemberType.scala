package net.dikka.charika.blueprint
package reflect

sealed trait MemberType
{
  val intValue: Int
}
case object ObjectMemberType extends MemberType{
  override val intValue =1
}
case object ReferenceMemberType extends MemberType{
  override val intValue =2
}

